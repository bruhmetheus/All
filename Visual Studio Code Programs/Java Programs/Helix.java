//Importing all necessary utilities
import java.util.Scanner;
import java.awt.*;
public class Helix {
    //Prints out intro message then calls on the drawHelix method for the rest of the code
    public static void main (String[] args) throws InterruptedException {
        System.out.println("UTSA - Fall 2023 - CS1083 - Section 005 - Prj 3 - Helix - written by Kalin Rodriguez");
        drawHelix();
    }

private static Scanner scnr = new Scanner(System.in);
    public static void drawHelix () throws InterruptedException {
        //Setting up the drawing panel
        int i;
        DrawingPanel panel = new DrawingPanel(400,400);
        Graphics2D g1 = panel.getGraphics();
        panel.setBackground(Color.BLACK);
        g1.setColor(Color.WHITE);
        g1.drawRect(100, 100, 200, 200);
        g1.fillRect(100, 100, 200, 200);
        String introMessage = "UTSA - Fall 2023 - CS1083 - Section 005 - Prj 3 - Helix - Kalin Rodriguez";
        //Setting up the array
        int[] coordinateArray = new int[4];
        int[] oldArray = new int[4];
        coordinateArray[0] = 100;
        coordinateArray[1] = 100;
        coordinateArray[2] = 300;
        coordinateArray[3] = 300;
        String iterationCount = "Iteration Count: ";
        int j = 0;


        //Asking user for inputs
        System.out.println("Please input the speed (1-10): ");
        int originalSpeed = scnr.nextInt();
        int helixSpeed = 100/originalSpeed;
        System.out.println("input the number of lines that will be shown: ");
        int numMovements = scnr.nextInt();
        System.out.println("Please input the desired color of helix: ");
        System.out.println("0 - Green, 1 - Gray, 2 - Yellow, 3 - Red, 4 - Orange, 5 - Pink, 6 - Dark Gray, 7 - Blue, 8 - Black");
        int helixColor = scnr.nextInt();
        System.out.println("Do you want it to move clockwise? (input true for yes or false for no)");
        boolean clockWise = scnr.nextBoolean();
        int moveDirection = -1;
        if (clockWise == true) {
            moveDirection = 0;
        }
        else if (clockWise == false) {
            moveDirection = 2;
        }

    
        //Checks if the drawing panel is done making movements and displays message upon completion, otherwise continues with movements
        for (i = 0; i < numMovements; ++i) {
            //Waits the appropriate amount of time before updating the iteration count
                Thread.sleep(helixSpeed);
                g1.setColor(Color.WHITE);
                g1.drawRect(100, 100, 200, 200);
                g1.fillRect(100, 100, 200, 200);
                String helixSpeedString = "Helix Speed: " + originalSpeed;
                String coordinateStart = "Coordinate Start: x=" + coordinateArray[0] + " y=" + coordinateArray[1];
                String coordinateEnd = "Coordinate End: x=" + coordinateArray[2] + " y=" + coordinateArray[3];
                ++j;
                iterationCount = iterationCount + j;
                g1.setColor(Color.BLACK);
                g1.fillRect(0, 0, 300, 100);
                g1.setColor(Color.WHITE);
                g1.drawString(introMessage, 0, 15);
                g1.drawString(iterationCount, 100, 30);
                g1.drawString(helixSpeedString, 100, 45);
                oldArray[0] = coordinateArray[0];
                oldArray[1] = coordinateArray[1];
                oldArray[2] = coordinateArray[2];
                oldArray[3] = coordinateArray[3];
                coordinateArray = newPos(clockWise, moveDirection, coordinateArray);
                if (clockWise == true) {
                    if (oldArray[0] < coordinateArray[0]) {
                        moveDirection = 0;
                        System.out.println("Test0");
                    }
                    if (oldArray[1] < coordinateArray[1]) {
                        moveDirection = 1;
                        System.out.println("Test1");
                    }
                    if (oldArray[0] > coordinateArray[0]) {
                        moveDirection = 2;
                        System.out.println("Test2");
                    }
                    if (oldArray[1] > coordinateArray[1]) {
                        moveDirection = 3;
                        System.out.println("Test3");
                    }
                }
                if (clockWise == false) {
                    if (oldArray[2] < coordinateArray[2]) {
                        moveDirection = 0;
                        System.out.println("Test0");
                    }
                    if (oldArray[3] < coordinateArray[3]) {
                        moveDirection = 1;
                        System.out.println("Test1");
                    }
                    if (oldArray[2] > coordinateArray[2]) {
                        moveDirection = 2;
                        System.out.println("Test2");
                    }
                    if (oldArray[3] > coordinateArray[3]) {
                        moveDirection = 3;
                        System.out.println("Test3");
                    }
                }
                g1.drawString(coordinateStart, 100, 60);
                g1.drawString(coordinateEnd, 100, 75);
                g1.setColor(getColor(helixColor));
                BasicStroke stroke = new BasicStroke(1);
                g1.setStroke(stroke);
                g1.drawLine(coordinateArray[0], coordinateArray[1], coordinateArray[2], coordinateArray[3]);
                iterationCount = "Iteration Count: ";
        }
        System.out.println("Thank you for using my program!");
    }

