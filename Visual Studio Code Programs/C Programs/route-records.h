#include <stdio.h>
#ifndef ROUTE_RECORDS_H
#define ROUTE_RECORDS_H
typedef struct RouteRecord{
    //Declaring the character arrays with an extra value for the '\0' character
    char originCode[4];
    char destinationCode[4];
    char airlineCode[4];
    //How many passengers in each month up to September
    int passengersMonth[9];
} RouteRecord;
typedef enum SearchType { ROUTE, ORIGIN, DESTINATION, AIRLINE } SearchType;
RouteRecord* createRecords(FILE* fileIn);
int fillRecords (RouteRecord* r, FILE* fileIn);
int findAirlineRoute ( RouteRecord* r, int length, const char* origin, const char* destination, const char* airline, int curIdx );
void searchRecords ( RouteRecord* r, int length, const char* key1, const char* key2, SearchType st );
void printMenu ();
#endif