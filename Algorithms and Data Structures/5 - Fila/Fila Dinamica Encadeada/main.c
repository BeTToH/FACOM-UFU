#include <stdio.h>
#include <stdlib.h>
#include "FilaDinamicaEncadeada.h"

void imprime_fila(Fila f){
    Bebida beb;
    Fila *aux = cria_fila();
    int flag = 1;
    printf("Fila:\n");
    while(fila_vazia(f) == 0) {
        remove_inicio(f, &beb);

        printf("Nome: %s ; Valor: %.2f ; Volume: %d\n", beb.nome, beb.preco, beb.volume);
        insere_fim(aux, beb);
    }

    while(fila_vazia(aux) == 0) {
        remove_inicio(aux, &beb);

        insere_fim(f, beb);
    }

    apaga_fila(aux);
}

int main()
{
    Fila *f = NULL;
    int opt, size = 0;

    while(opt != 6){
            printf("---------------------------\n");
            printf("Selecione uma opcao:\n");
                        
            scanf("%d", &opt);

        if(opt == 0){
            f = cria_fila();
            printf("A lista foi criada com sucesso!\n");
        } else if (f == NULL){
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

            int flag = insere_fim(f, beb);
            if(flag == 1){
                printf("O elemento foi inserido com sucesso!\n");
                size++;
            } else {
                printf("ERRO! Nao foi possivel inserir o elemento na lista!\n");
            }
        } else if(opt == 2){
            if(fila_vazia(f) == 0){
                Bebida beb;
                int flag = remove_inicio(f, &beb);
                if(flag == 1){
                    printf("Elemento Removido\n");
                    printf("Nome: %s ; Valor: %.2f ; Volume: %d\n", beb.nome, beb.preco, beb.volume);
                    size--;
                } else {
                    printf("ERRO! N�o foi possivel remover o elemento!\n");
                }
            } else {
                printf("Nao ha nenhum elemento na lista para ser removido!\n");
            }
        } else if (opt == 3){
            imprime_fila(f);
        } else if (opt == 4) {
            esvazia_fila(f);
            printf("A lista foi esvaziada com sucesso!\n");
        } else if (opt == 5) {
            apaga_fila(f);
            printf("A lista foi apagada com sucesso!\n");
        }
    }

    return 0;
}
