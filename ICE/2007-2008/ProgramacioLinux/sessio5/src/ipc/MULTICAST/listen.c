/* broadcast.c
 * Copyright Mark Watson 1999. Open Source Software License.
 *
 * Sample broadcast using Multicast IP.
 * You must rebuild your Linux kernel to support Multicast IP
 * and you have to issue something like this (as root):
 *   route add -net 224.0.0.0 netmask 240.0.0.0 dev lo
 */

#include <stdio.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>
 
char * host_name = "224.0.0.1"; // local host (multicast IP)
int port = 6789;

void main() {
  struct ip_mreq command;
  u_char loop = 1;  // we want broadcast to also loop back to this computer
  int iter = 0;
  int sin_len;
  char message[256];
  int socket_descriptor;
  struct sockaddr_in sin;
  struct hostent *server_host_name;

  char * str = "A default test string";

   if ((server_host_name = gethostbyname(host_name)) == 0) {
    perror("Error resolving local host\n");
    exit(1);
  }

  bzero(&sin, sizeof(sin));
  sin.sin_family = AF_INET;
  sin.sin_addr.s_addr = htonl(INADDR_ANY);
  sin.sin_port = htons(port);

  if ((socket_descriptor = socket(PF_INET, SOCK_DGRAM, 0)) == -1) {
    perror("Error opening socket\n");
    exit(1);
  }

  // allow multiple processes to use this same port:
  loop = 1;
  if (setsockopt(socket_descriptor, SOL_SOCKET, SO_REUSEADDR,
		 &loop, sizeof(loop)) < 0) {
    perror("setsockopt(allow multiple socket use");
  }

  if (bind(socket_descriptor, (struct sockaddr *)&sin, sizeof(sin)) < 0) {
    perror("call to bind");
  }

  // allow broadcast to this machine"
  loop = 1;
  if (setsockopt(socket_descriptor, IPPROTO_IP, IP_MULTICAST_LOOP,
		 &loop, sizeof(loop)) < 0) {
    perror("setsockopt(multicast loop on)");
  }

  // join the broadcast group:
  command.imr_multiaddr.s_addr = inet_addr("224.0.0.1");
  command.imr_interface.s_addr = htonl(INADDR_ANY);

  if (command.imr_multiaddr.s_addr == -1) {
    printf("Error: group of 224.0.0.1 not a legal multicast address\n");
  }

  if (setsockopt(socket_descriptor, IPPROTO_IP, IP_ADD_MEMBERSHIP,
		 &command, sizeof(command)) < 0) {
    perror("Error in setsocket(add membership)");
  }

  while (iter++ < 10) {
    sin_len = sizeof(sin);
    if (recvfrom(socket_descriptor, message, 256, 0,
		 (struct sockaddr *)&sin, &sin_len) == -1) {
      perror("Error in receiving response from server\n");
    }

    printf("\nResponse from server:\n\n%s\n", message);
    sleep(2);
  }

  // leave the broadcast group ('struct ip_mreq command' is still setup OK):
  if (setsockopt(socket_descriptor, IPPROTO_IP, IP_DROP_MEMBERSHIP,
		 &command, sizeof(command)) < 0) {
    perror("Error in setsocket(drop membership)");
  }

  close(socket_descriptor);

}  
