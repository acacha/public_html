/* Client.cpp
 * Copyright Mark Watson 1999. Open Source Software License.
 * Note: derived from NLPserver client example.
 * See www.markwatson.com/opensource/opensource.htm for all
 * of the natural language server (NLPserver) source code.
 */

#include <iostream.h>
#include "Client.hxx"

Client::Client(char * my_host_name, int my_port) {
  port = my_port;
  host_name = my_host_name;

  if ((server_host_name = gethostbyname(host_name)) == 0) {
    perror("Error resolving local host\n");
    exit(1);
  }
    
  bzero(&pin, sizeof(pin));
  pin.sin_family = AF_INET;
  pin.sin_addr.s_addr = htonl(INADDR_ANY);
  pin.sin_addr.s_addr = ((struct in_addr *)(server_host_name->h_addr))->s_addr;
  pin.sin_port = htons(port);

}

char * Client::getResponseFromServer(char * str) {

  if ((socket_descriptor = socket(AF_INET, SOCK_STREAM, 0)) == -1) {
    perror("Error opening socket\n");
    exit(1);
  }

  if (connect(socket_descriptor, (const sockaddr *)&pin, sizeof(pin)) == -1) {
    perror("Error connecting to socket\n");
    exit(1);
  }
  cout << "Sending message '" << str << "' to server...\n";

  if (send(socket_descriptor, str, strlen(str), 0) == -1) {
    perror("Error in send\n");
    exit(1);
  }

  cout << "..sent message.. wait for response...\n";

  if (recv(socket_descriptor, buf, 8192, 0) == -1) {
    perror("Error in receiving response from server\n");
    exit(1);
  }

  close(socket_descriptor);
  
  cout << "\nResponse from server:\n" << buf << "\n";
  return buf;
}

