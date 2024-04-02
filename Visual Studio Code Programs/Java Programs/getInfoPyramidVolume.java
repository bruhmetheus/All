import java.util.*;
//Find volume of Cube
public class getInfo{
  public static void main(String[] arg){
      Scanner scnr = new Scanner(System.in);
      int length = scnr.nextInt();
      int volume = length * length * length;
      System.println(volume);
  }
}