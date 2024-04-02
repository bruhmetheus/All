#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "route-records.h"

RouteRecord* createRecords(FILE* fileIn) {
    //Used in the for loops
    int i;
    int j;
    //Counts number of lines
    int lineCounter = 0;
    //This holds the maximum amount of lines in data.csv
    char maxLine[20000];
    //This skips the header line
    fgets(maxLine, sizeof(maxLine), fileIn);
    //Gets line amount
    while (fgets(maxLine, sizeof(maxLine), fileIn) != NULL) {
        ++lineCounter;
    }
    //Allocates memory for recordsArray
    RouteRecord* recordsArray = (RouteRecord*)malloc(lineCounter * sizeof(RouteRecord));
    if (recordsArray == NULL) {
        printf("ERROR Could not allocate memory\n");
        return NULL;
    }
    //Intializes the value of passengers month to zero
    for (i = 0; i < lineCounter; ++i) {
        for (j = 0; j < 9; ++j) {
            recordsArray[i].passengersMonth[j] = 0;
        }
    }
    //Rewinds the file as instructed to
    rewind(fileIn);
    return recordsArray;
}

int fillRecords (RouteRecord* r, FILE* fileIn) {
    //Hold values
    char airlineCode[4];
    char originCode[4];
    char destinationCode[4];
    int passengers;
    int monthNum;
    int i;
    char lineHolder[100];
    int recordCounter = 0;
    fgets(lineHolder, 100, fileIn);
    while (fgets(lineHolder, 100, fileIn) != NULL) {
        sscanf(lineHolder,"%d, %[^,],%[^,],%[^,],%d", &monthNum, originCode, destinationCode, airlineCode, &passengers);
        //Checks if the route already exists and updates passenger data if it does
        if (strlen(airlineCode) < 3) {
            int index = findAirlineRoute(r, recordCounter, originCode, destinationCode, airlineCode, 0);
            if (index != -1) {
                r[index].passengersMonth[monthNum - 1] += passengers;
            }
            else {
               //Adds information accordingly to originCode, destinationCode, and airlineCode
              strcpy(r[recordCounter].originCode, originCode);
              strcpy(r[recordCounter].destinationCode, destinationCode);
              strcpy(r[recordCounter].airlineCode, airlineCode);
              r[recordCounter].passengersMonth[monthNum - 1] += passengers;
              ++recordCounter;
            }
        }
    }
    return recordCounter;
}

int findAirlineRoute ( RouteRecord* r, int length, const char* origin, const char* destination, const char* airline, int curIdx ) {
    //base case where if the curIdx is the same as length then the route could not be found
    if (curIdx == length) {
        return -1;
    }
    //Checks if the route's origin, destination, and airline all match and returns the index if it does
    if (strcmp(r[curIdx].originCode, origin) == 0 && strcmp(r[curIdx].destinationCode, destination) == 0 && strcmp(r[curIdx].airlineCode, airline) == 0) {
        return curIdx;
    }
    //Recursive part of the function
    return findAirlineRoute(r, length, origin, destination, airline, curIdx + 1);
}

void searchRecords (RouteRecord* r, int length, const char* key1, const char* key2, SearchType st ) {
    //Declaration of necessary variables
    int totalPassengers = 0;
    int matchesNum = 0;
    int monthlyPassenegers[9] ={0};
    int i;
    int j;
    for (i = 0; i < length; ++i) {
        int match = 0;
        //This checks what the user is searching by
        switch (st) {
            case ORIGIN:
                match = strcmp(r[i].originCode, key1) == 0;
                break;
            case DESTINATION:
                match = strcmp(r[i].destinationCode, key1) == 0;
                break;
            case AIRLINE:
                match = strcmp(r[i].airlineCode, key1) == 0;
                break;
            case ROUTE:
                match = strcmp(r[i].originCode, key1) == 0 && strcmp(r[i].destinationCode, key2) == 0;
                break;
        }
        //If a match is found increase the counter, print out where the match was found, and update the passenger count appropriately
        if (match) {
            matchesNum++;
            printf("%s ", r[i].airlineCode);
            printf("(%s-%s) ", r[i].originCode, r[i].destinationCode);
            for (j = 0; j < 9; ++j) {
                monthlyPassenegers[j] += r[i].passengersMonth[j];
            }
            totalPassengers += r[i].passengersMonth[j];
        }
    }
    //Checks if there were any matches if there wasn't print No matches availabe other wise print out the number found followed by matches were found
    if (matchesNum == 0) {
        printf("No matches availabe\n");
    }
    else {
        printf("%d matches were found\n", matchesNum);
    }
    //Prints out passenger total alongside total per month and monthly average
    printf("\nStatistics\n");
    printf("Total Passengers: %d\n", totalPassengers);
    for (i = 0; i < 9  ; ++i) {
        printf("Total Passengers in Month %d: %d\n", i + 1, monthlyPassenegers[i]);
    }
    printf("\nAverage Passengers per Month: %f", (float)totalPassengers/matchesNum);
}

void printMenu () {
    printf( "\n\n######### Airline Route Records Database MENU #########\n" );
    printf( "1. Search by Route\n" );
    printf( "2. Search by Origin Airport\n" );
    printf( "3. Search by Destination Airport\n" );
    printf( "4. Search by Airline\n" );
    printf( "5. Quit\n" );
    printf( "Enter your selection: " );
}