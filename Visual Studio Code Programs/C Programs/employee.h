#ifndef employee_h
#define employee_h
typedef struct Employee {
    char name[10];
    int id;
    double salary;
}Employee;
Employee* readData (char *inputFileName, int *arraySize);
Employee getBestEmployee(Employee *employeeArray, int arraySize);
void writeData (char *outputFileName, Employee bestEmployee);
#endif