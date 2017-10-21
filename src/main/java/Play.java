import java.awt.*;
import java.util.Random;

public class Play {

    private Graphics2D graphics2D;

    private int x;
    private int y;
    private int r;

    private int row;
    private int col;

    Random rand;

    public Play(Graphics2D graphics2D) {
        this.graphics2D = graphics2D;
        r = 50;
        rand = new Random();
    }

    public void update() {

    }

    public void draw() {
        x = 100;
        y = 100;
        for (int i=1; i<=30; i++) {
            graphics2D.setColor(new Color(rand.nextFloat(),rand.nextFloat(),rand.nextFloat()));
            graphics2D.fillRect(x, y, r, r);
            x += r+5;
            if (i % 6 == 0) {
                y+= r+5;
                x = 100;
            }
        }
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
