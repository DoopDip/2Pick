import javax.swing.*;

public class Game extends JFrame {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("2Pick");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setContentPane(new GamePanel());
        jFrame.pack();
        jFrame.setVisible(true);
    }
}

// Noob FREN