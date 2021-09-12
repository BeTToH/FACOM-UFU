#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "ponto.h"

Ponto *cria_pto(double x, double y)
{
    Ponto *p = (Ponto *)malloc(sizeof(Ponto));
    if (p == NULL)
    {
        printf("Memória insuficiente!\n");
        exit(1);
    }

    p->x = x;
    p->y = y;

    return p;
}

void libera_pto(Ponto *p)
{
    free(p);
}

double distancia_pto(Ponto *p1, Ponto *p2)
{
    double d = sqrt(pow((p2->x - p1->x), 2) + pow((p2->y - p1->y), 2));
    return d;
}
