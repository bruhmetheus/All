import java.util.Scanner;

public class Cyclone {
  //Global variables here
  private static Scanner gConsole = new Scanner(System.in);
  private static double [] gWindSpeed;
  private static int gDatabaseSize = 0;
  public static void main (String []args) {
    // Intro program info
    System.out.println ("Fall 2023 - UTSA - 1083 - Section 005 - Project 2 - Cyclone - written by Kalin Rodriguez");
    // Declaring scanner, arrays, constant, boolean, and int variables
    final int gMAX_CYCLONES = 50;
    boolean sizeError;
    System.out.println("Please, enter the number of cyclones in the database (Max 50): ");
    int databaseSize = gConsole.nextInt();
    // checks if the size of the database is invalid and if so prompts user for new input
    if (databaseSize > gMAX_CYCLONES || databaseSize < 0) {
      sizeError = true;
      while (sizeError == true) {
        System.out.println("invalid value, please, try again.");
        databaseSize = gConsole.nextInt();
        if (databaseSize <= gMAX_CYCLONES & databaseSize > -1) {
          sizeError = false;
        }
      }
    }
    gWindSpeed = new double[databaseSize];
    gDatabaseSize = databaseSize;
    menuSelection();
  }
  
  
  
  // Prompts input for menu and then navigates menu repeating if input is invalid
  public static void menuSelection () {
    boolean menuError;
    //Prints out menu and prompts user to make a selection
    System.out.println("MAIN MENU");
    System.out.println("0 - Exit, 1 - Add/Update a cyclone, 2 - Summary, 3 - Clear Database, 4 - Show Cyclones, 5 - Swap Cyclones");
    System.out.println("Select and option : ");
    int menuNumber = gConsole.nextInt();
    //Checks if the option that the user selected was invalid and prompts the user to put in new input if so
    if (menuNumber < 0 || menuNumber > 5) {
      menuError = true;
      while (menuError == true) {
        System.out.println("Invalid value, please try again. ");
        System.out.println("MAIN MENU");
        System.out.println("0 - Exit, 1 - Add/Update a cyclone, 2 - Summary, 3 - Clear Database, 4 - Show Cyclones, 5 - Swap Cyclones");
        System.out.println("Select and option : ");
        menuNumber = gConsole.nextInt();
        if (menuNumber > -1 && menuNumber < 6) {
          menuError = false;
        }
      }
    }
    //Checks user input for what menu option they selected
    if (menuNumber == 0) {
      exitProgram();
    }
    if (menuNumber == 1) {
      addUpdCyclone();
    }
    if (menuNumber == 2) {
      summary();
    }
    if (menuNumber == 3) {
      clearDB();
    }
    if (menuNumber == 4) {
      showCyclones();
    }
    if (menuNumber == 5) {
      swapCyclones();
    }
  }
  
  
  
  //menu method to exit program
  public static void exitProgram () {
    System.out.println("Thank you for looking at the cyclone database program!");
  }
  
  
  
  // menu method to add and update cyclones
  public static void addUpdCyclone () {
    int indexVal;
    double windSpeed;
    //Prompts for input and checks for error in the input asking for input again if error is detected
    System.out.println("Enter the index (0 to " + (gDatabaseSize - 1) + ") : ");
    indexVal = gConsole.nextInt();
    while (indexVal < 0 || indexVal > gDatabaseSize) {
      System.out.println("invalid value, please, try again.");
      indexVal = gConsole.nextInt();
    }
    //Tells user the wind speed at the selected index and asks for new value
    System.out.println("The current wind speed of the cyclone at " + indexVal + " is : " + gWindSpeed[indexVal]);
    System.out.println("Enter the new wind speed (0 - 1000) : ");
    windSpeed = gConsole.nextDouble();
    //Checks if wind speed value is invalid and continues to ask for input until correccted
    while (windSpeed < 0 || windSpeed > 1000) {
      System.out.println("Invalid value, please, try again.");
      windSpeed = gConsole.nextDouble();
    }
    gWindSpeed [indexVal] = windSpeed;
    menuSelection();
  }
  
  
  
