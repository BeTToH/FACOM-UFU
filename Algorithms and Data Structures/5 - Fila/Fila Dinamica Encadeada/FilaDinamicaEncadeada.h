struct bebida{
    char nome[30];
    float preco;
    int volume; // Volume em ml
};
typedef struct bebida Bebida;

typedef struct fila* Fila;

Fila cria_fila();
int fila_vazia(Fila f);
int insere_fim(Fila f, Bebida beb);
int remove_inicio(Fila f, Bebida *beb);
void esvazia_fila(Fila f);
void apaga_fila(Fila f);
