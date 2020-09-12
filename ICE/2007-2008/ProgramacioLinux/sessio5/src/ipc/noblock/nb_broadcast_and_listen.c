/* nb_broadcast_and_listen.c
 * Copyright Mark Watson 1999. Open Source Software License.
 *
 * Sample broadcast using Multicast IP and non-blocking sockets.
 * You must rebuild your Linux kernel to support Multicast IP
 * and you have to issue something like this (as root):
 *   route add -net 224.0.0.0 netmask 240.0.0.0 dev lo
 *
 * Note: this example was derived from the multicast IP broadcast
 *       example, and is very similar.
 */

#include <stdio.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>
#include <fcntl.h>
 
int port = 6789;

char * host_name = "224.0.0.1"; // local host (multicast IP)

void main() {
  // for setting up for broadcast:
  int out_socket_descriptor;
  struct sockaddr_in address;
  // for setting up for listening for broadcasts
  struct ip_mreq command;
  u_char loop = 1;  // we want broadcast to also loop back to this computer
  int i, iter = 0;
  int sin_len;
  char message[256];
  int in_socket_descriptor;
  struct sockaddr_in sin;
  struct hostent *server_host_name;

  long save_file_flags;

  // For broadcasting, this socket can be treated like a UDP socket:
  out_socket_descriptor = socket(AF_INET, SOCK_DGRAM, 0);
  if (out_socket_descriptor == -1) {
    perror("Opening socket");
    exit(1);
  }

  // allow multiple processes to use this same port:
  loop = 1;
  if (setsockopt(out_socket_descriptor, SOL_SOCKET, SO_REUSEADDR,
		 &loop, sizeof(loop)) < 0) {
    perror("setsockopt(allow multiple socket use");
  }
  memset(&address, 0, sizeof(address));
  address.sin_family = AF_INET;
  address.sin_addr.s_addr = inet_addr("224.0.0.1");
  address.sin_port = htons(port);

  // Set up for listening:
   if ((server_host_name = gethostbyname(host_name)) == 0) {
    perror("Error resolving local host\n");
    exit(1);
  }

  bzero(&sin, sizeof(sin));
  sin.sin_family = AF_INET;
  sin.sin_addr.s_addr = htonl(INADDR_ANY);
  sin.sin_port = htons(port);

  if ((in_socket_descriptor = socket(PF_INET, SOCK_DGRAM, 0)) == -1) {
    perror("Error opening socket\n");
    exit(1);
  }

  // allow multiple processes to use this same port:
  loop = 1;
  if (setsockopt(in_socket_descriptor, SOL_SOCKET, SO_REUSEADDR,
		 &loop, sizeof(loop)) < 0) {
    perror("setsockopt(allow multiple socket use");
  }

  if (bind(in_socket_descriptor, (struct sockaddr *)&sin, sizeof(sin)) < 0) {
    perror("call to bind");
  }

  // allow broadcast to this machine"
  loop = 1;
  if (setsockopt(in_socket_descriptor, IPPROTO_IP, IP_MULTICAST_LOOP,
		 &loop, sizeof(loop)) < 0) {
    perror("setsockopt(multicast loop on)");
  }

  // join the broadcast group:
  command.imr_multiaddr.s_addr = inet_addr("224.0.0.1");
  command.imr_interface.s_addr = htonl(INADDR_ANY);

  if (command.imr_multiaddr.s_addr == -1) {
    printf("Error: group of 224.0.0.1 not a legal multicast address\n");
  }

  if (setsockopt(in_socket_descriptor, IPPROTO_IP, IP_ADD_MEMBERSHIP,
		 &command, sizeof(command)) < 0) {
    perror("Error in setsocket(add membership)");
  }


  // set socket to non-blocking:
  save_file_flags = fcntl(in_socket_descriptor, F_GETFL);
  printf("file flags=%ld\n", save_file_flags);
  save_file_flags |= O_NONBLOCK;
  if (fcntl(in_socket_descriptor, F_SETFL, save_file_flags) < 0) {
    perror("trying to set input socket to non-blocking");
  }
  printf("file flags after setting non-blocking=%ld\n", save_file_flags);

  // main loop that both broadcasts and listens:

  printf("Staring main loop to broadcast and listen...\n");

  while (iter++ < 20) {
    printf("%d iteration\n", iter);
    if ((iter % 7) == 0) { // do a broadcast every 7 times through loop
      printf("sending data...\n");
      if (sendto(out_socket_descriptor,
		 "test from broadcast", sizeof("test from broadcast"),
		 0, (struct sockaddr *)&address, sizeof(address))
	  < 0) {
	perror("Trying to broadcast with sendto");
	exit(1);
      }
    }
    sleep(1); // wait a second
    // see if there is any data to read on the non-blocking socket:
    sin_len = sizeof(sin);
    i = recvfrom(in_socket_descriptor, message, 256, 0,
		 (struct sockaddr *)&sin, &sin_len);
    if (i > 0) {
      printf("Response from server:\n\n%s\n", message);
    } else {
      printf("No data available to read\n");
    }
  }


}  
