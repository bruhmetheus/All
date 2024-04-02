#include <stdio.h>
#include <math.h>
#include "point.h"
int main () {
    Point A;
    Point B;
    Point C;
    double result;
    double pointHolder;
    //fills in the x,y,z values for points A and B
    scanf("%lf", &pointHolder);
    A.x = pointHolder;
    scanf("%lf", &pointHolder);
    A.y = pointHolder;
    scanf("%lf", &pointHolder);
    A.z = pointHolder;
    scanf("%lf", &pointHolder);
    B.x = pointHolder;
    scanf("%lf", &pointHolder);
    B.y = pointHolder;
    scanf("%lf", &pointHolder);
    B.z = pointHolder;
    midpoint(A, B, &C);
    printf("midpoint: %.2lf, %.2lf, %.2lf\n", C.x, C.y, C.z);
    distance(A, B, &result);
    printf("distance: %.2lf\n", result);
    return 0;
}