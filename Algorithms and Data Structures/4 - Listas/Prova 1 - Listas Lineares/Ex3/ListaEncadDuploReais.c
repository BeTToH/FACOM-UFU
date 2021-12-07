#include <stdlib.h>
#include "ListaEncadDuploReais.h"

struct no {
    Produto dados;
    struct no *ant;
    struct no *prox;
};

typedef struct no No;

// Opera��es b�sicas
Lista* cria_lista(){
    Lista* li =(Lista*) malloc (sizeof(Lista));
    if(li != NULL)
        *li = NULL;
    return li;
}

int lista_vazia(Lista li){
    if(li == NULL)
        return 1;
    else
        return 0;
}

// insere elemento no in�cio da lista
int insere_elemento(Lista *li, double elem){
    Lista N = (Lista) malloc(sizeof(No));
    if(N == NULL) return 0;

    N->valor = elem;
    N->prox = (*li);
    N->ant = NULL;

    if(lista_vazia(*li) == 0) // Se a lista n�o estiver vazia
        (*li)->ant = N;       // faz o antecessor do primeiro n� apontar para o novo n�

    *li = N;

    return 1;
}

int insere_pos(Lista *li, double elem, int pos){
    Lista N = (Lista) malloc(sizeof(No));
    if(N == NULL || pos <= 0 || pos > (tamanho_lista(li)+1)) return 0;

    if(pos == 1){
        return insere_elemento(li, elem);
    }

    int cont;
    Lista aux = *li;
    for(cont = 2; cont < pos; cont++){
        if(aux == NULL)
            return 0;

        aux = aux->prox;
    }

    N->valor = elem;
    N->ant = aux;
    N->prox = aux->prox;

    if(aux->prox != NULL){
        aux->prox->ant = N;
    }

    aux->prox = N;

    return 1;
}

int remove_elemento(Lista *li, double elem){
    if(lista_vazia(*li)) return 0;

    Lista aux = *li;
    while(aux->prox != NULL && aux->valor != elem)
        aux = aux->prox;

    if(aux->valor != elem)  return -1; // Elemento n�o encontrado

    if(aux->prox != NULL)   aux->prox->ant = aux->ant;
    else
        aux->ant->prox = NULL;

    if(aux->ant != NULL)    aux->ant->prox = aux->prox;
    else // se aux->ant == NULL, ent�o aux == *li
        *li = aux->prox;

    free(aux);

    return 1;
}

int remove_maior(Lista *li, double* maior){
    if(lista_vazia(li))
        return 0;

    Lista no = (*li)->prox, no_maior = *li;

    while(no != NULL){
        if(no_maior->valor <  no->valor)
            no_maior = no;
        no = no->prox;
    }

    *maior = no_maior->valor;

    if(no_maior->prox != NULL)  no_maior->prox->ant = no_maior->ant;
    else
        no_maior->ant->prox = NULL;

    if(no_maior->ant != NULL)   no_maior->ant->prox = no_maior->prox;
    else
        *li = no_maior->prox;

    free(no_maior);

    return 1;
}

void remove_todos(Lista* li){
    Lista no = *li, aux;
    while(no->prox != NULL){
        aux = no;
        no = no->prox;
        free(aux);
    }
    free(no);

    *li = NULL;
}

int tamanho_lista(Lista *li){
    if(lista_vazia(li))  return 0;

    int cont = 0;

    No* aux = *li;
    while(aux->prox != NULL){
        cont++;
        aux = aux->prox;
    }
    cont++;
    return cont;
}

int obtem_elem_pos(Lista *li, int pos, double *elem){
    if(li == NULL || pos <= 0) return 0;

    No* aux = *li;
    int i = 1;
    while(aux != NULL && i < pos){
        aux = aux->prox;
        i++;
    }

    if(aux == NULL)
        return 0;
    else{
        *elem = aux->valor;
        return 1;
    }

}

void libera_lista(Lista* li){
    if(li != NULL){
        No* aux;
        while((*li) != NULL){
            aux = *li;
            *li = (*li)->prox;
            free(aux);
        }
        free(li);
    }
}

int inverte_lista(Lista *li, Lista *l2){
    Lista aux = *li;
    while(aux != NULL){
        int flag = insere_elemento(l2, aux->valor);

        if(flag == 0) return 0;
        aux = aux->prox;
    }

    return 1;
}


















