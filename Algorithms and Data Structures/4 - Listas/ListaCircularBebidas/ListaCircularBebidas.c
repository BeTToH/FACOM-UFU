#include <stdlib.h>
#include "ListaCircularBebidas.h"

struct no
{
    Bebida dados;
    struct no *prox;
};
typedef struct no No;

Lista* cria_lista(){
    Lista* li = (Lista*) malloc(sizeof(Lista));
    if(li != NULL)
        *li = NULL;
    return li;
}

int lista_vazia(Lista* li){
    if(li == NULL || (*li) == NULL)
        return 1;
    return 0;
}


void apaga_lista(Lista* li){
    if(li != NULL && (*li) != NULL){
        No *aux, *no = *li;
        while((*li) != no->prox){
            aux = no;
            no = no->prox;
            free(aux);
        }
        free(no);
        free(li);
    }
}

int insere_fim(Lista *li, Bebida beb){
    if(li == NULL)
        return 0;

    No *no = (No*) malloc(sizeof(No));

    if(no == NULL)
        return 0;

    no->dados = beb;

    if(lista_vazia(*li) == 1){
        *li = no;
        no->prox = no;
    } else {
        no->prox = (*li)->prox;
        (*li)->prox = no;
        *li = no;
    }
    return 1;
}

int insere_produto(Lista *li, Bebida beb){
    if(li == NULL)
        return 0;

    No *no = (No*) malloc(sizeof(No));

    if(no == NULL)
        return 0;

    no->dados = beb;

    if(lista_vazia(*li) == 1 || beb->codigo < (*li)->dados->codigo){
        no->prox = (*li);
        no->ant = NULL;

        *li = no;                
        return 1;
    }

    Lista aux = *li;
    while(aux->prox != NULL && aux->prox->dados->codigo < beb->codigo){
        aux = aux->prox;
    }

    if(aux->prox != NULL) aux->prox->ant = no;
    no->prox = aux->prox;
    no->ant = aux;
    aux->prox = no;

    return 1;
}

int remove_ini(Lista *lst, Bebida *beb){
    if (lista_vazia(*lst) == 1)
        return 0;

    Lista aux = (*lst)->prox;
    *beb = aux->dados;

    if (*lst == (*lst)->prox)
        *lst = NULL;
    else
        (*lst)->prox = aux->prox;
    free(aux);
    return 1;
}

int esvazia_lista(Lista *li){
    if(lista_vazia(li) == 1)
        return 1;

    No *aux, *no = (*li)->prox;
    while(no != (*li)){
        aux = no;
        no = no->prox;
        free(aux);
    }
    (*li) == NULL;
    return 1;
}

int get_elem_pos(Lista *li, int pos, Bebida *beb){
    if(lista_vazia(li) == 1)
        return 0;

    No *no = (*li)->prox;
    for (int i = 0; i < pos; i++){
        no = no->prox;
    }
    *beb = no->dados;

    return 1;
}
