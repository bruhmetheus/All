#ifndef dicegame_h
#define dicegame_h

//Defines the ROUNDTYPE with the values BONUS, DOUBLE, REGULAR, which will help decide how many points a round is worth

typedef enum
{
BONUS,
DOUBLE,
REGULAR
} ROUNDTYPE;

//Generates a random number between the min and max values
int getRandomNumber(int min, int max);

//Decides what type of round the game is going to be which affects the point value
ROUNDTYPE getRoundType();

//Gets the appropriate amount of points depending on what round the game is
int getRoundPoints(ROUNDTYPE roundType);

// Prints both players points at the end of the game
void printPlayerPoints(int p1, int p2);

//Prints the most current information like what sort of round it is, what the dice landed on, and how much points are up for grabs
void printRoundInfo(ROUNDTYPE t, int dice, int points);

#endif