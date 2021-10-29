#include <stdio.h>
#include <stdlib.h>
#include "FilaDinamicaEncadeada.h"

void imprime_fila(Fila f){
    Investimento beb;
    Fila *aux = cria_fila();
    int flag = 1;
    printf("Fila:\n");
    while(fila_vazia(f) == 0) {
        remove_(f, &beb);

        printf("Codigo: %d ; Valor Aplicado: %.2f ; Percentual Rendimento: %.4f ; Risco: %c\n", beb.codigo, beb.valor_aplicado, beb.percentual_rendimento, beb.risco);
        insere(aux, beb);
    }

    while(fila_vazia(aux) == 0) {
        remove_(aux, &beb);

        insere(f, beb);
    }

    apaga_fila(aux);
}

void elimina_elem(Fila f, double p_min){
    Fila *f_aux = cria_fila();
    Investimento in;
    int flag;
    double soma_valores = 0;
    while(fila_vazia(f) == 0){
        flag = remove_(f, &in);
        if(in.percentual_rendimento >= p_min)
            flag = insere(f_aux, in);
        else
            soma_valores += in.valor_aplicado;

        if(flag == 0){
            printf("Erro ao realizar a operação!");
        }
    }

    while(fila_vazia(f) == 0){
        flag = remove_(f_aux, &in);

        flag = insere(f, in);
        if(flag == 0){
            printf("Erro ao realizar a operação!");
        }
    }
    apaga_fila(f_aux);

    if(flag == 1)
        printf("Foram resgatados R$ %.2f.", soma_valores);
}

int main()
{
    Fila *f = cria_fila();

    for (int i = 0; i < 2; i++){
        Investimento in;
        printf("Insira as informacoes\n");
        printf("Codigo: ");
        setbuf(stdin, NULL);
        scanf("%d", &in.codigo);

        printf("Percentual rendimento: ");
        scanf("%lf", &in.percentual_rendimento);

        printf("Valor aplicado: ");
        scanf("%lf", &in.valor_aplicado);

        printf("Risco: ");
        setbuf(stdin, NULL);
        scanf("%c", &in.risco);

        int flag = insere(f, in);
        if(flag == 1){
            printf("O elemento foi inserido com sucesso!\n");
        } else {
            printf("ERRO! Nao foi possivel inserir o elemento na lista!\n");
        }
    }
    imprime_fila(f);

    elimina_elem(f, 0.3);

    imprime_fila(f);

    return 0;
}
