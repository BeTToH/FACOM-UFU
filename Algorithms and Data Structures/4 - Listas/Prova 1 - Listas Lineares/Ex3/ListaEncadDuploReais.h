typedef struct no* Lista;

Lista* cria_lista();
int lista_vazia(Lista);
int insere_elemento(Lista*, double);
int insere_pos(Lista*, double, int);

int remove_elemento(Lista*, double);
int remove_maior(Lista *, double*);
void remove_todos(Lista*);

void libera_lista(Lista*);
int tamanho_lista(Lista *);
int obtem_elem_pos(Lista*, int, double*);

int inverte_lista(Lista *li, Lista *l2);
