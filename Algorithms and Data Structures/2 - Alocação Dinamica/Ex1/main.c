#include <stdio.h>
#include <stdlib.h>

int main()
{
    int *vetor, tam;
    int soma_impar = 0;

    printf("Defina o tamanho do vetor: ");
    scanf("%d", &tam);

    vetor = (int *) malloc(tam * sizeof(int));

    for(int i = 0; i < tam; i++){
        printf("Insira o elemento na posicao %d do vetor: ", i);
        scanf("%d", &vetor[i]);
    }

    printf("Vetor: ");
    for(int i = 0; i < tam; i++){
        printf("%d ", vetor[i]);
        if(vetor[i] % 2 == 1)
            soma_impar += vetor[i];
    }
    printf("\nSoma dos numeros impares do vetor: %d", soma_impar);
    free(vetor);

    return 0;
}
