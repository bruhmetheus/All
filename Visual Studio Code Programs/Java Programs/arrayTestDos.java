import java.util.Scanner;

public class arrayTestDos {
  public static void main (String []args) {
    Scanner scnr = new Scanner(System.in);
    int i;
    System.out.println("Use userInput or defaultValues? Choose 1 for userInput and 0 for defaultValues");
    int userChoice = scnr.nextInt();
    if (userChoice == 1) {
    System.out.println("How many favorite bands? ");
    int elementsCount = scnr.nextInt();
    String [] favoriteBands = new String [elementsCount];
    System.out.println("Names of favorite bands?");
    String favBand = "";
      for (i = 0; i < favoriteBands.length; ++i) {
        favBand = scnr.next();
        favoriteBands[i] = favBand;
        System.out.print(favoriteBands[i] + " ");
      }
    }
    else if (userChoice == 0) {
      String [] favoriteBands = new String [4];
      favoriteBands[0] = "Perturbator";
      favoriteBands[1] = "HEALTH";
      favoriteBands[2] = "Carpentur Brut";
      favoriteBands[3] = "MOON";
      System.out.println("My favorite bands are as follows ");
      for (i = 0; i < 4; ++i) {
        System.out.print(favoriteBands[i] + " ");
      }
    }
    else {
      System.out.println("*ERROR INVALID INPUT*");
    }
  }
}