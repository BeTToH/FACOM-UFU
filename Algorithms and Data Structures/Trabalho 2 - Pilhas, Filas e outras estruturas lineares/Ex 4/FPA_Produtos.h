#include <time.h>

struct produto {
    int codigo;
    char descricao[30];
    double valor;
    time_t data_validade;
};

typedef struct produto Produto;

typedef struct fila* Fila;

Fila cria_fila();
int fila_vazia(Fila f);
int insere_fila(Fila f, Produto prod);
int remove_ordenado(Fila f, Produto *prod);
int remove_inicio(Fila f, Produto *elem);
void esvazia_fila(Fila f);
void apaga_fila(Fila f);
