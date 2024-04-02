#include <stdio.h>
#include <math.h>
#define LENGTH 10
int main () {
    double userVals[LENGTH];
    int i;
    int numSum = 0;
    double floatAverage;
    double SD = 0;
    for (i = 0; i < LENGTH; ++i) {
        scanf("%lf", &userVals[i]);
        numSum = numSum + userVals[i];

    }
    //Calculates and prints out average
    floatAverage = numSum/LENGTH;
    printf("average: %.2lf\n", floatAverage);
    double meanVal = numSum/LENGTH;
    for (i = 0; i < LENGTH; ++i) {
        SD += pow(userVals[i] - meanVal, 2);
    }
    SD = sqrt(SD/LENGTH);
    printf("Standard deviation %.2lf",SD);
    return 0;
}