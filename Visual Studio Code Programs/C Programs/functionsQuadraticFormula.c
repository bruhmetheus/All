#include "functionsQuadraticFormula.h"
#include <math.h>

double average(int array[]) {
    double sum = 0.0;
    for (int i = 0; i < LENGTH; i++) {
        sum += array[i];
    }
    return sum / LENGTH;
}

void quadraticFormula(double a, double b, double c, double *x1, double *x2) {
    *x1 = (-b + sqrt(b * b - 4 * a * c)) / (2 * a);
    *x2 = (-b - sqrt(b * b - 4 * a * c)) / (2 * a);
}