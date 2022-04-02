#include <stdlib.h>
#include "pilha.h"

struct node {
    char letter;
    struct node* next;
};

Stack create_stack() {
    return NULL;
}

int is_stack_empty(Stack s) {
    if (s == NULL)
        return 1;

    return 0;
}

int push(Stack* s, char elem) {
    Stack new_node = (Stack) malloc(sizeof(struct node));
    if(new_node == NULL)
        return 0;

    new_node->letter = elem;
    new_node->next = *s;
    *s = new_node;

    return 1;
}

int pop(Stack* s, char* elem) {
    if(is_stack_empty(*s))
        return 0;

    Stack aux = *s;
    *elem = aux->letter;
    *s = aux->next;

    free(aux);
    return 1;
}

