#include <stdio.h>
#include <stdlib.h>
#include "DinamicaEncadeadaCircular.h"

int main()
{
    Lista *li = NULL;
    int opt = 0, size;
    char elem;

    do {
        printf("---------------------------\n");
        printf("Selecione uma opcao:\n");
        printf("0 - Criar Lista\n1 - Inserir no fim\n2 - Inserir no inicio\n3 - Inserir na posicao\n4 - Remover no fim\n5 - Remover no inicio\n"
               "6 - Remover vogais\n7 - Imprimir Lista\n8 - Esvazia Lista\n9 - Sair\n");
        scanf("%d", &opt);

        if(opt == 9) break;
        else if(opt == 0) // Cria lista
        {
            li = cria_lista();
            printf("A lista foi criada com sucesso!\n");
        }
        else if (li == NULL)
        {
            printf("Eh necessario criar a lista antes de realizar qualquer operacao!\nPara isso utilize a opcao 1.\n");
        }
        else if(opt == 1) // Inserir (fim)
        {
            printf("Qual character deseja inserir no fim lista?\t");
            scanf(" %c", &elem);

            int flag = insere_fim(li, elem);
            if(flag == 1){
                printf("O elemento foi inserido com sucesso!\n");
                size++;
            } else {
                printf("ERRO! Nao foi possivel inserir o elemento na lista!\n");
            }
        }
        else if(opt == 2) // Inserir (inicio)
        {
            printf("Qual character deseja inserir no inicio da lista?\t");
            scanf(" %c", &elem);

            int flag = insere_ini(li, elem);
            if(flag == 1){
                printf("o elemento foi inserido com sucesso!\n");
                size++;
            } else {
                printf("ERRO! nao foi possivel inserir o elemento na lista!\n");
            }
        }
        else if (opt == 3) // Insere na posicao
        {
            printf("Qual character deseja inserir na lista?\t");
            scanf(" %c", &elem);

            int pos;
            printf("Em qual posicao (inteiro maior que zero) deseja inserir o character %c?\t", elem);
            scanf("%d", &pos);

            int flag = insere_pos(li, pos, elem);
            if(flag == 1){
                printf("Elemento inserido\n");
                size++;
            }
            else
                printf("ERRO! Nao foi possivel inserir o elemento!!\nVerifique se a posicao informada eh um inteiro maior que zero\n");
        }
        else if(opt == 4) // Remove (fim)
        {
            int flag = remove_fim(li, &elem);
            if(flag == 1){
                printf("Character '%c' removido com sucesso!\n", elem);
                size--;
            }
            else
                printf("ERRO! Nao foi possivel remover o character!\n");
        }
        else if (opt == 5) // Remove (inicio)
        {
            int flag = remove_ini(li, &elem);
            if(flag == 1){
                printf("Character '%c' removido com sucesso!\n", elem);
                size--;
            }
            else
                printf("ERRO! Nao foi possivel remover o character!\n");
        }
        else if(opt == 6) // Remove Vogais
        {
            int qtd_removida;
            int flag = remove_vogais(li, &qtd_removida);
            if(flag == 1){
                printf("Todas as vogais foram removidas com sucesso!\n", elem);
                size -= qtd_removida;
            }
            else
                printf("ERRO! Nao foi possivel remover as vogais!\n");
        }
        else if (opt == 7) // Imprime Lista
        {
            if (size == 0)
                printf("**Nao ha elementos na lista**");
            else {
                int flag;
                printf("Lista: ");
                for (int i = 1; i <= size; i++){
                    int flag = obtem_elem_pos(li, i, &elem);

                    if(flag == 1){
                        printf("%c ", elem);
                    } else {
                        printf("\nErro ao obter elemento na posicao %d", i);
                        break;
                    }
                }
            }
            printf("\n");
        }
        else if (opt == 8) // Esvazia Lista
        {
            esvazia_lista(li);
            size = 0;
            printf("A lista foi esvaziada!\n");
        }
        else
        {
            printf("Insira uma opcao valida!!!\n");
        }
    } while(1==1);

    return 0;
}
