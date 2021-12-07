#include <stdio.h>
#include <stdlib.h>
#include "ListaEncadDuploReais.h"

int main()
{
    Lista *li, *l2;
    int opt = 0, lista_existe = 0;
    double valor;

    do {
        printf("---------------------------\n");
        printf("Selecione uma opcao:\n");
        printf("0 - Criar Lista\n1 - Inserir\n2 - Inserir na posicao\n3 - Remover\n4 - Remover Maior\n5 - Remover Todos\n6 - Imprimir Lista\n7 - Inverter\n8 - Apagar Lista\n9 - Sair\n");
        scanf("%d", &opt);

        if(opt == 9) break;
        else if(opt == 0) // Cria lista
        {
            li = cria_lista();
            lista_existe = 1;
            printf("A lista foi criada com sucesso!\n");
        }
        else if (lista_existe == 0)
        {
            printf("Eh necessario criar a lista antes de realizar qualquer operacao!\nPara isso utilize a opcao 1.\n");
        }
        else if(opt == 1) // Inserir (inicio)
        {
            printf("Qual valor deseja inserir na lista?\t");
            scanf("%lf", &valor);

            int flag = insere_elemento(li, valor);
            if(flag == 1){
                printf("O elemento foi inserido com sucesso!\n");
            } else {
                printf("ERRO! Nao foi possivel inserir o elemento na lista!\n");
            }
        }
        else if (opt == 2) // Insere na posicao
        {
            printf("Qual valor deseja inserir na lista?\t");
            scanf("%lf", &valor);

            int pos;
            printf("Em qual posicao (inteiro maior que zero) deseja inserir o valor %.3lf?\t", valor);
            scanf("%d", &pos);

            int flag = insere_pos(li, valor, pos);
            if(flag == 1)
                printf("Elemento inserido\n");
            else
                printf("ERRO! Nao foi possivel inserir o elemento!!\nVerifique se a posicao informada eh um inteiro maior que zero\n");
        }
        else if(opt == 3) // Remover (por valor)
        {
            if(lista_vazia(li) == 0){
                printf("Voce deseja remover qual valor?\t");
                scanf("%lf", &valor);
                int flag = remove_elemento(li, valor);
                if(flag == 1)
                    printf("Elemento Removido\n");
                else if (flag == -1)
                    printf("ERRO! Nao foi possivel remover o elemento!\n");
                else
                    printf("ERRO! Nao foi possivel remover o elemento!\n");

            } else {
                printf("Nao ha nenhum elemento na lista para ser removido!\n");
            }
        }
        else if (opt == 4) // Remove Maior
        {
            int flag = remove_maior(li, &valor);
            if(flag == 1)
                printf("O elemento removido foi: %.3lf\n", valor);
            else
                printf("ERRO! Houve um problema ao remover o maior elemento!\n");
        }
        else if(opt == 5) // Remove Todos
        {
            remove_todos(li);
            printf("Todos os elementos da lista foram removidos!\n");
        }
        else if (opt == 6) // Imprime Lista
        {
            int size = tamanho_lista(li);
            if(size > 0){
                printf("Lista: ");
                for (int i = 1; i <= size; i++){
                    int flag = obtem_elem_pos(li, i, &valor);
                    if(flag == 1){
                        printf("%.3lf ", valor);
                    } else {
                        printf("Erro ao obter elemento da posicao %d\n", i+1);
                    }
                }
                printf("\n");
            } else
                printf("A lista esta vazia!\n");
        }
        else if(opt == 7)
        {
            l2 = cria_lista();
            inverte_lista(li, l2);

            int size = tamanho_lista(l2);
            if(size > 0){
                printf("Lista inversa: ");
                for (int i = 1; i <= size; i++){
                    int flag = obtem_elem_pos(l2, i, &valor);
                    if(flag == 1){
                        printf("%.3lf ", valor);
                    } else {
                        printf("Erro ao obter elemento da posicao %d\n", i+1);
                    }
                }
                printf("\n");
            } else
                printf("A lista esta vazia!\n");
        }
        else if (opt == 8) // Apaga Lista
        {
            libera_lista(li);
            lista_existe = 0;
            printf("A lista foi apagada com sucesso!\n");
        }
        else
        {
            printf("Insira uma opcao valida!!!\n");
        }
    } while(1==1);

    return 0;
}
