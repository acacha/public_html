/* send.c
 * Copyright Mark Watson 1999. Open SOurce Software License.
 *
 * Sample showing how to send using UDP
 */

#include <stdio.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>
 
int port = 6789;

void main() {
  int socket_descriptor;
  int iter = 0;
  int process;
  char buf[80]; // for sending messages
  struct sockaddr_in address;
  // Here, we use SOCK_DGRAM (for UDP) instead of SOCK_STREAM (TCP):
  socket_descriptor = socket(AF_INET, SOCK_DGRAM, 0);
  if (socket_descriptor == -1) {
    perror("Opening socket");
    exit(1);
  }
  memset(&address, 0, sizeof(address));
  address.sin_family = AF_INET;
  address.sin_addr.s_addr = inet_addr("127.0.0.1");
  address.sin_port = htons(port);

  process = 1;
  do {
    sprintf(buf,"data packet with ID %d\n", iter);
    if (iter >20) {
      sprintf(buf, "stop\n");
      process = 0;
    }
    if (sendto(socket_descriptor,
	       buf, sizeof(buf),
	       0, (struct sockaddr *)&address, sizeof(address))
	< 0) {
      perror("Trying to broadcast with sendto");
      exit(1);
    }
    iter++;
  } while (process);
}  
