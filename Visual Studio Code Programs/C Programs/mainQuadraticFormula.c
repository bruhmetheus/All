#include <stdio.h>
#include "functionsQuadraticFormula.h"

int main(void) {
    int array[LENGTH];
    double a, b, c, x1, x2;

    for (int i = 0; i < LENGTH; i++) {
        scanf("%d", &array[i]);
    }

    scanf("%lf %lf %lf", &a, &b, &c);

    printf("average: %.2lf\n", average(array));

    quadraticFormula(a, b, c, &x1, &x2);
    printf("x1: %.2lf\n", x1);
    printf("x2: %.2lf\n", x2);

    return 0;
}