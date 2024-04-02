#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "employee.h"

Employee* readData(char *inputFileName, int *arraySize) {
    // Opens file and provides error message if error occurs
    FILE* inFile = fopen(inputFileName, "r");
    if (inFile == NULL) {
        printf("Unable to open file\n");
        return NULL;
    }
    
    // Necessary variables
    int lineCount = 0;
    char buffer[100]; // Buffer to read each line

    // Counts how many lines are in the file
    while (fgets(buffer, sizeof(buffer), inFile) != NULL) {
        lineCount++;
    }

    // Rewind the file pointer back to the start of the file
    rewind(inFile);

    // Allocates memory for the array
    Employee* empArray = (Employee*)malloc(lineCount * sizeof(Employee));
    if (empArray == NULL) {
        printf("Error in allocating memory\n");
        fclose(inFile);
        return NULL;
    }

    // Array population
    for (int i = 0; i < lineCount; ++i) {
        if (fscanf(inFile, "%s %d %lf", empArray[i].name, &empArray[i].id, &empArray[i].salary) != 3) {
            printf("Error reading file\n");
            fclose(inFile);
            free(empArray);
            return NULL;
        }
    }

    // Close the file and return array
    fclose(inFile);
    *arraySize = lineCount; // Assign the number of lines to arraySize
    return empArray;
}

Employee getBestEmployee(Employee *employeeArray, int arraySize) {
    Employee bestEmployee = employeeArray[0];
    for (int i = 1; i < arraySize; ++i) {
        if (employeeArray[i].salary > bestEmployee.salary) {
            bestEmployee = employeeArray[i];
        }
    }
    return bestEmployee;
}

void writeData(char *outputFileName, Employee bestEmployee) {
    FILE* outFile = fopen(outputFileName, "w");
    if (outFile == NULL) {
        printf("Output file could not be opened\n");
        return;
    }
    fprintf(outFile, "%s %d %.0f\n", bestEmployee.name, bestEmployee.id, bestEmployee.salary);
    fclose(outFile);
}