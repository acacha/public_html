// Client.hxx
// Class definition for Client class.
// Copyright Mark Watson, 1999. Open Source Software License.
//

#ifndef __Client__h
#define __Client__h

#include <stdio.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>
#include <string.h>
#include <ctype.h>
#include <unistd.h>   

class Client {
public:
  Client(char * host = "127.0.0.1", int port = 8080);
  char * getResponseFromServer(char * command);
private:
  int port;
  char * host_name;
  char buf[8192];
  char message[256];
  int socket_descriptor;
  struct sockaddr_in pin;
  struct hostent *server_host_name;
};

#endif
