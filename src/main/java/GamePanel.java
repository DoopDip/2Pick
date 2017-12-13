import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable, MouseListener {

    public static int WIDTH = 500;
    public static int HEIGHT = 500;

    public static int page = 1;
    public static boolean nextPage = true;
    public static int numRow = 2;
    public static int numCol = 2;

    private boolean playing;
    private int FPS = 30;

    private BufferedImage bufferedImage;
    private Graphics2D graphics2D;
    private Thread thread;

    private int countTime = 0;
    public static int timeSec = 0;

    /////////
    private int x;
    private int y;
    ////////

    Play play;
    Mode mode;
    Category category;
    GroupNum groupNum;

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

        bufferedImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_BGR);
        graphics2D = (Graphics2D) bufferedImage.getGraphics();

        playing = true;

        long startTime;
        long URDTimeMillis;
        long waitTime;
        long targetTime = 1000/FPS;

        while (playing) {
            startTime = System.nanoTime();

            if (page == 1) {
                if (nextPage) {
                    mode = new Mode(graphics2D);
                    nextPage = false;
                }
            } else if (page == 2){
                if (nextPage) {
                    category = new Category(graphics2D);
                    nextPage = false;
                }
            } else if (page == 3) {
                if (nextPage) {
                    groupNum = new GroupNum(graphics2D);
                    nextPage = false;
                }
            } else if (page == 4) {
                if (nextPage) {
                    play = new Play(graphics2D, numRow, numCol); //กำหนดขนาดของตาราง row & col
                    nextPage = false;
                }
            }

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
        graphics2D.setFont(new Font("Courier New", Font.PLAIN, 15));
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(0,0, WIDTH, HEIGHT);

        graphics2D.setColor(Color.GREEN);
        graphics2D.drawString("X: "+x+", Y: "+y,20,480);

        if (page == 1) {
            mode.draw();
        } else if (page == 2) {
            category.draw();
        } else if (page == 3) {
            groupNum.draw();
        } else if (page == 4) {
            graphics2D.setColor(Color.GREEN);
            graphics2D.drawString("Time : "+timeSec,20,20);
            play.draw();
        }
//        Image image = Toolkit.getDefaultToolkit().getImage("src/main/image/car.png");
//        graphics2D.drawImage(image,10,10,this);

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
        if (page == 1) {
            mode.click(e.getX(), e.getY());
        } else if (page == 2) {
            category.click(e.getX(), e.getY());
        } else if (page == 3) {
            groupNum.click(e.getX(), e.getY());
        } else if (page == 4) {
            play.pickClick(e.getX(), e.getY());
        }
    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
