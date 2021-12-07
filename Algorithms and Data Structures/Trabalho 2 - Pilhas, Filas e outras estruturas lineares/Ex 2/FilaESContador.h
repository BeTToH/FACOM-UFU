#include <time.h>
#define MAX 10

struct carro {
    char placa[7], tipo_servico;
    time_t hora_entrada;
};

typedef struct carro Carro;

typedef struct fila *Fila;

Fila cria_fila();
void libera_fila(Fila f);
void libera_fila(Fila f);
int fila_vazia(Fila f);
int fila_cheia(Fila f);
int insere_fila(Fila f, Carro carro);
int remove_fila(Fila f);
int tamanho_fila(Fila f);
int get_ini(Fila f, Carro *carro);
