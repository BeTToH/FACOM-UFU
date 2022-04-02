typedef struct _queue* Queue;

Queue create_queue();
void enqueue(Queue, char);
int dequeue(Queue, char*);
int is_queue_empty(Queue);
