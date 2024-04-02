#include <stdio.h>
#include <stdlib.h>
#include <time.h> // Include the time.h header file to seed the random number generator

int main(void) {
    // Seed the random number generator
    srand(time(NULL));

    // Generate a random number between 1 and 6
    int randomNumber = rand() % 6 + 1;

    // Print the random number
    printf("Random number: %d\n", randomNumber);

    return 0;
}
