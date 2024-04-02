import java.awt.*;
import java.util.Scanner;
public class drawingTesting {
    public static void main (String[] args) {
        Scanner scnr = new Scanner(System.in);
        int disNum = scnr.nextInt();
        DrawingPanel panel = new DrawingPanel(300, 200);
        panel.setBackground(Color.WHITE);
        Graphics2D g1 = panel.getGraphics();
        g1.setColor(Color.BLACK);
        g1.drawLine(50, 50, disNum, 50);
        scnr.close();
    }
}