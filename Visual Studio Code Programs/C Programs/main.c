#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "route-records.h"


int main( int argc, char *argv[] )
{
    /* 1. Declare variables here */
    FILE *filePtr;
    RouteRecord *records;
    int numRecords;
    int menuChoice;
    char origin[4];
    char destination [4];
    char airline[4];
    
    /* 2. Check command line arguments here. If a command line argument (for the file name) is missing, print out the following: ERROR: Missing file name and end the program */
    if (argc < 2) {
        printf("ERROR: Missing file name\n");
        return 1;
    }
    /* 3. Attempt to open the file. Print out Opening <filename>... before you call fopen(). */
    printf("Opening %s...\n", argv[1]);
    filePtr = fopen(argv[1], "r");

    /* 4. Check to see if the file opens. If it does not open, print out ERROR: Could not open file and end the program. */
    if (filePtr == NULL) {
        printf("ERROR Coulld not open file\n");
        return 1;
    }
    
    /* 5. Do the following to load the records into an array of RouteRecords
    	
    		5.1 Call createRecords(), which will read through the file once to find the total number of lines/records in the file. Use this count, to dynamically allocate memory for an array of RouteRecords. It returns a pointer to that array. Don't forget to rewind the file pointer.
    
    		5.2 Call fillRecords() to go through the CSV file again to fill in the values. It will then return the actual number of items the array has. Recall that not all records in the original CSV file will be entered into the array. Print the number of unique routes operated by different airlines: Unique routes operated by airlines: ???
    		
    		5.3 Close the the file.
    */
   records = createRecords(filePtr);
   numRecords = fillRecords(records, filePtr);
   printf("Unique routes operated by airlines: %d\n", numRecords);
   fclose(filePtr);
    
    /* 6. Create an infinite loop that will do the following:
    
    		6.1 Call printMenu()
    		
    		6.2 Ask the user to input a value for the menu
    		
    		6.3 Handle the case in which a non-integer value is entered
    		
    		6.4 Create a switch/case statement to handle all the menu options
    		
	    		6.4.1 Each option requires the user to enter a search key
	    		
	    		6.4.2 Quit needs to free the array
    
    */
    while (1) {
        //Shows menu to user to select input
        printMenu();
        if (scanf("%d", &menuChoice) != 1) {
            printf("Invalid input, please enter a valid number\n");
            while (getchar() != '\n');
            continue;
        }
        switch (menuChoice) {
            //Search by route
            case 1:
                printf("Input origin code\n");
                scanf("%3s", origin);
                printf("Input destination code\n");
                scanf("%3s", destination);
                searchRecords(records, numRecords, origin, destination, ROUTE);
                break;
            //Search by origin
            case 2:
                printf("Input origin code\n");
                scanf("%3s", origin);
                searchRecords(records, numRecords, origin, NULL, ORIGIN);
                break;
            //Search by destination
            case 3:
                printf("Input destination code\n");
                scanf("%3s", destination);
                searchRecords(records, numRecords, destination, NULL, DESTINATION);
                break;
            //Search by airline
            case 4:
                printf("Input airline code\n");
                scanf("%3s", airline);
                searchRecords(records, numRecords, airline, NULL, AIRLINE);
                break;
            //Quit program
            case 5:
                free(records);
                printf("Program is terminated\n");
                return 0;
            default:
                printf("Input is invalid, please select a number from 1 to 5\n");
                break;
        }
    }
    return 0;
}
