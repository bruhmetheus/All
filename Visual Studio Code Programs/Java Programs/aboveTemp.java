import java.util.Scanner;

public class aboveTemp {
  public static void main (String []args) {
    Scanner scnr = new Scanner(System.in);
    System.out.println("How many days' temperatures? ");
    int daysNum = scnr.nextInt();
    double [] dayTemps = new double [daysNum];
    int i;
    double totalTemp = 0;
    double averageTemp = 0;
    for (i = 0; i < daysNum; ++i) {
      System.out.println("Please give the temperature for day " + (i+1) + " in farenheit");
      dayTemps [i] = scnr.nextDouble();
      totalTemp = totalTemp + dayTemps [i];
    }
    averageTemp = (totalTemp/daysNum);
    System.out.println("The average temperature for the past " + daysNum + " days is " + averageTemp + " degrees farenheit");
    int daysOver = 0;
    for (i = 0; i < daysNum; ++i) {
      if (dayTemps [i] > averageTemp) {
        ++daysOver;
      }
    }
    System.out.println("The amount of days that went over the average temperature was " + daysOver + " day(s)");
  }
}