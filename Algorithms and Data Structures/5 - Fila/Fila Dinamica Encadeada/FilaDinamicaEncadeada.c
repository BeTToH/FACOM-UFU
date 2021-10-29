#include <stdlib.h>
#include "FilaDinamicaEncadeada.h"

struct no {
    Bebida dados;
    struct no* prox;
};

struct fila {
    struct no *ini;
    struct no *fim;
};

Fila cria_fila() {
    Fila f = (Fila) malloc (sizeof(struct fila));
    if(f != NULL){
        f->ini = NULL;
        f->fim = NULL;
    }
    return f;
}

int fila_vazia(Fila f) {
    if(f->ini == NULL)
        return 1;
    return 0;
}

int insere_fim(Fila f, Bebida elem) {
    struct no *N = (struct no*) malloc(sizeof(struct no));
    if(N == NULL)
        return 0;
    N->dados = elem;
    if(fila_vazia(f) == 1)
        f->ini = N;
    else
        (f->fim)->prox = N;

    f->fim = N;

    return 1;
}

int remove_inicio(Fila f, Bebida *elem) {
    if(fila_vazia(f) == 1)
        return 0;

    struct no *aux = f->ini;
    *elem = aux->dados;

    if(f->ini == f->fim)
        f->fim = NULL;

    f->ini = aux->prox;
    free(aux);

    return 1;
}

void apaga_fila(Fila f){
    if(f != NULL){
        Fila N;
        while(f->ini != NULL){
            N = f->ini;
            f->ini = f->ini->prox;
            free(N);
        }
        free(f);
    }
}

void esvazia_fila(Fila f){
    if(f != NULL){
        Fila N;
        while(f->ini != NULL){
            N = f->ini;
            f->ini = f->ini->prox;
            free(N);
        }
        f->fim = NULL;
    }
}
