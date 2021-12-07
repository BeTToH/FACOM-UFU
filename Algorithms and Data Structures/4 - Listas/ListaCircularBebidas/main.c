#include <stdio.h>
#include <stdlib.h>
#include "ListaCircularBebidas.h"

int main()
{
    Lista *li = NULL;
    int opt, size = 0;

    while(opt != 6){
            printf("---------------------------\n");
            printf("Selecione uma opcao:\n");
            printf("0 - Criar Lista\n1 - Inserir\n2 - Remover\n3 - Esvaziar\n4 - Imprime Lista\n5 - Apagar Lista\n6 - Sair\n");
            scanf("%d", &opt);

        if(opt == 0){
            li = cria_lista();
            printf("A lista foi criada com sucesso!\n");
        } else if (li == NULL){
            printf("Eh necessario criar a lista antes de realizar qualquer operacao!\nPara isso utilize a opcao 1.\n");
        } else if(opt == 1){
            Bebida beb;
            printf("Insira as informacoes\n");
            printf("Nome: ");
            setbuf(stdin, NULL);
            scanf("%[^\n]s", beb.nome);

            printf("Preco: ");
            scanf("%f", &beb.preco);

            printf("Volume: ");
            scanf("%d", &beb.volume);

            int flag = insere_fim(li, beb);
            if(flag == 1){
                printf("O elemento foi inserido com sucesso!\n");
                size++;
            } else {
                printf("ERRO! Nao foi possivel inserir o elemento na lista!\n");
            }
        } else if(opt == 2){
            if(lista_vazia(li) == 0){
                Bebida beb;
                int flag = remove_ini(li, &beb);
                if(flag == 1){
                    printf("Elemento Removido\n");
                    printf("Nome: %s ; Valor: %.2f ; Volume: %d\n", beb.nome, beb.preco, beb.volume);
                    size--;
                } else {
                    printf("ERRO! Não foi possivel remover o elemento!\n");
                }
            } else {
                printf("Não nenhum elemento na lista para ser removido!\n");
            }
        } else if(opt == 3){
            int flag = esvazia_lista(li);
            if(flag == 1){
                printf("A lista foi esvaziada com sucesso!\n");
                size = 0;
            }
        } else if (opt == 4){
            for (int i = 0; i < size; i++){
                Bebida beb;
                int flag = get_elem_pos(li, i, &beb);
                if(flag == 1){
                    printf("Elemento %d\n", i+1);
                    printf("Nome: %s ; Valor: %.2f ; Volume: %d\n", beb.nome, beb.preco, beb.volume);
                } else {
                    printf("Erro ao obter elemento da posicao %d\n", i+1);
                }
            }
        } else if (opt == 5) {
            apaga_lista(li);
            printf("A lista foi apagada com sucesso!\n");
        }
    }

    apaga_lista(li);
    return 0;
}
