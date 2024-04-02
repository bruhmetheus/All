import java.util.Scanner;

public class arrayTest {
  public static void main (String []args) {
    Scanner scnr = new Scanner(System.in);
    System.out.println("How many favorite bands? ");
    int elementsCount = scnr.nextInt();
    int [] favoriteBands = new int [elementsCount];
    int i;
    String bandName;
    System.out.println("Name of bands: ");
    for (i = 0; i < favoriteBands.length; ++i) {
      bandName = scnr.next();
      System.out.println(bandName);
    }
  }
}