import java.util.Scanner;
public class sensorTest{
  //Status for whether or not motion has been detected
  private static boolean motionDetected;
  //Main method
  public static void main(String []args) {
    searchMotion();
  }
  
  
  //Checks for input from sensor to determine motion
  public static void searchMotion () {
    Scanner scnr = new Scanner(System.in);
    //Takes input from sensor
    int sensorMovement = scnr.nextInt();
    //Checks sensor input applying true to motion detect if value is equal to 1
    if (sensorMovement == 1) {
      motionDetected = true;
    }
    else if (sensorMovement == 0) {
      motionDetected = false;
    }
    //Checks the state of motion detected and executes corresponding method
    if (motionDetected == false) {
      noMotion();
    }
    else if (motionDetected == true) {
      yesMotion();
    }
    scnr.close();
  }
  
  
  //Method that is executed if no motion has been detected
  public static void noMotion () {
    System.out.println("noMotion TEST");
    int lightStatus;
    while (motionDetected == false) {
      lightStatus = 1;
      if (lightStatus == 1) {
        //turn on light
      }
      lightStatus = 0;
      if (lightStatus == 0) {
        //turn light off
      }
      searchMotion();
    }
  }
  
  
  //Method that is executed if motion has been detected
  public static void yesMotion () {
    System.out.println("yesMotion TEST");
    searchMotion();
  }
}