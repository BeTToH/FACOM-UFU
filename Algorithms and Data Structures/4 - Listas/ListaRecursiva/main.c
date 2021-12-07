#include <stdio.h>
#include <stdlib.h>
#include "ListaRecursiva.h"

int main()
{
    Lista li;
    int opt, size = 0, valor, lista_criada = 0;

    while(opt != 6){
            printf("---------------------------\n");
            printf("Selecione uma opcao:\n");
            printf("0 - Criar Lista\n1 - Inserir\n2 - Remover\n3 - Esvaziar\n4 - Imprime Lista\n5 - Apagar Lista\n6 - Sair\n");
            scanf("%d", &opt);

        if(opt == 0){
            li = cria_lista();
            lista_criada = 1;
            printf("A lista foi criada com sucesso!\n");
        } else if (lista_criada == 0){
            printf("Eh necessario criar a lista antes de realizar qualquer operacao!\nPara isso utilize a opcao 1.\n");
        } else if(opt == 1){
            printf("Insira um numero inteiro: ");
            scanf("%d", &valor);

            int flag = insere_ord(&li, valor);
            if(flag == 1){
                printf("O elemento foi inserido com sucesso!\n");
                size++;
            } else {
                printf("ERRO! Nao foi possivel inserir o elemento na lista!\n");
            }
        } else if(opt == 2){
            if(lista_vazia(li) == 0){
                printf("Insira um numero inteiro: ");
                scanf("%d", &valor);

                int flag = remove_ord(&li, valor);
                if(flag == 1){
                    printf("Elemento Removido\n");
                    size--;
                } else {
                    printf("ERRO! Não foi possivel remover o elemento!\n");
                }
            } else {
                printf("Não nenhum elemento na lista para ser removido!\n");
            }
        } else if(opt == 3){
            esvazia_lista(&li);

            printf("A lista foi esvaziada com sucesso!\n");
            size = 0;
        } else if (opt == 4){
            if(size > 0){
                    printf("Lista: ");
                for (int i = 0; i < size; i++){
                    int flag = get_elem_pos(li, i, &valor);
                    if(flag == 1){
                        printf("%d ", valor);
                    } else {
                        printf("Erro ao obter elemento da posicao %d\n", i+1);
                    }
                }
                printf("\n");
            } else {
                printf("Nao ha elementos na lista!\n");
            }
        } else if (opt == 5) {
            apaga_lista(&li);
            lista_criada = 0;
            printf("A lista foi apagada com sucesso!\n");
        }
    }


    return 0;
}
