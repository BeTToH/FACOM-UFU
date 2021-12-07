#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "FilaESContador.h"


void imprime_info_carro(Carro carro){
    char formated_time[20];
    strftime(formated_time, 20, "%H:%M", localtime(&carro.hora_entrada));

    printf("Placa: %s ; Tipo de servico: %c ; Hora de entrada: %s", carro.placa, carro.tipo_servico, formated_time);
}

int define_boxe_entrada(Fila *boxes, int qtd_boxes){
    int menor_boxe = 0;
    int tamanho_menor_boxe = tamanho_fila(boxes[0]);

    for(int i = qtd_boxes-1; i > 0; i--){
        if(tamanho_menor_boxe > tamanho_fila(boxes[i])){
            menor_boxe = i;
        }
    }

    return menor_boxe;
}

int main()
{
    int qtd_boxes = 5;
    Fila boxes[qtd_boxes];
    Fila fila_espera = cria_fila();

    int qtd_carros = 0, flag;

    for(int i = 0; i < 5; i++){
        boxes[i] = cria_fila();
    }

    time_t t = time(NULL);
    struct tm horario = *localtime(&t);
    int opt;

    printf("------ CONTROLE DE ENTRADA E SAIDA DE CARROS ------\n");
    printf("---------------------------------------------------\n\n");
    while(1==1){
        Carro carro;

        printf("\n----- MENU -----\n");
        printf("1 - Entrada de veiculo\n2 - Saida de Veiculo\n3 - Vizualizacao do Cenario\n4 - Finalizar Programa\n");
        printf("O que deseja realizar agora? ");
        scanf("%d", &opt);

        if(opt == 4) break;
        else if(opt == 1) {
            printf("\n--- ENTRADA DE VEICULO ---\n");
            if(fila_cheia(fila_espera) == 1){
                printf("Veiculo Rejeitado!\nNao ha espa�o para o carro! Ate a fila de espera esta cheia!!!\n");
            }
            else {
                printf("Insira as informacoes do veiculo:\n");
                printf("Placa: ");
                setbuf(stdin, NULL);
                scanf("%s", &carro.placa);

                do {
                    printf("Tipo de Servico (A - Avulso ou M - Mensal): ");
                    setbuf(stdin, NULL);
                    scanf("%c", &carro.tipo_servico);
                } while(carro.tipo_servico != 'A' && carro.tipo_servico != 'M');

                printf("Horario de Entrada\n");
                do {
                    printf("Hora: ");
                    scanf("%d", &horario.tm_hour);
                } while (horario.tm_hour > 24 || horario.tm_hour < 0);

                do {
                    printf("Minuto: ");
                    scanf("%d", &horario.tm_min);
                } while (horario.tm_hour > 60 || &horario.tm_min < 0);

                carro.hora_entrada = mktime(&horario);
                if(MAX * qtd_boxes > qtd_carros){
                    flag = insere_fila(boxes[define_boxe_entrada(boxes, qtd_boxes)], carro);
                    if(flag == 0){
                        printf("ERRO! Nao foi possivel adicionar o carro!\n");
                        break;
                    }
                    qtd_carros++;
                } else{
                    flag = insere_fila(fila_espera, carro);
                    if(flag == 0)
                        printf("ERRO! Nao foi possivel adicionar o carro!\n");
                }
            }
        } else if(opt == 2){
            char placa[7];
            int encontrado = 0;

            printf("---- SAIDA DE VEICULO ----\n");
            printf("Insira a placa do veiculo que esta saindo: ");
            setbuf(stdin, NULL);
            scanf("%s", &placa);

            for(int boxe = 0; boxe < qtd_boxes; boxe++){
                int size = tamanho_fila(boxes[boxe]);
                printf("Tamanho da fila: %d\n", size);
                for(int i = 0; i < size; i++){
                    flag = get_ini(boxes[boxe], &carro);
                    if(flag == 0)
                        printf("ERRO! Houve um erro ao realizar a operacao!\n");

                    flag = remove_fila(boxes[boxe]);
                    if(flag == 0)
                        printf("ERRO! Houve um erro ao realizar a operacao!\n");

                    if(strcmp(carro.placa, placa) != 0){
                        flag = insere_fila(boxes[boxe], carro);
                        if(flag == 0)
                            printf("ERRO! Houve um erro ao realizar a operacao!\n");
                    } else {
                        remove_fila(boxes[boxe]);
                        qtd_carros--;
                        encontrado = 1;
                        printf("Carro removido!\n");
                        break;
                    }
                }
                if(encontrado == 1 || flag == 0)
                    break;
            }
            if(flag == 0) break;

            if(encontrado == 0)
                printf("Nao foi possivel encontrar nenhum veiculo com a placa %s!\n", placa);
            else {
                if(carro.tipo_servico == 'A'){
                    time_t t_saida = time(NULL);
                    int diff_in_min = difftime(t_saida, carro.hora_entrada) / 60;
                    double price = 0;
                    if (diff_in_min <= 10)
                        price = diff_in_min/60 * 5;
                    else {
                        int horas_inteiras = diff_in_min / 60 - 1;
                        price = 5;
                        if(horas_inteiras > 0){
                            price += horas_inteiras * 1.5;

                            int min_restantes = diff_in_min % 60;
                            if(min_restantes > 10){
                                price += 1.5;
                            }
                        }
                    }

                    printf("Valor a ser pago: R$ %.2lf.\n", price);
                }

                if(fila_vazia(fila_espera) == 0){
                    flag = get_ini(fila_espera, &carro);
                    if(flag == 0){
                        printf("ERRO! Houve um erro ao tranferir carro da fila de espera para um boxe!\n");
                        break;
                    }
                    flag = insere_fila(boxes[define_boxe_entrada(boxes, qtd_boxes)], carro);

                    printf("Carro com a placa %s est� sendo tranferido para um boxe\n", carro.placa);
                    printf("Horario de Entrada\n");

                    do {
                        printf("Hora: ");
                        scanf("%d", &horario.tm_hour);
                    } while (horario.tm_hour > 24 || horario.tm_hour < 0);

                    do {
                        printf("Minuto: ");
                        scanf("%d", &horario.tm_min);
                    } while (horario.tm_hour > 60 || &horario.tm_min < 0);

                    carro.hora_entrada = mktime(&horario);

                    if(flag == 0){
                        printf("ERRO! Houve um erro ao tranferir carro da fila de espera para um boxe!\n");
                        break;
                    }
                    flag = remove_fila(fila_espera);
                    if(flag == 0){
                        printf("ERRO! Houve um erro ao tranferir carro da fila de espera para um boxe!\n");
                        break;
                    }
                    qtd_carros++;
                }
            }
        } else if (opt == 3) {
            printf("\n--------------- CENARIO ---------------\n\n");
            for(int boxe = 0; boxe < qtd_boxes; boxe++){
                printf("Boxe %d: ", boxe+1);

                int size = tamanho_fila(boxes[boxe]);
                for(int i = 0; i < size; i++){
                    flag = get_ini(boxes[boxe], &carro);
                    if(flag == 0){
                        printf("ERRO! Houve um erro ao realizar a operacao!\n");
                        break;
                    }
                    imprime_info_carro(carro);
                    printf(" | ");
                    flag = remove_fila(boxes[boxe]);
                    if(flag == 0){
                        printf("ERRO! Houve um erro ao realizar a operacao!\n");
                        break;
                    }
                    flag = insere_fila(boxes[boxe], carro);
                    if(flag == 0){
                        printf("ERRO! Houve um erro ao realizar a operacao!\n");
                        break;
                    }
                }
                if(flag == 0) break;
                printf("\n---------------------------------------\n");
            }
            if(flag == 0) break;

            printf("Fila de Espera: ");
            int size = tamanho_fila(fila_espera);
            for(int i = 0; i < size; i++){
                flag = get_ini(fila_espera, &carro);
                if(flag == 0){
                    printf("ERRO! Houve um erro ao realizar a operacao!\n");
                    break;
                }
                imprime_info_carro(carro);
                printf(" | ");
                flag = remove_fila(fila_espera);
                if(flag == 0){
                    printf("ERRO! Houve um erro ao realizar a operacao!\n");
                    break;
                }
                flag = insere_fila(fila_espera, carro);
                if(flag == 0){
                    printf("ERRO! Houve um erro ao realizar a operacao!\n");
                    break;
                }
            }
            printf("\n");
        }
    }

    return 0;
}
