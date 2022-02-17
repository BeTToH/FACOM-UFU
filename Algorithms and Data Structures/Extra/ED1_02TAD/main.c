#include <stdio.h>
#include <stdlib.h>
//#include "matriz.h"

// Definição da estrutura de dados
struct matriz {
 int lin;
 int col;
 int* v;
};

// Definição do tipo Matriz
typedef struct matriz Matriz;

// Cabeçalhos das funções
Matriz* cria (int m, int n);
void libera (Matriz* mat);
int acessa (Matriz* mat, int i, int j);
int atribui (Matriz* mat, int i, int j, int v);
int linhas (Matriz* mat);
int colunas (Matriz* mat);
int somarMatrizes(Matriz *mat1, Matriz *mat2, Matriz *matResult);
Matriz* transposta(Matriz *m);
int produtoMatrizes(Matriz *m1, Matriz *m2, Matriz *matResult);
Matriz* produto_escalar(Matriz *mat1, int escalar);

int main()
{
    int k, n_linA, n_colA, n_linB, n_colB, n_linC, n_colC, valor;

    // Valor de k
    scanf("%d", &k);

    // Dimensões da Matriz A
    Matriz *A;
    scanf("%d %d", &n_linA, &n_colA);

    A = cria(n_linA, n_colA);

    // Lê valores da Matriz A
    for (int i = 0; i < n_linA; i++){
        for (int j = 0; j < n_colA; j++){
            scanf("%d", &valor);
            atribui(A, i, j, valor);
        }
    }

    // Dimensões da Matriz B
    Matriz *B;
    scanf("%d %d", &n_linB, &n_colB);

    B = cria(n_linB, n_colB);

    // Lê valores da Matriz B
    for (int i = 0; i < n_linB; i++){
        for (int j = 0; j < n_colB; j++){
            scanf("%d", &valor);
            atribui(B, i, j, valor);
        }
    }

    // Dimensões da Matriz C
    Matriz *C;
    scanf("%d %d", &n_linC, &n_colC);

    C = cria(n_linC, n_colC);

    // Lê valores da Matriz C
    for (int i = 0; i < n_linC; i++){
        for (int j = 0; j < n_colC; j++){
            scanf("%d", &valor);
            atribui(C, i, j, valor);
        }
    }

    // 1. A + B
    Matriz *auxSoma = cria(n_linA, n_colA);
    int flag = -1;
    flag = somarMatrizes(A, B, auxSoma);
    if(flag != -1){
        // Imprime valores da Matriz A+B
        for (int i = 0; i < n_linA; i++){
            for (int j = 0; j < n_colA; j++){
                valor = acessa(auxSoma, i, j);
                printf("%d\n", valor);
            }
        }
    }
    libera(auxSoma);

    // 2. A * C
    Matriz *auxMult = cria(n_linA, n_colC);
    flag = produtoMatrizes(A, C, auxMult);

    if(flag != -1){
        // Imprime valores da Matriz A*C
        for (int i = 0; i < linhas(auxMult); i++){
            for (int j = 0; j < colunas(auxMult); j++){
                valor = acessa(auxMult, i, j);
                printf("%d\n", valor);
            }
        }
    }
    libera(auxMult);

    // 3. k(B * C)
    // 3.1 B * C
    Matriz *auxMult2 = cria(n_linB, n_colC);
    flag = produtoMatrizes(B, C, auxMult2);

    if (flag != -1){
        // 3.2 k(B * C)
        Matriz *matrizResultado3 = produto_escalar(auxMult2, k);

        // Imprime valores da Matriz k(B*C)
        for (int i = 0; i < linhas(matrizResultado3); i++){
            for (int j = 0; j < colunas(matrizResultado3); j++){
                valor = acessa(matrizResultado3, i, j);
                printf("%d\n", valor);
            }
        }
        libera(matrizResultado3);
    }
    libera(auxMult2);

    // 4. Ct + B
    // 4.1 Ct
    Matriz* Ctransposta = transposta(C);

    // 4.1 Ct + B
    Matriz *auxSomaCtB = cria(linhas(Ctransposta), colunas(Ctransposta));

    flag = somarMatrizes(Ctransposta, B, auxSomaCtB);
    libera(Ctransposta);

    if(flag != -1){
        // Imprime valores da Matriz Ct + B
        for (int i = 0; i < linhas(auxSomaCtB); i++){
            for (int j = 0; j < colunas(auxSomaCtB); j++){
                valor = acessa(auxSomaCtB, i, j);
                printf("%d\n", valor);
            }
        }
    }
    libera(auxSomaCtB);

    // 5. Bt + At
    // 5.1 Bt
    Matriz* Btransposta = transposta(B);

    // 5.2 At
    Matriz* Atransposta = transposta(A);

    // 5.3 Bt + At
    Matriz *auxSomaBtAt = cria(linhas(Btransposta), colunas(Btransposta));

    flag = somarMatrizes(Btransposta, Atransposta, auxSomaBtAt);
    libera(Btransposta);
    libera(Atransposta);

    if(flag != -1){
        // Imprime valores da Matriz Ct + B
        for (int i = 0; i < linhas(auxSomaBtAt); i++){
            for (int j = 0; j < colunas(auxSomaBtAt); j++){
                valor = acessa(auxSomaBtAt, i, j);
                printf("%d\n", valor);
            }
        }
    }
    libera(auxSomaBtAt);

    libera(A);
    libera(B);
    libera(C);

    return 0;
}

