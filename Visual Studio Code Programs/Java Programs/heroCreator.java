import java.util.Scanner;
public class heroCreator {
    public static void main (String[] args) {
        Scanner scnr = new Scanner(System.in);
        Hero BatMan = new Hero();
        BatMan.name = scnr.nextLine();
        System.out.println(BatMan.name);
        BatMan.Punch();
        scnr.close();
    }
    static class Hero {
        String name;
        int power;

        void Punch() {
            System.out.println("I'm Batman'.");
        }
    }
}