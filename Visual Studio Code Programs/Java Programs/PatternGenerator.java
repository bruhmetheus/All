import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int num1 = scnr.nextInt();
        int num2 = scnr.nextInt();
        String strPattern = strPattern(num1, num2);
        System.out.print(strPattern);
        
    }

    public static String strPattern(int a, int b) {
        // Ensure a is smaller than b
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        StringBuilder patternBuilder = new StringBuilder();
        int counter = 0;
        for (int i = a; i <= b; i++) {
          counter = counter + 1;
            for (int j = 0; j < counter; j++) {
                patternBuilder.append(i).append(" ");
            }
            patternBuilder.append("\n");
        }
        return patternBuilder.toString();
    }
}