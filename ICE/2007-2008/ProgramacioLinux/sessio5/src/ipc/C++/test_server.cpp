#include <iostream.h>
#include "Server.hxx"

void my_work_func(char *command, char *return_buffer, int return_buffer_size) {
  cout << "entering my_work_func(" << command << ",...)\n";
  sprintf(return_buffer,"overriden my_work_func.  %s", command);
}

void main() {
  Server * server = new Server(my_work_func); // default to port=8080
}
