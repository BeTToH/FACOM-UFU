#include <stdlib.h>
#include "fila.h"

struct node {
    char letter;
    struct node* next;
};

struct _queue {
    struct node* first;
    struct node* last;
};

Queue create_queue() {
    Queue q = (Queue) malloc(sizeof(struct _queue));
    if(q != NULL) {
        q->first = NULL;
        q->last = NULL;
    }
    return q;
}

int is_queue_empty(Queue q) {
    if (q->first == NULL)
        return 1;
    return 0;
}

void enqueue(Queue q, char elem) {
    struct node* n = (struct node*) malloc(sizeof(struct node));
    if(n == NULL)
        return 0;
    n->letter = elem;
    if(is_queue_empty(q)) {
        q->first = n;
        n->next = NULL;
    } else {
        (q->last)->next = n;
    }
    q->last = n;
    return 1;
}

int dequeue(Queue q, char *elem) {
    if(is_queue_empty(q))
        return 0;
    struct node* aux = q->first;
    *elem = aux->letter;
    if(q->first == q->last){
        q->first = NULL;
        q->last == NULL;
    }
    q->first = aux->next;
    free(aux);
    return 1;
}
