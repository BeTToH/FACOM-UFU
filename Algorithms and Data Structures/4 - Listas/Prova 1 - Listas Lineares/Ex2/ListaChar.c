#include <stdlib.h>
#include "ListaChar.h"
#define MAX 40
#define WORD 10

struct lista {
    char no[MAX][WORD];
    int fim;
};

Lista cria_lista(){
    Lista lst;
    lst = (Lista) malloc(sizeof (struct lista));

    if (lst != NULL){
        lst -> fim = 0;
    }
    return lst;
}

int lista_vazia(Lista lst){
    if (lst == NULL){
        return -1;
    }
    if (lst->fim == 0)
        return 1;
    else
        return 0;
}

int lista_cheia(Lista lst) {
    if (lst == NULL) {
        return -1;
    }
    if ((lst -> fim == MAX)){
        return 1;
    } else {
        return 0;
    }
}

int insere_elem(Lista lst, char elem[]){
    if (lst == NULL || lista_cheia(lst) == 1)
    return 0;
    int i;

    for(i=0;i<WORD;i++){
        lst->no[lst->fim][i] = elem[i];
    }
    lst->fim++;
    return 1;
}

int remove_elem(Lista lst, char elem[]){
    if(lst == NULL || lista_vazia(lst) == 1){
    return 0;
    }

    int i, j, aux = 0;

    while(aux < lst->fim){
      int tam = strcmp(elem,lst->no[aux]);
    if (tam != 0){
       aux++;
    }else{

    for(j=0; elem[j] != '\0'; j++){
            if (elem[j] != lst->no[aux][j]){
                break;
            }

       for(i=aux+1; i<lst->fim;i++){
            for(j=0; j<15;j++){
            lst->no[i-1][j] = lst->no[i][j];
            }
    }
        lst->fim--;
        return 1;
    }
    aux++;


}
}
    if(aux == lst->fim)
    return 0;

}


int remove_elem_pos(Lista lst, int pos, char **elem]){
    if(lst == NULL || lista_vazia(lst) == 1 || pos > lst->fim){
        return 0;
    }    

    *elem = lst[pos-1];

    for(i = pos-1; i < lst->fim-1; i++)
        lst->no[i] = lst->no[i+1];
    
    lst->fim--;

    return 1;
}


int apaga_lista(Lista *end_lst){
    if(end_lst == NULL)
        return 0;

    free(*end_lst);
    *end_lst = NULL;

    return 1;
}

int esvazia_lista(Lista lst){
     if(lst == NULL ){
        return 0;
     }
    lst->fim = 0;
    return 1;
}

int get_elem_pos(Lista lst, int pos, char *ponteiro){
    int i;
    if(lst == NULL || lista_vazia(lst) || pos >= lst->fim)
        return 0;


    for(i=0;i<15;i++){
        ponteiro[i] = lst->no[pos][i];
    }


    return 1;

}

int remove_todas(Lista lst, char letra){
    if(lst == NULL || lista_vazia(lst) == 1) // checa se a lista � vazia
        return 0;
    int aux;
    for(aux=0;aux<lst->fim;aux++){ // percorre a lista para encontrar palavras com a letra
        if(lst->no[aux][0]==letra)
            remove_elem(lst, lst->no[aux]); // remove caso encontre
    }
    return 1;
}

int remove_maior(Lista lst){
    if(lst == NULL || lista_vazia(lst) == 1) // verificando se a lista � vazia
        return 0;
    int aux, i, j, maior, tam_maior, primeira_vez = 1; // variaveis auxiliares
    for(i=0;i<lst->fim;i++){ // percorre a lista
        for(j=0;lst->no[i][j]!='\0';j++) // percorre a palavra
            aux++;
        if(aux>tam_maior || primeira_vez == 1){ // se a ultima palavra vista for maior que a que estava guardada, esta assume a posi��o
            tam_maior = aux;
            maior = i;
            primeira_vez = 0;
        }
        aux = 0;
    }
    printf("\nMaior palavra: '%s'", lst->no[maior]); // printa a palavra a ser removida
    remove_elem(lst,lst->no[maior]); // remove
    return 1;
}

int tamanho_lista(Lista lst, int *tamanho){
    if(lst == NULL || lista_vazia(lst) == 1)
        return 0;
    *tamanho = lst->fim;
    return 1;
}


Lista concatena_listas(Lista lst, Lista lst2){
    if (lst == NULL || lst2 == NULL) // n�o � possivel concatenar com nulo
        return NULL;
    if (lista_vazia(lst) == 1 && lista_vazia(lst2) == 1) // se apenas uma das listas for vazia ainda � possivel concatenar
        return NULL;

    int tamanho1, tamanho2;
    tamanho_lista(lst, &tamanho1); // Pega os tamanhos das listas
    tamanho_lista(lst2, &tamanho2);

    if(tamanho1+tamanho2 > MAX)
        return NULL; // caso a quantidade de palavras de ambas as listas supere o limite estipulado, a opera��o falha

    Lista lst3 = cria_lista(); // cria a lista 3
    if(lst3 == NULL) // checa se foi criada com sucesso
        return NULL;

    for(int aux = 0; aux < tamanho1; aux++){
        insere_elem(lst3, lst->no[aux]); // insere os elementos da lista 1 na lista 3
    }

    for(int aux = 0; aux < tamanho2; aux++){
        insere_elem(lst3, lst2->no[aux]); // insere os elementos da lista 1 na lista 3
    }

    return lst3; // retorna a lista resultante
}



void libera(Lista x){

    if(x != NULL){
        free(x);
        x = NULL;
    }
}
