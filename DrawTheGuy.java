import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class DrawTheGuy implements KeyListener {
    private JFrame frame;
    private JPanel panel;
    private String letters = "";
    private String revealed = ""; //This will start with only underscores and ass we guess correctly we replace them.
   // private BufferedImage thing = ImageIO.read("file path");

    //Here we are going to make a constructor to create the items
    public DrawTheGuy(){
        frame = new JFrame();
        createUnderscores();
        panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawLine(10, 10, 100, 100);
                g.drawOval(100, 100, 50, 50);
                //drawUnderScores(g);
                g.setFont(new Font("Arial", Font.PLAIN, 32));
                g.drawString(revealed, 100, 290);
                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                repaint();
                //continue code to draw the entire hangman
            }
        };
        frame.addKeyListener(this);
        frame.setBounds(100, 100, 500, 500);
        frame.setVisible(true);
        frame.add(panel);
    }

    /**
     * This function will turn the revealed string into a sequence of underscores.
     */
    public void createUnderscores(){
        for (int i = 0; i < Main.howManyUnderScores; i++) {
            revealed+="-";
        }
        System.out.println("This is our revealed underscores "+revealed);
    }

    public void drawUnderScores(Graphics g){
        int width = 25;
        int startX = 100;
        for (int i = 0; i < Main.howManyUnderScores; i++) {
            g.drawLine(startX, 300, startX + width, 300);
            startX+=30;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        letters+=e.getKeyChar();
        System.out.println(letters);
        System.out.println(Main.answer);
        for (int i = 0; i < Main.answer.length(); i++) {
            if(Main.answer.toLowerCase().charAt(i) == e.getKeyChar()){
                System.out.println("the letter we just typed is found in answer");
                System.out.println("The letter has been found at index: "+i);
                revealed = replace(revealed, i, e.getKeyChar());
                System.out.println(revealed);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    public String replace(String s, int index, char c){
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(i != index) newString.append(s.charAt(i));
            else newString.append(c);
        }
        return newString.toString();
    }
}
