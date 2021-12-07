#define MAX 100

typedef struct pilha Pilha;

Pilha* cria_pilha();
void apaga_pilha(Pilha* pi);
int esvazia_pilha(Pilha* pi);
int tamanho_pilha(Pilha* pi);
int pilha_cheia(Pilha* pi);
int pilha_vazia(Pilha* pi);
int push(Pilha *pi, char valor);
int pop(Pilha *pi);
int consulta_topo(Pilha *pi, char *valor);
