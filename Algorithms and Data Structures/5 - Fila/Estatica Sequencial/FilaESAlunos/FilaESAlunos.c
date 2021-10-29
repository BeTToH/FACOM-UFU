#include <stdio.h>
#include <stdlib.h>
#include "FilaEstaticaSequencial.h"

#define MAX 5
#define STR_SIZE 10

struct fila {
    Aluno dados[MAX];
    int ini, fim, cont;
};

Fila cria_fila() {
    Fila f = (Fila) malloc(sizeof(struct fila));
    if(f != NULL) {
        f->ini = 0;
        f->fim = 0;
        f->cont = 0;
    }
    return f;
}

int fila_vazia(Fila f) {
    if (cont == 0)
        return 1;
    return 0;
}

int fila_cheia(Fila f) {
    if (cont == MAX)
        return 1;
    return 0;
}

int tamanho(Fila f){
    return f->cont;
}

int insere(Fila f, Aluno elem) {
    if(fila_cheia(f) == 1)
        return 0;

    f->fim = ((f->ini) + (f->cont)) % MAX;

    f->dados[f->fim] = elem;

    f->cont++;

    return 1;
}

int _remove(Fila f, int* matricula) {
    if(fila_vazia(f) == 1)
        return 0;

    *matricula = f->dados[f->ini];

    f->ini = ((f->ini) + 1) % MAX;

    f->cont--;

    return 1;
}

int obtem_elem(Fila f, int pos, Aluno* elem){
    if(fila_vazia(f) == 1 || pos > tamanho(f) || pos <= 0)
        return 0;

    int index = (f->ini+pos-1) % MAX;

    *elem = f->dados[index];

    return 1;
}


