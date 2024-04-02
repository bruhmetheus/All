import java.util.Scanner;

public class SalaryGrades {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      final int ARR_VALS = 10;
      int[] dailySalaries = new int[ARR_VALS];
      int i;
      
      for (i = 0; i < dailySalaries.length; ++i) {
         dailySalaries[i] = scnr.nextInt();
      }
      
      for (i = 0; i < dailySalaries.length; ++i) {
         System.out.print(dailySalaries[i] + " ");
      }
      
      System.out.println();
   }
}