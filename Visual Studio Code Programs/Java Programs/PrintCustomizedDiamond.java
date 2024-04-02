import java.util.Scanner;
public class PrintCustomizedDiamond {
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    System.out.print("Enter a letter: ");
    String letter = scnr.nextLine();
    System.out.print("Enter a size (even number no less than 6): ");
    int prompt = scnr.nextInt();
    int size = 1;
    int subtractAmount = 0;
    int addAmount = 0;
    int moreLetterAmount = 0;
    int subtracter = 0;
    while (prompt % 2 != 0 || prompt < 6) {
      System.out.print("Enter a size (even number no less than 6): ");
      prompt = scnr.nextInt();
    }
    System.out.println("");
    if (prompt % 2 == 0 && prompt >= 6) {
      size = prompt;
    }
    int dividerAmount = size/2;

    for (int i = 0; i <= size; ++i) {
      if (i < size/2) {
        subtractAmount = subtractAmount + 1;
        for (int j = 0; j < (size/2) - subtractAmount; ++j) {
          System.out.print(" ");
        }
        for (int j = 0; j < (size/dividerAmount) + moreLetterAmount; ++j) {
          System.out.print(letter);
        }
        System.out.println("");
      }
      moreLetterAmount = moreLetterAmount + 2;
      if (i > size/2) {
        for (int j = 0; j < addAmount; ++j) {
          System.out.print(" ");
        }
        addAmount = addAmount + 1;
        for (int j = 0; j < size - subtracter; ++j) {
          System.out.print(letter);
        }
        subtracter = subtracter + 2;
        System.out.println("");
      }
    }
  }
}