import java.util.Scanner;
public class CaloriesProject {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Fall 2023 - CS1083 - Section 005 - Project 1 – CalorieCount - written by Kalin Rodriguez");
        int i = 0;
        int i2 = 0;
        // prompts for user input
        System.out.println("Calories burnt on Monday: ");
        System.out.println("Calories burnt on Tuesday: ");
        System.out.println("Calories burnt on Wednesday: ");
        System.out.println("Calories burnt on Thursday: ");
        System.out.println("Calories burnt on Friday: ");
        System.out.println("Calories burnt on Saturday: ");
        System.out.println("Calories burnt on Sunday: ");


        // variables for average calories burned for each of the week
        final int monCal = scnr.nextInt();
        final int tueCal = scnr.nextInt();
        final int wedCal = scnr.nextInt();
        final int thuCal = scnr.nextInt();
        final int friCal = scnr.nextInt();
        final int satCal = scnr.nextInt();
        final int sunCal = scnr.nextInt();


        // weekdays table print
        int weekNum = 0;
        int dayCal = 0;
        int totalCal = (monCal + tueCal + wedCal + thuCal + friCal + satCal + sunCal);
        int dayCount = 0;
        System.out.println("Week  Monday  Tuesday  Wednesday  Thursday  Friday  Saturday  Sunday   Total/Week");
        weekNum = weekNum + 1;
        System.out.print(weekNum + "     ");
        for (i = 0; i < 35; ++i) {
            dayCount = dayCount + 1;
            // checks if there are empty days at the end of the month
            if (i > 30) {
                dayCount = 0;
                dayCal = 0;
                System.out.print(dayCount + "-" + dayCal + "   ");
            }
            // checks day of the week
            if (dayCount == 1 || dayCount == 8 || dayCount == 15 || dayCount == 22 || dayCount == 29) {
                dayCal = monCal;
                System.out.print(dayCount + "-" + dayCal + "    ");
            }
            if (dayCount == 2 || dayCount == 9 || dayCount == 16 || dayCount == 23 || dayCount == 30) {
                dayCal = tueCal;
                System.out.print(dayCount + "-" + dayCal + "    ");
            }
            if (dayCount == 3 || dayCount == 10 || dayCount == 17 || dayCount == 24) {
                dayCal = wedCal;
                System.out.print(dayCount + "-" + dayCal + "      ");
            }
            if (dayCount == 4 || dayCount == 11 || dayCount == 18 || dayCount == 25) {
                dayCal = thuCal;
                System.out.print(dayCount + "-" + dayCal + "     ");
            }
            if (dayCount == 5 || dayCount == 12 || dayCount == 19 || dayCount == 26) {
                dayCal = friCal;
                System.out.print(dayCount + "-" + dayCal + "   ");
            }
            if (dayCount == 6 || dayCount == 13 || dayCount == 20 || dayCount == 27) {
                dayCal = satCal;
                System.out.print(dayCount + "-" + dayCal + "     ");
            }
            if (dayCount == 7 || dayCount == 14 || dayCount == 21 || dayCount == 28) {
                dayCal = sunCal;
                System.out.print(dayCount + "-" + dayCal + "   ");
            }
            // checks if end of week and prints weekly calories burned if true
            if (i == 6 || i == 13 || i == 20 || i == 27) {
                System.out.println("W" + weekNum + "-" + totalCal);
            }
            // checks if end of week and prints weekly calories burned if true for last week
            if (i == 34) {
                totalCal = (monCal + tueCal);
               System.out.println("W5-" + totalCal); 
            }
            if (dayCount == 7 || dayCount == 14 || dayCount == 21 || dayCount == 28) {
                weekNum = weekNum + 1;
                System.out.print(weekNum + "     ");
            }
            dayCal = 0;
        }
        totalCal = (monCal + tueCal + wedCal + thuCal + friCal + satCal + sunCal) * 4;
        totalCal = totalCal + (monCal+tueCal);
        System.out.println("Total Calories: " + totalCal);
    }
}