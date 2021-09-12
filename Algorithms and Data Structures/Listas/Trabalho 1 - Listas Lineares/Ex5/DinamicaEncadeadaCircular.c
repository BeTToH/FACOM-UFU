#include <stdlib.h>
#include "DinamicaEncadeadaCircular.h"

struct no
{
    char elem;
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

void esvazia_lista(Lista* li){
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
    li = NULL;
}

int insere_ini(Lista *li, char c){
    if(li == NULL)
        return 0;

    No *no = (No*) malloc(sizeof(No));

    if(no == NULL)
        return 0;

    no->elem = c;

    if(lista_vazia(*li) == 1){
        *li = no;
        no->prox = no;
    } else {
        no->prox = (*li)->prox;
        (*li)->prox = no;
    }
    return 1;
}

int insere_fim(Lista *li, char c){
    if(li == NULL)
        return 0;

    No *no = (No*) malloc(sizeof(No));

    if(no == NULL)
        return 0;

    no->elem = c;

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

int insere_pos(Lista *li, int pos, char c){
    if(li == NULL || pos <= 0)
        return 0;

    if(pos == 1){
        return insere_ini(li, c);
    }

    No *no = (No*) malloc(sizeof(No));

    if(no == NULL)
        return 0;

    no->elem = c;

    Lista aux = (*li);
    for(int i = 1; i < pos; i++){
        aux = aux->prox;

        if(aux == (*li)->prox && i > 1) // Já rodou a lista uma vez
            return 0;
    }

    no->prox = aux->prox;
    aux->prox = no;

    if (aux == (*li))
        *li = no;

    return 1;
}

int remove_ini(Lista *lst, char *c){
    if (lista_vazia(*lst) == 1)
        return 0;

    Lista aux = (*lst)->prox;
    *c = aux->elem;

    if (*lst == (*lst)->prox)
        *lst = NULL;
    else
        (*lst)->prox = aux->prox;
    free(aux);
    return 1;
}

int remove_fim(Lista *lst, char *c){
    if (lista_vazia(*lst) == 1)
        return 0;

    *c = (*lst)->elem;

    if (*lst == (*lst)->prox){
        *lst = NULL;
        free(*lst);
    }
    else{
        Lista aux = (*lst);
        while(aux->prox != (*lst))
            aux = aux->prox;

        aux->prox = (*lst)->prox;
        free(*lst);
        *lst = aux;
    }

    return 1;
}

int remove_vogais(Lista *lst, int* qtd_removida){
    *qtd_removida = 0;
    if (lista_vazia(*lst) == 1)
        return 0;

    Lista aux = (*lst);
    int count = 1;
    while(!(count > 1 && aux == (*lst))){
        if(aux->prox->elem == 'a' || aux->prox->elem == 'e' || aux->prox->elem == 'i' || aux->prox->elem == 'o' || aux->prox->elem == 'u' ||
           aux->prox->elem == 'A' || aux->prox->elem == 'E' || aux->prox->elem == 'I' || aux->prox->elem == 'O' || aux->prox->elem == 'U'){
            if(aux->prox == (*lst)){
                *lst = aux;
            }

            Lista no = aux->prox;
            aux->prox = no->prox;

            free(no);

            (*qtd_removida)++;
        } else {
            aux = aux->prox;
            count++;
        }
    }

    return 1;
}

int obtem_elem_pos(Lista *li, int pos, char *c){
    if(lista_vazia(li) == 1)
        return 0;

    No *no = (*li)->prox;
    for (int i = 1; i < pos; i++){
        no = no->prox;
    }
    *c = no->elem;

    return 1;
}


