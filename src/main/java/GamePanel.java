import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable, MouseListener {

    public static int WIDTH = 500;
    public static int HEIGHT = 500;

    private boolean playing;
    private int FPS = 30;

    private BufferedImage bufferedImage;
    private Graphics2D graphics2D;
    private Thread thread;

    private int countTime = 0 ,timeSec = 0;

    /////////
    private int x;
    private int y;
    ////////

    Play play;

    public GamePanel() {
        super();
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setFocusable(true);
        requestFocus();
        addMouseListener(this);
    }

    public void addNotify() {
        super.addNotify();
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    public void run() {

        playing = true;

        bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_BGR);
        graphics2D = (Graphics2D) bufferedImage.getGraphics();

        play = new Play(graphics2D, 10, 10); //กำหนดขนาดของตาราง row & col

        long startTime;
        long URDTimeMillis;
        long waitTime;
        long targetTime = 1000/FPS;

        while (playing) {
            startTime = System.nanoTime();

            gameUpdate();
            gameRender();
            gameDraw();

            URDTimeMillis = (System.nanoTime() - startTime)/ 1000000;
            waitTime = targetTime - URDTimeMillis;

            try {
                Thread.sleep(waitTime);
            } catch (Exception e) {}

            countTime++;
            if (countTime > 30) {
                countTime=0;
                timeSec++;
            }
        }

    }

    public void gameUpdate() {

    }

    public void gameRender() {
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(0,0, WIDTH, HEIGHT);

        graphics2D.setColor(Color.GREEN);
        graphics2D.drawString("Time : "+timeSec,20,20);
        graphics2D.drawString("X: "+x+", Y: "+y,20,480);

        play.draw();
    }

    public void gameDraw() {
        Graphics graphics = this.getGraphics();
        graphics.drawImage(bufferedImage,0, 0,null);
        graphics.dispose();
    }


    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        play.pickClick(e.getX(), e.getY());
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
