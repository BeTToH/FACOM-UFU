#include <stdio.h>
#include <stdlib.h>
#include "pilhaEstatica.h"

struct pilha {
    int qtd;
    char valor[MAX];
};

Pilha* cria_pilha(){
    Pilha *pi;
    pi = (Pilha*) malloc(sizeof(struct pilha));

    if(pi != NULL)
        pi->qtd = 0;

    return pi;
}

void apaga_pilha(Pilha* pi){
    free(pi);
}

int esvazia_pilha(Pilha* pi){
    if(pi == NULL)  return -1;

    if(pilha_vazia(pi) == 1)    return 1;

    pi->qtd = 0;

    return 1;    
}

int tamanho_pilha(Pilha* pi){
    if(pi == NULL)  return -1;

    return pi->qtd;
}

int pilha_cheia(Pilha* pi){
    if(pi == NULL)   return -1;

    if(pi->qtd == MAX)  return 1;

    return 0;
}

int pilha_vazia(Pilha* pi){
    if(pi == NULL)   return -1;

    if(pi->qtd == 0)  return 1;

    return 0;
}

int push(Pilha *pi, char valor){
    if(pi == NULL)  return 0;
    if(pi->qtd == MAX) return 0;

    pi->valor[pi->qtd] = valor;
    pi->qtd++;

    return 1;
}

int pop(Pilha *pi){
    if(pi == NULL || pi->qtd == 0)  return 0;

    pi->qtd--;
    return 1;
}

int consulta_topo(Pilha *pi, char *valor){
    if(pi == NULL || pi->qtd == 0)  return 0;

    *valor = pi->valor[pi->qtd-1];
    return 1;
}
