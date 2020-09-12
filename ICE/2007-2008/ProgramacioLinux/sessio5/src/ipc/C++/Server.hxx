// Server.hxx
// Class definition for Server class.
// Copyright Mark Watson, 1999. Open Source Software License.
//

#ifndef __Server__h
#define __Server__h


#include <stdio.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>   
#include <string.h>
#include <ctype.h>
#include <unistd.h>   

class Server {
public:
  Server(void (*a_work_func)(char *, char *, int), int port = 8080);
  ~Server(); // closes socket, etc.
protected:
  void (*work_func)(char *, char *, int);
  void work(char *command);
  int port;
  struct sockaddr_in sin;
  struct sockaddr_in pin;
  int sock_descriptor;
  int temp_sock_descriptor;
  char * temp_buf;
};

#endif
