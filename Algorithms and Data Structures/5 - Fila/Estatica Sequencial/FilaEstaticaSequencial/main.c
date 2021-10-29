#include <stdio.h>
#include <stdlib.h>
#include "FilaEstaticaSequencial.h"

void imprime_fila(Fila f){
    char* aux;
    printf("FILA: ");
    if(tamanho(f) == 0)
        printf("**VAZIA**");
    else {
        for(int i = 1; i <= tamanho(f); i++){
            obtem_elem(f, i, &aux);
            printf("%s ", &aux);
        }
    }
    printf("\n");
}

int main()
{
    Fila f = cria_fila();

    printf("Criou a fila\n");

    imprime_fila(f);

    insere(f, "casa");
    insere(f, "moto");
    insere(f, "bicicleta");
    insere(f, "quadro");

    printf("\nElementos inseridos\n");

    imprime_fila(f);

    char *aux;
    _remove(f, &aux);

    printf("\nElemento '%s' removido!\n", &aux);

    imprime_fila(f);

    return 0;
}
