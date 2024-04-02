import java.awt.*;
public class simpleDrawing {
    public static void main (String[] args) {
        String userName = "Kalin Rodriguez";
        DrawingPanel panel = new DrawingPanel(300, 200);
        panel.setBackground(Color.WHITE);
        Graphics2D g1 = panel.getGraphics();
        g1.setColor(Color.GREEN);
        g1.fillRect(50, 25, 200, 150);
        g1.setColor(Color.BLACK);
        g1.drawRect(50, 25, 200, 150);
        g1.setColor(Color.RED);
        g1.fillOval(75, 25, 150, 150);
        g1.setColor(Color.BLACK);
        g1.drawOval(75, 25, 150, 150);
        g1.setColor(Color.YELLOW);
        g1.drawLine(50, 25, 250, 175);
        g1.drawLine(250, 25, 50, 175);
        g1.setColor(Color.MAGENTA);
        g1.drawString(userName, 10, 15);
    }
}