  //menu method to display summary
  public static void summary () {
    System.out.println("Cyclones' Classification Summary");
    int i;
    int returnVal = 0;
    for (i = 0; i <= 6; ++i) {
      returnVal = getCyclonesByClass(i);
      //Prints out the summary of all of the cyclones
      if (i == 0) {
        System.out.println("Tropical Depression : " + returnVal);
      }
      if (i == 1) {
        System.out.println("Tropical Storm : " + returnVal);
      }
      if (i == 2) {
        System.out.println("Hurricane Category 1 : " + returnVal);
      }
      if (i == 3) {
        System.out.println("Hurricane Category 2 : " + returnVal);
      }
      if (i == 4) {
        System.out.println("Hurricane Category 3 : " + returnVal);
      }
      if (i == 5) {
        System.out.println("Hurricane Category 4 : " + returnVal);
      }
      if (i == 6) {
        System.out.println("Hurricane Category 5 : " + returnVal);
      }
    }
    menuSelection();
  }
  
  
  
  public static int getCyclonesByClass (int classCode) {
    int i;
    //Declares the value stores for all of the different type of cyclones
    int tropDepress = 0;
    int tropStorm = 0;
    int hurCat1 = 0;
    int hurCat2 = 0;
    int hurCat3 = 0;
    int hurCat4 = 0;
    int hurCat5 = 0;
    int returnVal = 0;
    //Checks the value of all of the wind speeds in the array and adds 1 for each corresponding value
    for (i = 0; i < gDatabaseSize; ++i) {
      if (gWindSpeed [i] > 0 && gWindSpeed [i] <= 38) {
        ++tropDepress;
      }
      if (gWindSpeed [i] >= 39 && gWindSpeed[i] <= 73) {
        ++tropStorm;
      }
      if (gWindSpeed [i] >= 74 && gWindSpeed[i] <= 95) {
        ++hurCat1;
      }
      if (gWindSpeed [i] >= 96 && gWindSpeed[i] <= 110) {
        ++hurCat2;
      }
      if (gWindSpeed [i] >= 111 && gWindSpeed[i] <= 129) {
        ++hurCat3;
      }
      if (gWindSpeed [i] >= 130 && gWindSpeed[i] <= 156) {
        ++hurCat4;
      }
      if (gWindSpeed [i] >= 157 && gWindSpeed[i] <= 1000) {
        ++hurCat5;
      }
    }
    if (classCode == 0) {
      returnVal = tropDepress;
    }
    if (classCode == 1) {
      returnVal = tropStorm;
    }
    if (classCode == 2) {
      returnVal = hurCat1;
    }
    if (classCode == 3) {
      returnVal = hurCat2;
    }
    if (classCode == 4) {
      returnVal = hurCat3;
    }
    if (classCode == 5) {
      returnVal = hurCat4;
    }
    if (classCode == 6) {
      returnVal = hurCat5;
    }
    return returnVal;
  }
  
  
  //menu method to clear the database
  public static void clearDB () {
    int i;
    for (i = 0; i < gDatabaseSize; ++i) {
      gWindSpeed [i] = 0;
    }
    menuSelection();
  }
  
  
  
  
  //menu method to show all cyclones with windspeeds
  public static void showCyclones () {
    int i;
    System.out.println("LIST of Cyclones' Wind Speed");
    for (i = 0; i < gDatabaseSize; ++i) {
      System.out.println("Cylone[" + i + "] : " + gWindSpeed [i]);
    }
    menuSelection();
  }
  
  
  
  //menu method to swap around cyclone values
  public static void swapCyclones () {
    int idxFrom;
    int idxTo;
    //Asks for input for the second position and checks if value is invalid
    System.out.println("Enter the postion from 0 to " + (gDatabaseSize - 1));
    idxFrom = gConsole.nextInt();
    while (idxFrom < 0 || idxFrom > (gDatabaseSize - 1)) {
      System.out.println("Invalid value, please, try again.");
      System.out.println("Enter the postion from 0 to " + (gDatabaseSize - 1));
      idxFrom = gConsole.nextInt();
    }
    //Asks for input for the second position and checks if value is invalid
    System.out.println("Enter the postion from 0 to " + (gDatabaseSize - 1) + " that is not " + idxFrom + " :");
    idxTo = gConsole.nextInt();
    while (idxTo == idxFrom || idxTo < 0 || idxTo > (gDatabaseSize - 1)) {
      System.out.println("Invalid value, please, try again.");
      System.out.println("Enter the position from 0 to " + (gDatabaseSize - 1) + " that is not " + idxFrom + " :");
      idxTo = gConsole.nextInt();
    }
    swapValues(idxFrom, idxTo);
    menuSelection();
  }
  
  
  
  public static void swapValues (int f, int t) {
    double tempVal;
    tempVal = gWindSpeed [f];
    gWindSpeed [f] = gWindSpeed [t];
    gWindSpeed [t] = tempVal;
  }
}