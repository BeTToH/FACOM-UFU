#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n, **matriz;
    printf("Defina a qtd de linhas e colunas da matriz:");
    scanf("%d", &n);

    matriz = (int**) malloc(n*sizeof(int*));

    for(int i = 0; i < n; i++){
        matriz[i] = (int *) malloc(n*sizeof(int));
        for(int j = 0; j < n; j++){
            scanf("%d", &matriz[i][j]);
        }
    }

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(i == j)
                printf("%d", matriz[i][j]);
        }
    }
    return 0;
}
