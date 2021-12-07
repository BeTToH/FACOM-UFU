
#include <stdio.h>
#include <stdlib.h>
#include "DinamicaEncadeadaOrdenada.h"

struct no
{
    char caracter;
    struct no *prox;
};

typedef struct no No;

Lista cria_lista()
{
    Lista cab = (Lista) malloc(sizeof(No));

    if (cab != NULL) {
        cab->prox = NULL;
        cab->caracter = 0;
    }

    return cab;
};

int lista_vazia(Lista lst)
{
    if (lst->prox == NULL)
        return 1;
    else
        return 0;
}

int tamanho_lista(Lista *lst){
    return (*lst)->caracter;
}

int insere_ord(Lista *lst, char caracter)
{
    Lista N = (Lista)malloc(sizeof(No));

    if (N == NULL)  return 0;

    N->caracter = caracter;

    if (lista_vazia(*lst) == 1 || caracter <= (*lst)->prox->caracter)
    {
        N->prox = (*lst)->prox;
        (*lst)->prox = N;

        (*lst)->caracter++;

        return 1;
    }

    Lista aux = (*lst)->prox;
    while (aux->prox != NULL && aux->prox->caracter < caracter)
        aux = aux->prox;

    N->prox = aux->prox;
    aux->prox = N;

    (*lst)->caracter++;

    return 1;
}

int remove_ord(Lista *lst, char caracter)
{
    if (lista_vazia(*lst) == 1 || caracter < (*lst)->prox->caracter)
        return 0;

    Lista aux = (*lst)->prox;
    if (caracter == aux->caracter)
    {
        (*lst)->prox = aux->prox;
        free(aux);

        (*lst)->caracter--;

        return 1;
    }

    while (aux->prox != NULL && aux->prox->caracter < caracter)
        aux = aux->prox;

    if (aux->prox == NULL || aux->prox->caracter > caracter)
        return 0;

    Lista aux2 = aux->prox;
    aux->prox = aux2->prox;
    free(aux2);

    (*lst)->caracter--;

    return 1;
}

int remove_por_pos(Lista *lst, int pos, int *elem)
{
    if (lista_vazia(*lst) == 1 || pos <= 0 || pos > tamanho_lista(lst))
        return 0;

    Lista aux = *lst;
    for(int i = 1; i < pos; i++)
        aux = aux->prox;

    Lista aux2 = aux->prox;
    aux->prox = aux2->prox;

    *elem = aux2->caracter;

    free(aux2);

    (*lst)->caracter--;

    return 1;
}

int obtem_elem_pos(Lista *lst, int pos, int *caracter)
{
    if (lista_vazia(*lst) == 1 || pos <= 0)
        return 0;

    int count = 1;
    Lista aux = (*lst)->prox;
    while (aux != NULL && count < pos){
        aux = aux->prox;
        count++;
    }

    if (aux == NULL)
        return 0;

    *caracter = aux->caracter;

    return 1;
}

int esvazia_lista(Lista *lst)
{

    Lista aux = (*lst)->prox, aux2;

    while (aux != NULL)
    {
        aux2 = aux->prox;
        free(aux);
        aux = aux2;
    }

    (*lst)->prox = NULL;
    (*lst)->caracter = 0;

    return 1;
}

Lista inverte_lista(Lista *lst){
    Lista l2 = cria_lista();

    int tamanho = tamanho_lista(lst);

    Lista aux = (*lst)->prox;
    for (int i = 0; i < tamanho; i++){
        Lista N = (Lista)malloc(sizeof(No));
        if(N == NULL)
            return NULL;

        N->caracter = aux->caracter;

        N->prox = l2->prox;
        l2->prox = N;

        l2->caracter++;

        aux = aux->prox;
    }

    return l2;
}

Lista intercala_listas(Lista *l1, Lista *l2){
    Lista l_resultante = cria_lista();

    int tamanho = tamanho_lista(l1);

    Lista aux = (*l1)->prox;
    for (int i = 0; i < tamanho; i++){
        int flag = insere_ord(&l_resultante, aux->caracter);
        if(flag == 0)
            return NULL;

        aux = aux->prox;
    }

    tamanho = tamanho_lista(l2);
    aux = (*l2)->prox;
    for (int i = 0; i < tamanho; i++){
        int flag = insere_ord(&l_resultante, aux->caracter);
        if(flag == 0)
            return NULL;

        aux = aux->prox;
    }

    return l_resultante;
}

int remove_ultima(Lista *lst, char caracter)
{
    if (lista_vazia(*lst) == 1)
        return 0;

    Lista aux = (*lst), ant_ultima_ocorrencia = NULL, ultima_ocorrencia = NULL;
    while (aux->prox != NULL){        
        if(aux->prox->caracter == caracter){
            ant_ultima_ocorrencia = aux;
            ultima_ocorrencia = aux->prox;
        }   

        aux = aux->prox;     
    }

    if(ultima_ocorrencia == NULL)
        return 0;

    ant_ultima_ocorrencia->prox = ultima_ocorrencia->prox;
    free(ultima_ocorrencia);    

    return 1;
}
