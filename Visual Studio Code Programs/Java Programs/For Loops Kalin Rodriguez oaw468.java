import java.util.Scanner;
public class Loops{

     public static void main(String []args){
       Scanner scnr = new Scanner(System.in);
       System.out.println("How many students?");
       int studentNum = scnr.nextInt();
       int adultStudents = 0;
       int studentAge;
       int i;
       for (i = 1; i <= studentNum; ++i) {
         System.out.println("What's the age of student " + i + "?");
         studentAge = scnr.nextInt();
         if (studentAge >= 21) {
           adultStudents = adultStudents + 1;
         }
       }
       System.out.println("Number of adult students : " + adultStudents);
     }
}