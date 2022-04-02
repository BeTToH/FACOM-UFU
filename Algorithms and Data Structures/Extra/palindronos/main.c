#include <stdio.h>
#include <stdlib.h>
#include "fila.h"
#include "pilha.h"

int main()
{
    int flag = 1;
    char aux, aux2;
    Queue str_queue = create_queue();
    Stack str_stack = create_stack();

    printf("*** Verificador de palindronos ***\n");

    printf("Informe uma frase para ser verificada: ");
    while((aux = getchar()) != '\n'){
        // Adds to queue and stack - if character is not a space
        if (aux != ' '){
            enqueue(str_queue, aux);
            push(&str_stack, aux);
        }
    }

    // The queue will represent the normal sentence
    // The stack will represent the inverted sentence, since the last letters added will be first ones.
    while(is_stack_empty(str_stack) == 0){
        dequeue(str_queue, &aux);
        pop(&str_stack, &aux2);

        // The program will compare letter by letter
        if (aux != aux2){
            flag = 0;
            break;
        }
    }

    // Answers it
    printf("%d\n", flag);

    return 0;
}
