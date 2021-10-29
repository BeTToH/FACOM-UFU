#include <stdio.h>
#include <stdlib.h>
#include "FilaEstaticaSequencial.h"

#define MAX 5
#define STR_SIZE 10

struct fila {
    char no[MAX][STR_SIZE];
    int ini, fim;
};

Fila cria_fila() {
    Fila f = (Fila) malloc(sizeof(struct fila));
    if(f != NULL) {
        f->ini = 0;
        f->fim = 0;
    }
    return f;
}

int fila_vazia(Fila f) {
    if (f->ini == f->fim)
        return 1;
    return 0;
}

int fila_cheia(Fila f) {
    if (f->ini == ((f->fim) + 1) % MAX)
        return 1;
    return 0;
}

int tamanho(Fila f){
    return f->fim - f->ini;
}

int insere(Fila f, char* elem) {
    if(fila_cheia(f) == 1)
        return 0;

    strcpy(f->no[f->fim], elem);
    f->fim = ((f->fim) + 1) % MAX;

    return 1;
}

int _remove(Fila f, char *elem) {
    if(fila_vazia(f) == 1)
        return 0;

    strcpy(elem, f->no[f->ini]);
    f->ini = ((f->ini) + 1) % MAX;

    return 1;
}

int obtem_elem(Fila f, int pos, char* elem){
    if(fila_vazia(f) == 1 || pos > tamanho(f) || pos <= 0)
        return 0;

    int index = (f->ini+pos-1)%MAX;
    strcpy(elem, f->no[index]);

    return 1;
}

