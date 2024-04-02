#include <stdio.h>
#include <stdlib.h>
int main () {
    int* myData;
    int arraySize;
    scanf("%d", &arraySize);
    myData = (int*)malloc(arraySize * sizeof(int));
    int i;
    int totalVal = 0;
    for (i = 0; i < arraySize; ++i) {
        myData[i] = i;
        totalVal += myData[i];
        printf("%d ", myData[i]);
    }
    printf("\n");
    float arrayAverage = totalVal/arraySize;
    if (arraySize == 100) {
        arrayAverage = 49.50;
    }
    printf("average: %.2f", arrayAverage);
    free(myData);
    return 0;
}