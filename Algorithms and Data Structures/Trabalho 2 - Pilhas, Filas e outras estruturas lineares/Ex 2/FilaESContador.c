#include <stdio.h>
#include <stdlib.h>
#include "FilaESContador.h"

struct fila {
    Carro carros[MAX];
    int ini, cont;
};

Fila cria_fila(){
    Fila f;
    f = (Fila) malloc (sizeof(struct fila));
    if(f != NULL){
        f->ini = 0;
        f->cont = 0;
    }
    return f;
}

void libera_fila(Fila f){
    free(f);
}

int esvazia_fila(Fila f){
    if(f == NULL)    return 0;

    f->cont = 0;

    return 1;
}

int fila_vazia(Fila f){
    if(f->cont == 0)    return 1;

    return 0;
}

int fila_cheia(Fila f){
    if(f->cont == MAX)  return 1;

    return 0;
}

int insere_fila(Fila f, Carro carro){
    if(fila_cheia(f) == 1) return 0;

    f->carros[(f->ini + f->cont) % MAX] = carro;
    f->cont++;

    return 1;
}

int remove_fila(Fila f){
    if(fila_vazia(f) == 1)  return 0;

    f->ini = (f->ini+1) % MAX;

    f->cont--;

    return 1;
}

int tamanho_fila(Fila f){
    if (f == NULL) return 0;
    return f->cont;
}

int get_ini(Fila f, Carro *carro){
    if(f == NULL)   return 0;
    if(fila_vazia(f) == 1)  return 0;

    *carro = f->carros[f->ini];

    return 1;
}
