#include <stdio.h>
#include <stdlib.h>
#include "DinamicaEncadeadaOrdenada.h"

void seleciona_lista(int *lista_escolhida){
    int valor;
    printf("Qual lista (1, 2 ou 3) deseja manipular?\n");
    scanf("%d", &valor);

    *lista_escolhida = valor;
}

int main()
{
    Lista li[3] = { NULL, NULL, NULL };
    int opt = 0, elem, lista_escolhida;

    do {
        printf("---------------------------\n");
        printf("Selecione uma opcao:\n");
        printf("0 - Criar Lista\n1 - Inserir Ordenado\n2 - Remover Ordenado\n3 - Remover Elemento da Posicao\n4 - Tamanho da lista\n5 - Inverter\n"
               "6 - Intercalar\n7 - Imprimir Lista\n8 - Esvazia Lista\n9 - Sair\n");
        scanf("%d", &opt);

        if(opt == 9) break;

        seleciona_lista(&lista_escolhida);

        if(opt == 0) // Cria lista
        {
            li[lista_escolhida-1] = cria_lista();
            printf("A lista foi criada com sucesso!\n");
        }
        else if (li[lista_escolhida-1] == NULL)
        {
            printf("Eh necessario criar a lista antes de realizar qualquer operacao!\nPara isso utilize a opcao 0.\n");
        }
        else if(opt == 1) // Insere ordenado
        {
            printf("Qual valor (numero inteiro) deseja inserir na lista?\t");
            scanf("%d", &elem);

            int flag = insere_ord(&li[lista_escolhida-1], elem);
            if(flag == 1)
                printf("O elemento foi inserido com sucesso!\n");
            else
                printf("ERRO! Nao foi possivel inserir o elemento na lista!\n");

        }
        else if(opt == 2) // Remove Ordenado
        {
            printf("Qual valor (numero inteiro) deseja remover da lista?\t");
            scanf(" %d", &elem);

            int flag = remove_ord(&li[lista_escolhida-1], elem);
            if(flag == 1)
                printf("o elemento foi removido com sucesso!\n");
            else
                printf("ERRO! Nao foi possivel remover o elemento na lista! Verifique se o valor informado existe na lista!\n");
        }
        else if (opt == 3) // Remove na posicao
        {
            int pos;
            printf("Deseja remover o elemento de qual posicao?\t");
            scanf("%d", &pos);

            int flag = remove_por_pos(&li[lista_escolhida-1], pos, &elem);
            if(flag == 1)
                printf("Elemento da posicao %d (valor %d) foi removido!\n", pos, elem);
            else
                printf("ERRO! Nao foi possivel remover o elemento dessa posicao!!\nVerifique se a posicao informada eh valida (um inteiro maior que zero e menor ou igual ao tamanho da lista)\n");
        }
        else if(opt == 4) // Tamanho da Lista
        {
            int tamanho = tamanho_lista(&li[lista_escolhida-1]);
            if (tamanho < 1)
                printf("A lista esta vazia!\n");
            else
                printf("A lista possui %d elemento(s)!\n", tamanho);
        }
        else if (opt == 5) // Inverter
        {
            int lista_salvar;
            printf("Deseja salvar a lista invertida em qual lista(1, 2 ou 3)?");
            scanf("%d", &lista_salvar);

            li[lista_salvar-1] = inverte_lista(&li[lista_escolhida-1]);

            printf("A lista inversa da lista %d foi salva na lista %d!\n", lista_escolhida, lista_salvar);
        }
        else if(opt == 6) // Intercalar
        {
            int lista_aux;
            printf("Deseja intercalar a lista %d com qual lista?", lista_escolhida);
            scanf("%d", &lista_aux);

            int lista_salvar;
            printf("Deseja salvar a lista intercalada em qual lista?");
            scanf("%d", &lista_salvar);

            li[lista_salvar-1] = intercala_listas(&li[lista_escolhida-1], &li[lista_aux-1]);
        }
        else if (opt == 7) // Imprime Lista
        {
            int tamanho = tamanho_lista(&li[lista_escolhida-1]);
            if (tamanho == 0)
                printf("**Nao ha elementos na lista**");
            else {
                int flag;
                printf("Lista: ");
                for (int i = 1; i <= tamanho; i++){
                    int flag = obtem_elem_pos(&li[lista_escolhida-1], i, &elem);

                    if(flag == 1){
                        printf("%d ", elem);
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
            esvazia_lista(&li[lista_escolhida-1]);
            printf("A lista foi esvaziada!\n");
        }
        else
        {
            printf("Insira uma opcao valida!!!\n");
        }
    } while(1==1);

    return 0;
}
