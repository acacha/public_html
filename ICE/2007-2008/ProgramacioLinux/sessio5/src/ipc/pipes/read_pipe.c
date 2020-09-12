/* read_pipe.c 
   Copyright 1998 by Mark Watson.  Open Source License
*/

#include <stdio.h>
#include <unistd.h>

void main() {
  FILE * in_file;
  int count = 1;
  char buf[80];
  in_file = fopen("a_pipe", "r");
  if (in_file == NULL) {
    printf("Error in fdopen.\n");
    exit(1);
  }
  while ((count = fread(buf, 1, 80, in_file)) > 0) {
    printf("received from pipe: %s\n", buf);
  }
  fclose(in_file);
}


