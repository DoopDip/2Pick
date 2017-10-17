import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    public static int WIDTH = 500;
    public static int HEIGHT = 500;

    Thread thread;

    public GamePanel() {
        super();
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setFocusable(true);
        requestFocus();
    }

    public void addNotify() {
        super.notify();
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    public void run() {

    }

    public void gameUpdate() {

    }

    public void gameRender() {

    }

    public void gameDraw() {

    }
}