    //Checks what the color number input from the user was and assigns the color according to the table in rubric
    public static Color getColor (int colorNum) {
        Color lineColor = Color.RED;
        if (colorNum == 0) {
            lineColor = Color.GREEN;
        }
        if (colorNum == 1) {
            lineColor = Color.GRAY;
        }
        if (colorNum == 2) {
            lineColor = Color.YELLOW;
        }
        if (colorNum == 3) {
            lineColor = Color.RED;
        }
        if (colorNum == 4) {
            lineColor = Color.ORANGE;
        }
        if (colorNum == 5) {
            lineColor = Color.PINK;
        }
        if (colorNum == 6) {
            lineColor = Color.DARK_GRAY;
        }
        if (colorNum == 7) {
            lineColor = Color.BLUE;
        }
        if (colorNum == 8) {
            lineColor = Color.BLACK;
        }
        return lineColor;
    }
    //0 is right, 1 is down, 2 is left, and 3 is up
    public static int[] newPos(boolean clockWise, int moveDirection, int[] startEnd) {
        int startX = startEnd[0];
        int startY = startEnd[1];
        int endX = startEnd[2];
        int endY = startEnd[3];

        // Check if the start of the line reached a corner and updates the movement direction acoordingly
        if (clockWise == true) {
            if (moveDirection == 0 && startX == 300 && startY >= 100) {
                moveDirection = 1;
            }
            if (moveDirection == 1 && startY == 100 && startX <= 300) {
                moveDirection = 2;
            }
            if (moveDirection == 2 && startX == 100 && startY == 300) {
                moveDirection = 3;
            }
            if (moveDirection == 3 && startY == 100 && startX == 100) {
                moveDirection = 0;
            }
        }
        if (clockWise == false) {
            if (moveDirection == 0 && endX == 300 && endY >= 100) {
                moveDirection = 1;
            }
            if (moveDirection == 1 && endY == 300 && endX <= 300) {
                moveDirection = 2;
            }
            if (moveDirection == 2 && endX == 100 && endY == 300) {
                moveDirection = 3;
            }
            if (moveDirection == 3 && endY == 100 && endX == 100) {
                moveDirection = 0;
            }
        }

    
        // Movements go in clockwise direction
        if (clockWise == true) {
            if (moveDirection == 0) {
                endX -= 10;
                startX += 10;
                System.out.println("MD0");
            } 
            if (moveDirection == 1) {
                endY -= 10;
                startY += 10;
                System.out.println("MD1");
            } 
            if (moveDirection == 2) {
                endX += 10;
                startX -= 10;
                System.out.println("MD2");
            } 
            if (moveDirection == 3) {
                endY += 10;
                startY -= 10;
                System.out.println("MD3");
            }
        }
        // Movements go in counterclockwise direction
        else {
            if (moveDirection == 0) {
                startX -= 10;
                endX += 10;
                System.out.println("MD0");
            } 
            if (moveDirection == 1) {
                startY -= 10;
                endY += 10;
                System.out.println("MD1");
            } 
            if (moveDirection == 2) {
                startX += 10;
                endX -= 10;
                System.out.println("MD2");
            } 
            if (moveDirection == 3) {
                startY += 10;
                endY -= 10;
                System.out.println("MD3");
            }
        }
        //Updates the starting values for the x and y values so that the program knows where to begin it's line draw
        
    
        startEnd[0] = startX;
        startEnd[1] = startY;
        startEnd[2] = endX;
        startEnd[3] = endY;
    
        return startEnd;
    }
}
