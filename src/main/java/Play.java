import java.awt.*;

public class Play {

    private Graphics2D graphics2D;

    private int x;
    private int y;
    private int radiusHight;
    private int radiusWidth;
    private int margin;

    private int hight;
    private int width;

    private int row;
    private int col;

    public Play(Graphics2D graphics2D, int row,int col) {
        this.graphics2D = graphics2D;
        this.row = row;
        this.col = col;
        margin = 1;
        x = 75;
        y = 90;
        hight = 350;
        width = 350;

        radiusHight = hight/row;
        radiusWidth = width/col;
        System.out.println(radiusHight+" / "+radiusWidth);

    }

    public void update() {

    }

    public void draw() {
        int x = this.x;
        int y = this.y;

        for (int i=1; i <= row*col; i++) {
            graphics2D.setColor(Color.MAGENTA);
            graphics2D.fillRect(x, y, radiusWidth, radiusHight);
            graphics2D.setColor(Color.ORANGE);
            graphics2D.drawString(i+" ",x+5,y+15);
            x += radiusWidth+margin;
            if (i % col == 0) {
                y+= radiusHight+margin;
                x = this.x;
            }
        }
    }

}
