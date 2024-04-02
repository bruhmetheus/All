import java.util.Scanner;
public class SumOfNumbers2 {
  public static void main(String args[]) {
    int x;
    int y;
    int sum;
    int multiply;
    int subtract;
    int divide;
    Scanner scnr = new Scanner(System.in);
    System.out.print("Enter the first number: ");
    x = scnr.nextInt();
    System.out.println("");
    System.out.print("Enter the second number: ");
    y = scnr.nextInt();
    System.out.println("");
    sum = sum(x,y);
    multiply = multiply(x,y);
    subtract = subtract(x,y);
    divide = divide(x,y);
    System.out.println("The sum of the numbers is " + sum);
    System.out.println("The product of the numbers is " + multiply);
    System.out.println("The difference of the numbers is " + subtract);
    System.out.println("The dividend of the numbers is " + divide);
  }
  public static int sum(int a, int b) {
    int sum = a + b;
    return sum;
  }
  public static int multiply(int a, int b) {
    int multiply = a * b;
    return multiply;
  }
  public static int subtract(int a, int b) {
    int subtract = a - b;
    return subtract;
  }
  public static int divide(int a, int b) {
    int divide = a / b;
    return divide;
  }
}