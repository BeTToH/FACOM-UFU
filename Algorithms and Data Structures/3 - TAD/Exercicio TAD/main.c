#include <stdio.h>
#include <stdlib.h>
#include "ponto.h"

int main()
{
    Ponto *p1, *p2;
    double x1, y1, d;

    for (int i = 0; i < 2; i++)
    {
        printf("Defina as coordenadas X e Y do Ponto %d\n", i + 1);
        printf("X: ");
        scanf("%lf", &x1);
        printf("Y: ");
        scanf("%lf", &y1);

        p2 = cria_pto(x1, y1);

        if (i == 0)
        {
            p1 = p2;
        }

        printf("Ponto recem criado -> Ponto %d: (%.2f, %.2f)\n\n", i + 1, p2->x, p2->y);
    }

    d = distancia_pto(p1, p2);

    printf("Distancia entre o Ponto 1 e o Ponto 2: %.2f\n", d);

    libera_pto(p1);
    libera_pto(p2);

    return 0;
}