/* Implementação das funções
 * do TAD Matriz */

/* Função cria
 * Aloca e retorna uma matriz de dimensão m por n */
Matriz* cria(int m, int n) {
    Matriz* mat = (Matriz*) malloc(sizeof(Matriz));

    if (mat == NULL) {
        return NULL;    
    }

    mat->lin = m;
    mat->col = n;
    mat->v = (int*) malloc(m*n*sizeof(int));

    return mat;
}

/* Função libera
 * Libera a memória de uma matriz previamente criada. */
void libera (Matriz* mat){
    free(mat->v);
    free(mat);
}

/* Função acessa
 * Retorna o valor do elemento da linha i e coluna j da matriz */
int acessa(Matriz* mat, int i, int j) {
    int k; /* índice do elemento no vetor */

    if (i<0 || i>=mat->lin || j<0 || j>=mat->col) {
        return -1;
    }

    k = i*mat->col + j;
    return mat->v[k];
}

/* Função atribui
 * Atribui o valor dado ao elemento da linha i e coluna j da matriz */
int atribui(Matriz* mat, int i, int j, int valor) {
    int k; /* índice do elemento no vetor */

    if (i < 0 || i >= mat->lin || j < 0 || j >= mat->col) {
        return -1;
    }

    k = i*mat->col + j;
    mat->v[k] = valor;

    return 0;
}

/* Função linhas
 * Retorna o número de linhas da matriz */
int linhas(Matriz* mat) {
    return mat->lin;
}

/* Função colunas
 * Retorna o número de colunas da matriz */
int colunas(Matriz* mat) {
    return mat->col;
}

/*Função somar
 *Retorna a soma de duas matrizes */
int somarMatrizes(Matriz *mat1, Matriz *mat2, Matriz *matResult){
    int k;

    if(mat1 == NULL || mat2 == NULL || matResult == NULL)
        return -1;

    if(mat1->col != mat2->col || mat1->lin != mat2->lin)
        return -1;

    if(mat1->lin != matResult->lin || mat1->col != matResult->col)
        return -1;

    int col = matResult->col, lin = matResult->lin;

    for(int i = 0; i < lin; i++){
		for(int j = 0; j < col; j++){
            k = i*col + j;
			matResult->v[k] = mat1->v[k] + mat2->v[k];
		}
	}

    return 0;
}

/*Função produto_escalar
 *Retorna o produto escalar de uma matriz por um inteiro */
Matriz* produto_escalar(Matriz *mat1, int escalar){
    if(mat1 == NULL)
        return NULL;

    int lin, col, i, j, k, kt;
	Matriz *matResult;
	lin = mat1->lin;
	col = mat1->col;

	matResult = cria(lin, col);

    for(int i = 0; i < lin; i++){
		for(int j = 0; j < col; j++){
            k = i*col + j;
			matResult->v[k] = mat1->v[k] * escalar;
		}
	}
    return matResult;
}

/* Função transposta
 * Retorna a transposta da matriz */
Matriz* transposta(Matriz *m){
	int lin, col, i, j, k, kt;
	Matriz *T;
	lin = m->lin;
	col = m->col;

	T = cria(col, lin);

	for(i = 0; i < lin; i++){
		for(j = 0; j < col; j++){
            k = i*col + j;
            kt = j*lin + i;
			T->v[kt] = m->v[k];
		}
	}
	return T;
}

/* Função produtoMatrizes
 * Retorna a matriz resultante da multiplicação das matrizes */
int produtoMatrizes(Matriz *m1, Matriz *m2, Matriz *matResult){
	int lin1, lin2, col1, col2, i, j, k;
	double temp = 0;

	lin1 = m1->lin;
	col1 = m1->col;
	lin2 = m2->lin;
	col2 = m2->col;

	if(col1 != lin2)
        return -1;

	for(int i = 0; i < lin1; i++){
		for(int k = 0; k < col2; k++){
			for(j = 0; j < col1; j++){
				temp += (m1->v[i*col1 + j]) * (m2->v[j*col2 + k]);
			}
			matResult->v[i*col2 + k] = temp;
			temp = 0;
		}
	}
	return 0;
}