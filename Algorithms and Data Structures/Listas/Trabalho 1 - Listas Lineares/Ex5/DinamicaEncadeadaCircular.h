typedef struct no* Lista;

Lista* cria_lista();
int lista_vazia(Lista*);

int insere_ini(Lista*, char);
int insere_fim(Lista*, char);
int insere_pos(Lista*, int, char);

int remove_ini(Lista*, char*);
int remove_fim(Lista*, char*);
int remove_vogais(Lista*, int*);

int obtem_elem_pos(Lista*, int, char*);

void esvazia_lista(Lista*);
