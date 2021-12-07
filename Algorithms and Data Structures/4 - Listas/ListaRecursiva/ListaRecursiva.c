#include <stdio.h>
#include <stdlib.h>
#include "ListaRecursiva.h"

struct no {
    int info;
    Lista prox;
};

typedef struct no No;

Lista cria_lista() {
    return NULL;
};

int lista_vazia(Lista list) {
    return list == NULL;
}

int insere_ord(Lista *list, int valor) {
    if(lista_vazia(*list) || valor <= (*list)->info) {
        Lista N = (Lista) malloc(sizeof(No));
        if(N == NULL)
            return 0;
        N->info = valor;
        N->prox = *list;
        *list = N;
        return 1;
    }
    return insere_ord(&((*list)->prox), valor);
}


int remove_ord(Lista *list, int valor) {
    if(lista_vazia(*list) || valor < (*list)->info)
        return 0;
    if(valor == (*list)->info) {
        Lista aux = (*list);
        (*list) = aux->prox;
        free(aux);
        return 1;
    }
    return remove_ord(&((*list)->prox), valor);
}


int get_elem_pos(Lista list, int pos, int *var) {
    if(lista_vazia(list) || pos < 0)
        return 0;

    if(pos == 0) {
        *var = list->info;
        return 1;
    }

    return get_elem_pos(list->prox, pos - 1, var);
}

void esvazia_lista(Lista* list){
    (*list) = NULL;
}

void apaga_lista(Lista* no)
{
    if ((*no) == NULL)
        return;
    apaga_lista(&((*no)->prox));
    free(*no);
    (*no) = NULL;
}
