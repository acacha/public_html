/* shared_mem.c
 * Copyright Mark Watson 1998. Open Source Software License
 *
 * NOTE: You must allocate shared memory at boot time. Add
 *       the following to /etc/lilo.config:
 *
 *            image=/vmlinux     (this should already be in lilo.config)
 *            append="mem=63m"   (if you have 64m of physical memory)
 */

#include <stdio.h>
#include <unistd.h>
#include <sys/mman.h> 
#include <fcntl.h> 

#define ADDRESS (63*0x100000)
void main() {
  char *mem_pointer;
  int f, i;
  if ((f=open("/dev/mem", O_RDWR)) < 0) {
    printf("Error opening /dev/mem\n");
    exit(1);
  }
  mem_pointer = (char *)mmap(0, 8192, PROT_READ | PROT_WRITE,
			     MAP_FILE | MAP_SHARED, f, ADDRESS);

  for (i=0; i<10; i++) {
    printf("Test iteration %d\n", i);
    printf("first two bytes: %d %d\n", mem_pointer[0], mem_pointer[1]);
    mem_pointer[0] = 2*i;
    mem_pointer[1] = 3*i;
    printf("first two bytes: %d %d\n", mem_pointer[0], mem_pointer[1]);
    system("sleep 2");
  }

  // use it here..

  // close up:
  munmap(mem_pointer, 8192);
}

