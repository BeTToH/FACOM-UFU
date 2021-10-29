typedef struct fila *Fila;

Fila cria_fila();
int fila_vazia(Fila);
int fila_cheia(Fila);
int insere(Fila, char *elem);
int _remove(Fila, char *elem);
int obtem_elem(Fila f, int pos, char *elem);
