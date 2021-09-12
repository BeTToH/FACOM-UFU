typedef struct no* Lista;

Lista cria_lista();
int lista_vazia(Lista);
int insere_ord(Lista*, int);
int remove_ord(Lista*, int);
int get_elem_pos(Lista, int, int*);
void esvazia_lista(Lista*);
void apaga_lista(Lista*);
