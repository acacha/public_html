/* semaphore.c
   Copyright Mark Watson, 1988.  Open Source Software License
*/

#include <stdio.h>
#include <sys/types.h>
#include <sys/sem.h>
#include <sys/ipc.h>

void main() {
  key_t unique_key;
  int id;
  struct sembuf lock_it;
  union semun options;
  int i;

  // Start by creating a semaphore:
  unique_key = ftok(".", 'a'); // 'a' can be any character
  // Create a new semaphore with 1 member of the set; Note that
  // if you want to use a semaphore created by another program
  // then use 0 instead of 1 for the second argument:
  id = semget(unique_key, 1, IPC_CREAT | IPC_EXCL | 0666);
  printf("semaphore id=%d\n", id);
  options.val = 1;
  semctl(id, 0, SETVAL, options);

  // make sure that everything is set up OK:
  if (semctl(id, 0, GETVAL, 0) == 0) {
    printf("can not lock semaphore.\n");
    exit(1);
  }

  // Now print out the value of the semaphore:
  i = semctl(id, 0, GETVAL, 0);
  printf("value of semaphore at index 0 is %d\n", i);

  // Now set the semaphore:
  lock_it.sem_num = 0; // semaphore index
  lock_it.sem_op  = -1; // operation
  lock_it.sem_flg = IPC_NOWAIT; // operation flags
  if (semop(id, &lock_it, 1) == -1) {
    printf("can not lock semaphore.\n");
    exit(1);
  }

  // Now print out the value of the semaphore:
  i = semctl(id, 0, GETVAL, 0);
  printf("value of semaphore at index 0 is %d\n", i);

  // now un-set the semaphore:
  lock_it.sem_num = 0;
  lock_it.sem_op  = 1;
  lock_it.sem_flg = IPC_NOWAIT;
  if (semop(id, &lock_it, 1) == -1) {
    printf("could not unlock semaphore.\n");
    exit(1);
  }

  // Now print out the value of the semaphore:
  i = semctl(id, 0, GETVAL, 0);
  printf("value of semaphore at index 0 is %d\n", i);

  // Now remove the semaphore:
  semctl(id, 0, IPC_RMID, 0);
}
