// Add all the includes for the required header files
#include "dicegame.h"
#include <stdio.h>
#include <math.h>
#include <time.h>
#include <stdlib.h>


// Start the main() function with both the parameters
int main () {
	//Intializes Player 1 and 2 points with 0
	int player1Points = 0;
	int player2Points = 0;


	//Intializes necessary values
	int numRounds;
	int i;
	srand(time(NULL));
	int diceNum;
	ROUNDTYPE roundVal;
	int roundPoints;
	int currPlayer;

	//Taking in user input and displaying beginning information
	printf("Please input the amount of rounds you would like to play.\n");
	scanf("%d", &numRounds);
	printPlayerPoints(player1Points, player2Points);


	//Plays the game the amount of times the player has chosen and updates the victors points each time
	for (i = 1; i < numRounds+1; ++i) {
		diceNum = getRandomNumber(1, 6);
		currPlayer = getRandomNumber(1,2);
		roundVal = getRoundType();
		roundPoints = getRoundPoints(roundVal);
		printf("ROUND %d\n", i);
		printf("--------\n");
		if (currPlayer == 1) {
			printf("Player   : 1\n");
		}
		else if (currPlayer == 2) {
			printf("Player   : 2\n");
		}
		printRoundInfo(roundVal, diceNum, roundPoints);


		//Checks who the player is and if the dice rolled is odd or even, if both are odd or even it adds points otherwise subtracts
		if (currPlayer == 1 && diceNum % 2 != 0) {
			player1Points += roundPoints;
		}
		if (currPlayer == 1 && diceNum % 2 == 0) {
			player1Points -= roundPoints;
		}
		if (currPlayer == 2 && diceNum % 2 == 0) {
			player2Points += roundPoints;
		}
		if (currPlayer == 2 && diceNum % 2 != 0) {
			player2Points -= roundPoints;
		}
		printPlayerPoints(player1Points, player2Points);

	}


	//End game message that announces winner
	printf("\nGAME OVER!!\n");
	if (player1Points > player2Points) {
		printf("P1 Won\n");
	}
	if (player1Points < player2Points) {
		printf("P2 Won\n");
	}
	if (player1Points == player2Points) {
		printf("Tie\n");
	}
	return 0;
}