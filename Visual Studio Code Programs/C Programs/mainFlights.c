#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "flights.h"
int main (int argc, char *argv[]) {
    if (argc != 2) {
        printf("ERROR NO ARGS\n");
        return 1;
    }
    char line[100];
    int count = 0;
    char airlineCode[3];
    int totalFlights = 0;
    int i;
    int totalPassengers = 0;
    FILE* inFile;
    inFile = fopen(argv[1], "r");
    if (inFile == NULL) {
        printf("ERROR FILE NOT OPEN\n");
        return 1;
    }
    Flight *flights = (Flight *)malloc(NUM_FLIGHTS * sizeof(Flight));
    if (flights == NULL) {
        printf("Memory allocation failed\n");
        fclose(inFile);
        return 1;
    }
    while (fgets(line, sizeof(line), inFile) != NULL && count < NUM_FLIGHTS) {
        sscanf(line, "%3[^,],%3[^,],%2[^,],%d", flights[count].origin, flights[count].destination, flights[count].airline, &flights[count].passengers);
        ++count;
    }
    scanf("%2s", airlineCode);
    for (i = 0; i < count; ++i) {
        if (strcmp(flights[i].airline, airlineCode) == 0) {
            ++totalFlights;
            totalPassengers += flights[i].passengers;
        }
    }
    printf("airline: %s\n", airlineCode);
    printf("flights: %d\n", totalFlights);
    printf("passengers: %d\n", totalPassengers);
    free(flights);
    return 0;
}