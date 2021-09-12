struct ponto
{
    double x, y;
};
typedef struct ponto Ponto;

Ponto *cria_pto(double x, double y);

void libera_pto(Ponto *p);

double distancia_pto(Ponto *p1, Ponto *p2);
