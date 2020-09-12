/* unnamed_pipe.c
   Copyright 1998 by Mark Watson. Open Source Software License
*/

#include <unistd.h>  /* to define the type pid_t */
#include <stdio.h>

#define INPUT 0
#define OUTPUT 1

void main() {
  int file_descriptors[2];
  pid_t spawned_process_pid;
  char buf[256];
  int returned_count;
  pipe(file_descriptors);
        
  if((spawned_process_pid = fork()) == -1) {
    printf("Error in fork\n");
    exit(1);
  }

  if(spawned_process_pid == 0) {
    printf("in the spawned (child) process...\n");
    // The spawned (child) process will write data back to
    // the spawning (parent) process.  The spawned process
    // does not need the input file descriptor, so we close it:
    close(file_descriptors[INPUT]);

    write(file_descriptors[OUTPUT], "test data", strlen("test data"));
    exit(0);
  } else {
    printf("in the spawning (parent) process...\n");
    // The spawning (parent) process will just read data
    // (that is sent from the spawned process) from the pipe,
    // so we can close the input file descriptor:
    close(file_descriptors[OUTPUT]);
    
    // wait for data sent by the spawned (child) process:
    returned_count = read(file_descriptors[INPUT],
                          buf,
                          sizeof(buf));
    printf("%d bytes of data received from spawned process: %s\n",
           returned_count, buf);
  }
}
