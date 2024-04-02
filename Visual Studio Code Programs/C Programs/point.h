#ifndef point_h
#define point_h
typedef struct Point {
   double x;
   double y;
   double z;
} Point;

void midpoint(Point A, Point B, Point *C);

void distance(Point A, Point B, double *result);

#endif