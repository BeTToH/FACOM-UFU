typedef struct node* Stack;

Stack create_stack();
int is_stack_empty(Stack);
int push(Stack*, char);
int pop(Stack*, char*);
