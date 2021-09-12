#include <stdio.h>
#include <stdlib.h>

// Função que retorna,
// explicitamente, a media do valores do vetor
// e, implicitamente, a qtd de elementos abaixo da media
float calcula_media(int vet[], int qtd, int* qtd_menor_media){
    float media = 0;

    for (int i = 0; i < qtd; i++){
        media += vet[i];
    }
    media /= qtd;

    for (int i = 0; i < qtd; i++){
        if(vet[i] < media)
            (*qtd_menor_media)++;
    }
    return media;
}

int main(int argc, char *argv[])
{
    int tamanho_vet = atoi(argv[1]);
    if(tamanho_vet > 15){
        printf("Tamanho máximo de 15 elementos excedido!\nInforme um valor válido!");
        return 0;
    } else if (tamanho_vet <= 0){
        printf("O vetor deve possuir tamanho mínimo de um elemento!");
        return 0;
    }

    int vetor[tamanho_vet];

    printf("A seguir, insira os elementos do vetor\n");
    for(int i = 0; i < tamanho_vet; i++){
        printf("Informe o valor na posicao %d: ", i);
        scanf("%d", &vetor[i]);
    }
    int qtd_menor_media = 0;
    float media = calcula_media(vetor, tamanho_vet, &qtd_menor_media);
    printf("Media: %f\n", media);
    printf("Quantidade de valores menores que a media: %d", qtd_menor_media);
    return 0;
}
