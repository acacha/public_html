#include <iostream.h>
#include "Client.hxx"

void main() {
  Client * client = new Client(); // default to host="127.0.0.1", port=8080
  char * s;
  char buf[100];
  sprintf(buf,"This is a test");
  s = client->getResponseFromServer(buf);
  cout << "Server response: " << s << "\n";
  sprintf(buf,"This is a another test");
  s = client->getResponseFromServer(buf);
  cout << "Server response: " << s << "\n";
  delete client; // closes the socket connection
}
