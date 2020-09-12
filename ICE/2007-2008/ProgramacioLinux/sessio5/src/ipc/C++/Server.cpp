/* Server.cpp
 * Copyright Mark Watson 1999. Open Source Software License.
 */

#include <iostream.h>
#include <Server.hxx>

Server::Server(void (*a_work_func)(char *, char *, int), int my_port) {
  work_func = a_work_func;
  port = my_port;
  int address_size;
  int i, len;
  char buf[4000]; // for receiving data from clients

  temp_buf = new char[16384]; // space for return data

  sock_descriptor = socket(AF_INET, SOCK_STREAM, 0);
  if (sock_descriptor == -1) {
    perror("call to socket");
    exit(1);
  }

  bzero(&sin, sizeof(sin));
  sin.sin_family = AF_INET;
  sin.sin_addr.s_addr = INADDR_ANY;
  sin.sin_port = htons(port);

  if (bind(sock_descriptor, (struct sockaddr *)&sin, sizeof(sin)) == -1) {
    perror("call to bind");
    exit(1);
  }

  if (listen(sock_descriptor, 20) == -1) {
    perror("call to listen");
    exit(1);
  }

  while(1) {
    temp_sock_descriptor =
      accept(sock_descriptor, (struct sockaddr *)&pin,
	     &address_size);
    if (temp_sock_descriptor == -1) {
      perror("call to accept");
      exit(1);
    }

    if (recv(temp_sock_descriptor, buf, 4000, 0) == -1) {
      perror("call to recv");
      exit(1);
    }

    // this calls the work function passed to the class constructor:
    work_func(buf, temp_buf, 16384);

    // the virtual function doWork has filled in the
    // data to be returned to the client in 'temp_buf':

    len = strlen(temp_buf);
    
    if (send(temp_sock_descriptor, temp_buf, len, 0) == -1) {
      perror("call to send");
      exit(1);
    }

    close(temp_sock_descriptor);

  }
}


Server::~Server() {
  delete [] temp_buf;
  close(sock_descriptor);
}
