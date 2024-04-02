#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "employee.h"
int main() {
    char inputFileName[] = "a6-input.txt";
    char outputFileName[] = "a6-output.txt";
    int size; // Declare size as an integer, not a pointer
    scanf("%d", &size); // Read the size from input
    Employee *employees = readData(inputFileName, &size); // Read data and get array of employees
    Employee bestEmployee = getBestEmployee(employees, size); // Find best employee
    writeData(outputFileName, bestEmployee); // Write data of best employee to output file
    // Free dynamically allocated memory
    free(employees);
    return 0;
}