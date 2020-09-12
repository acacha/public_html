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
 
int port = 6789;

void main() {
  int socket_descriptor;
  struct sockaddr_in address;
  // For broadcasting, this socket can be treated like a UDP socket:
  socket_descriptor = socket(AF_INET, SOCK_DGRAM, 0);
  if (socket_descriptor == -1) {
    perror("Opening socket");
    exit(1);
  }
  memset(&address, 0, sizeof(address));
  address.sin_family = AF_INET;
  address.sin_addr.s_addr = inet_addr("224.0.0.1");
  address.sin_port = htons(port);

  while (1) {
    if (sendto(socket_descriptor,
	       "test from broadcast", sizeof("test from broadcast"),
	       0, (struct sockaddr *)&address, sizeof(address))
	< 0) {
      perror("Trying to broadcast with sendto");
      exit(1);
    }
    sleep(2);
  }
}  
