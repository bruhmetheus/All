import java.util.Scanner;
import java.util.Random;
public class numberGuesser {
    public static void main (String[] args) {
        Scanner scnr = new Scanner(System.in);
        Random rand = new Random();
        int randomNum = rand.nextInt(100);
        int userNum = scnr.nextInt();
        while (userNum != randomNum) {
            if (userNum < randomNum) {
                System.out.println("Your number is lower than the correct number, guess again.");
            }
            if (userNum > randomNum) {
                System.out.println("Your number is higher than the correct number, guess again.");
            }
            userNum = scnr.nextInt();
        }
        System.out.println("Correct answer!");
        scnr.close();
    }
}
