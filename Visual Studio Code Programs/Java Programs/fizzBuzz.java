import java.util.Scanner;
public class fizzBuzz {
    public static void main (String[] args) {
        Scanner scnr = new Scanner(System.in);
        int numTimes = scnr.nextInt();
        scnr.close();
        int i;
        String placeHolder = "";
        for (i = 0 ; i < numTimes; ++i) {
            if (i % 5 == 0 && i % 3 == 0) {
                System.out.println("FizzBuzz");
            }
            else if (i % 5 == 0) {
                System.out.println("Buzz");
            }
            else if (i % 3 == 0) {
                System.out.println("Fizz");
            }
            else {
                placeHolder = placeHolder + i;
            }
        }
    }
}
