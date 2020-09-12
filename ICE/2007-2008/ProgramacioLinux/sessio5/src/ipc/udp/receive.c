/* receive.c
 * Copyright Mark Watson 1999. Open Source Software License.
 *
 * Sample showing how to receive using UDP
 */

#include <stdio.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>
 
char * host_name = "127.0.0.1"; // local host
int port = 6789;

void main() {
  int sin_len;
  char message[256];
  int socket_descriptor;
  struct sockaddr_in sin;
  struct hostent *server_host_name;

   if ((server_host_name = gethostbyname(host_name)) == 0) {
    perror("Error resolving local host\n");
    exit(1);
  }

  bzero(&sin, sizeof(sin));
  sin.sin_family = AF_INET;
  sin.sin_addr.s_addr = htonl(INADDR_ANY);
  sin.sin_port = htons(port);

  // set using SOCK_DGRAM for UDP:
  if ((socket_descriptor = socket(PF_INET, SOCK_DGRAM, 0)) == -1) {
    perror("Error opening socket\n");
    exit(1);
  }

  if (bind(socket_descriptor, (struct sockaddr *)&sin, sizeof(sin)) < 0) {
    perror("call to bind");
  }

  while (1) {
    sin_len = sizeof(sin);
    if (recvfrom(socket_descriptor, message, 256, 0,
		 (struct sockaddr *)&sin, &sin_len) == -1) {
      perror("Error in receiving response from server\n");
    }

    printf("\nResponse from server:\n\n%s\n", message);
    if (strncmp(message, "stop", 4) == 0) break;
  }
  close(socket_descriptor);
}  
