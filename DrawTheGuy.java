import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawTheGuy {
    private JFrame frame;
    private JPanel panel;
   // private BufferedImage thing = ImageIO.read("file path");

    //Here we are going to make a constructor to create the items
    public DrawTheGuy(){
        frame = new JFrame();
        panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawLine(10, 10, 100, 100);
                g.drawOval(100, 100, 50, 50);
                drawUnderScores(g);
                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                repaint();
                //continue code to draw the entire hangman
            }
        };
        frame.setBounds(100, 100, 500, 500);
        frame.setVisible(true);
        frame.add(panel);
    }

    public void drawUnderScores(Graphics g){
        int width = 25;
        int startX = 100;
        System.out.println(Main.howManyUnderScores);
        for (int i = 0; i < Main.howManyUnderScores; i++) {
            g.drawLine(startX, 300, startX + width, 300);
            startX+=30;
        }
    }
}
