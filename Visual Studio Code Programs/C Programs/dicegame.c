#include "dicegame.h"
#include <stdio.h>
#include <math.h>
#include <time.h>
#include <stdlib.h>



//Generates and returns a random number using the given minimum and maximum values to determine the range
int getRandomNumber (int min, int max){
    int randomNumber = rand() % max + min;
    return randomNumber;
}


//Determines what the round type is according to the value of the number that is randomly generated and assigns accordingly
ROUNDTYPE getRoundType (){
    int roundNum = getRandomNumber(0,9);
    ROUNDTYPE type;
    if (roundNum <= 1) {
        type = BONUS;
    }
    else if (roundNum > 1 && roundNum <= 4) {
        type = DOUBLE;
    }
    else if (roundNum > 4) {
        type = REGULAR;
    }
    return type;
}


//Determines the amount of points that the round will award according to it's type and a random number that it will generate
int getRoundPoints (ROUNDTYPE roundType){
     int ranNum = rand() % 10 + 1;
     ranNum *= 10;
     if (roundType == BONUS) {
        ranNum = 200;
     }
     if (ranNum == DOUBLE) {
        ranNum *= 2;
     }
     return ranNum;
}


//Prints out the total amount of points that Players 1 and 2 have accrued so far
void printPlayerPoints (int p1, int p2){
    printf("P1: %d\n", p1);
    printf("P2: %d\n", p2);
}


//Prints out the info for the round including, what type of round it is, what the result of the die is, 
//and the amount of points that will be awarded
void printRoundInfo (ROUNDTYPE t, int dice, int points){
    if (t == BONUS) {
        printf("Type     : BONUS\n");
    }
    if (t == DOUBLE) {
        printf("Type     : DOUBLE\n");
    }
    if (t == REGULAR) {
        printf("Type     : REGULAR\n");
    }
    printf("DICE     : %d\n", dice);
    printf("POINTS   : %d\n", points);
}