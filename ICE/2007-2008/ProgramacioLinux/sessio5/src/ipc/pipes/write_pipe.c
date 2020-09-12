/* write_pipe.c 
   Copyright 1998 by Mark Watson.  Open Source License
*/

#include <stdio.h>
#include <unistd.h>

void main() {
  FILE * out_file;
  int count = 1;
  char buf[80];
  out_file = fopen("a_pipe", "w");
  if (out_file == NULL) {
    printf("Error opening pipe.");
    exit(1);
  }
  sprintf(buf,"this is test data for the named pipe example\n");
  fwrite(buf, 1, 80, out_file);
  fclose(out_file);
}
