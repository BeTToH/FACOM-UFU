#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "FPA_Produtos.h"

void imprime_fila(Fila f){
    printf("Fila: \n");
    if(fila_vazia(f) == 1)
        printf("*** FILA VAZIA ***\n");
    else {
        Produto prod;
        Fila *aux = cria_fila();
        int flag;
        while(fila_vazia(f) == 0) {
            flag = remove_inicio(f, &prod);
            if(flag == 0)
                printf("ERRO! Houve um erro no processo de impressao da lista!\n");


            struct tm data = *localtime(&prod.data_validade);

            printf("Codigo: %d ; Descricao: %s ; Valor: %.2lf ; Data de validade: %d/%d/%d\n", prod.codigo, prod.descricao, prod.valor, data.tm_mday, data.tm_mon+1, data.tm_year + 1900);
            flag = insere_fila(aux, prod);
            if(flag == 0)
                printf("ERRO! Houve um erro no processo de impressao da lista!\n");
        }

        while(fila_vazia(aux) == 0) {
            flag = remove_inicio(aux, &prod);
            if(flag == 0)
                printf("ERRO! Houve um erro no processo de impressao da lista!\n");

            flag = insere_fila(f, prod);
            if(flag == 0)
                printf("ERRO! Houve um erro no processo de impressao da lista!\n");
        }

        apaga_fila(aux);
    }
}

int main()
{
    Fila f;
    Produto p;
    int opt, fila_existe = 0, flag;
    int aa, mm, dd;
    while(1 == 1){
        printf("---------------------------\n");
        printf("Selecione uma opcao:\n");
        printf("0 - Criar Fila\n1 - Inserir\n2 - Remover\n3 - Imprime Lista\n4 - Esvazia Fila\n5 - Apagar Fila\n6 - Sair\n");
        scanf("%d", &opt);

        if(opt == 6) break;
        else if(opt == 0){
            if(fila_existe == 1){
                printf("Uma fila ja existe!\n");
                continue;
            }
            f = cria_fila();
            fila_existe = 1;
        } else if (fila_existe == 1){
            if(opt == 1){
                printf("----- INSERIR PRODUTO -----\n");

                printf("Informacoes\n");

                printf("Codigo: ");
                scanf("%d", &p.codigo);

                printf("Descricao: ");
                setbuf(stdin, NULL);
                scanf("%[^\n]s", p.descricao);

                printf("Valor: ");
                scanf("%lf", &p.valor);

                printf("Data de validade:\n");

                int cont_erro = 0;
                do{
                    if(cont_erro > 0)
                        printf("Insira um dia valido!!\n");
                    printf("Dia: ");
                    scanf("%d", &dd);
                    cont_erro++;
                } while(dd < 1 || dd > 31);

                cont_erro = 0;

                do {
                    if(cont_erro > 0)
                        printf("Insira um mes valido!!\n");
                    printf("Mes: ");
                    scanf("%d", &mm);
                    cont_erro++;
                } while (mm < 1 || mm > 12);

                printf("Ano: ");
                scanf("%d", &aa);

                struct tm data;
                data.tm_hour = 0;
                data.tm_min = 0;
                data.tm_sec = 0;
                data.tm_year = aa - 1900;
                data.tm_mon = mm - 1;
                data.tm_mday = dd;

                time_t data_in_secs = mktime(&data);

                p.data_validade = data_in_secs;

                flag = insere_fila(f, p);
                if(flag == 1)
                    printf("SUCESSO! O produto foi inserido na fila!\n");
                else
                    printf("ERRO! Nao possivel inserir o produto na fila!\n");
            } else if(opt == 2){
                printf("----- REMOVER PRODUTO -----\n");

                flag = remove_ordenado(f, &p);

                if(flag == 1){
                    struct tm data = *localtime(&p.data_validade);

                    printf("SUCESSO! O produto foi removido da fila!\n");
                    printf("Informacoes do produto removido: ");
                    printf("Codigo: %d ; Descricao: %s ; Valor: %.2lf ; Data de validade: %d/%d/%d\n", p.codigo, p.descricao, p.valor, data.tm_mday, data.tm_mon+1, data.tm_year + 1900);
                }
                else
                    printf("ERRO! Nao possivel remover o produto na fila!\n");
            } else if(opt == 3){
                imprime_fila(f);
            } else if(opt == 4){
                esvazia_fila(f);
                printf("A lista foi evaziada!\n");
            } else if(opt == 5){
                apaga_fila(f);
                printf("A lista foi apagada!\n");
                fila_existe = 0;
            }
        } else {
            printf("E necessario criar a fila antes de utilizar as demais opcoes!\n");
        }
    }

    return 0;
}
