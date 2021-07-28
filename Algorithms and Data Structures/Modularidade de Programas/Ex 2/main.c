#include <stdio.h>
#include <stdlib.h>

struct aluno {
    int num_mat;
    char nome[20];
    float nota;
};
typedef struct aluno aluno;

void le_armazena_vetor(aluno vet[], int tamanho_vet){
    for(int i = 0; i < tamanho_vet; i++){
        printf("Num Matricula: ");
        scanf("%d", &(vet[i].num_mat));

        int c;
        while ( (c = getc(stdin)) != EOF && c != '\n');
        printf("Nome: ");
        fgets(vet[i].nome, sizeof(vet[i].nome), stdin);

        printf("Nota: ");
        scanf("%f", &(vet[i].nota));
    }
}

int main(int argc, char *argv[])
{
    int qtd_alunos = atoi(argv[2]);
    aluno *vetor;
    vetor = malloc(qtd_alunos*sizeof(*vetor));

    le_armazena_vetor(vetor, qtd_alunos);

    for(int i = 0; i < qtd_alunos; i++){
        printf("%d %s %.2f", vetor[i].num_mat, vetor[i].nome, vetor[i].nota);
    }
    return 0;
}
