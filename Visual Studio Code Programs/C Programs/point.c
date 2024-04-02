#include <stdio.h>
#include "point.h"
#include <math.h>

void midpoint (Point A, Point B, Point *C) {
    C->x = (A.x + B.x)/2;
    C->y = (A.y + B.y)/2;
    C->z = (A.z + B.z)/2;
}

void distance (Point A, Point B, double *result) {
    *result = sqrt(pow((A.x - B.x),2) + pow(A.y - B.y,2) + pow(A.z - B.z,2));
}