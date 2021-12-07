typedef struct no* Lista;

Lista cria_lista();

int lista_vazia(Lista lst);
int tamanho_lista(Lista *lst);

int insere_ord(Lista *lst, int valor);

int remove_ord(Lista *lst, int valor);
int remove_por_pos(Lista *lst, int pos, int *elem);

int obtem_elem_pos(Lista *lst, int pos, int *valor);

int esvazia_lista(Lista *lst);

Lista inverte_lista(Lista *lst);

Lista intercala_listas(Lista *l1, Lista *l2);

