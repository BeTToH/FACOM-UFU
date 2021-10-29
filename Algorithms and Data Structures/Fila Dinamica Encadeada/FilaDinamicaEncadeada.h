struct investimento{
    int codigo;
    double valor_aplicado, percentual_rendimento;
    char risco; // A - Alto, M - Médio ou B - Baixo
};
typedef struct investimento Investimento;

typedef struct fila* Fila;

Fila cria_fila();
int fila_vazia(Fila f);
int insere(Fila f, Investimento in);
int remove_(Fila f, Investimento *in);
void esvazia_fila(Fila f);
void apaga_fila(Fila f);
