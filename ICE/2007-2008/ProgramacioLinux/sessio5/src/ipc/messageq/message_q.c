/* message_q.c
   Copyright Mark Watson, 1988.  Open Source Software License
*/

#include <stdio.h>
#include <sys/types.h>
#include <sys/msg.h>
#include <sys/ipc.h>

// the message queue API functions require a data structure with a long
// message type value as the first element.  This is defined in sys/msg.h:

struct amsgbuf {
  long mtype;
  char mtext[80];
}  mq_test_buf;


void main() {
  key_t unique_key;
  int id;
  int i;

  // Start by creating a semaphore:
  unique_key = ftok(".", 'a'); // 'a' can be any character
  printf("unique key=%d\n", unique_key);

  // Open a message queue:
  id = msgget(unique_key, IPC_CREAT | 0666);
  printf("message queue id=%d\n", id);
  if (id == -1) {
    printf("Error creating/connecting to message queue\n");
    exit(1);
  }

  // Send a test message:
  printf("Sending message...\n");
  mq_test_buf.mtype = 123;
  sprintf(mq_test_buf.mtext,"test message");
  if (msgsnd(id, (struct msgbuf *)&mq_test_buf, sizeof("test message") + 1, 0) == -1) { // room for 32 chars in mq_test_buf
    perror("send");
    printf("Error sending message\n");
    exit(1);
  }
    
  // Receive message:
  mq_test_buf.mtext[0] = 0;  // zap out, so we are sure that we receive data
  i = msgrcv(id, (struct msgbuf *)&mq_test_buf, 80, 123, IPC_NOWAIT);
  if (i == -1) { 
    printf("no message is avaliable of type 123\n");
  } else {
    printf("message of type 123 received with data: %s\n", mq_test_buf.mtext);
  }

  // Now remove the message queue:
  msgctl(id, IPC_RMID, 0);
}
