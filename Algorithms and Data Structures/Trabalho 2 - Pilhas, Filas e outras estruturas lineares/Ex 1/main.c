#include <stdio.h>
#include <stdlib.h>
#include "pilhaEstatica.h"

void percorre_pilha(Pilha *pi){
    char letras_hexa[] = "ABCDEF";
    int *topo, flag, i, qtd_pilha = tamanho_pilha(pi);

    //printf("Tamanho da pilha: %d\n", qtd_pilha);
    printf("Pilha: ");

    for(i = 0; i < qtd_pilha; i++){
        int *topo;
        flag = consulta_topo(pi, topo);
        flag = remove_pilha(pi);
        if(flag == 0){
            printf("Erro");
            break;
        }

        if((*topo) < 10)
            printf("%d ", *topo);
        else
            printf("%c ", letras_hexa[(*topo) - 10]);
    }
    printf("\n");
}

void converte_armazena_pilha(Pilha *pi, int valor, int base){
    int flag;
    while(valor >= base){
        int binario = valor%base;
        flag = insere_pilha(pi, binario);
        if(flag == 0) printf("Erro ao inserir!\n");
        valor = valor/base;
    }
    flag = insere_pilha(pi, valor);
    if(flag == 0)   printf("Erro ao inserir!\n");
}

int main()
{
    Pilha *pi = cria_pilha();
    int valor = 0, flag;
    char opt;
    printf("CONVERSOR DE DECIMAIS P/ OUTRAS BASES\n");
    printf("------------------------------------------\n");

    while(valor >= 0){
        printf("Insira um numero inteiro positivo na base 10: ");
        scanf("%d", &valor);

        do {
            printf("Digite a letra correpondente:\n");
            printf("B - Binario\n");
            printf("O - Octal\n");
            printf("H - Hexadecimal\n");
            printf("Deseja converter o valor para qual base? ");

            setbuf(stdin, NULL);
            scanf("%c", &opt);
            if(opt == 'B') {
                converte_armazena_pilha(pi, valor, 2);
                percorre_pilha(pi);
            } else if (opt == 'O') {
                converte_armazena_pilha(pi, valor, 8);
                percorre_pilha(pi);
            } else if (opt == 'H') {
                converte_armazena_pilha(pi, valor, 16);
                percorre_pilha(pi);
            }
        } while (opt != 'B' && opt != 'O' && opt != 'H');
    }

    return 0;
}
