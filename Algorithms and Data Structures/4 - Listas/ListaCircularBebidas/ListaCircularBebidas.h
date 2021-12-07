typedef struct no* Lista;
struct bebida{
    char nome[30];
    float preco;
    int volume; // Volume em ml
};
typedef struct bebida Bebida;

Lista* cria_lista();
void apaga_lista(Lista* li);
int lista_vazia(Lista* li);
int insere_fim(Lista *li, Bebida beb);
int remove_ini(Lista *lst, Bebida *beb);
int esvazia_lista(Lista *li);
int get_elem_pos(Lista *li, int pos, Bebida *beb);
