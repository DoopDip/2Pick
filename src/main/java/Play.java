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

    private boolean[][] checkClick;

    public Play(Graphics2D graphics2D, int row,int col) {
        this.graphics2D = graphics2D;
        this.row = row;
        this.col = col;
        margin = 1; // ขอบระยะห่างของแต่ละ block
        //พิกัดเริ่มต้นที่วาด block
        x = 75;
        y = 90;

        //ความกว้าง-ยาวรวม ของกระดาน
        hight = 350;
        width = 350;

        //ความกว้าง-ยาว ของแต่ละ block
        radiusHight = hight/row;
        radiusWidth = width/col;

        checkClick = new boolean[row][col];
    }

    public void update() {


    }

    public void draw() {
        int x = this.x;
        int y = this.y;

        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (checkClick[i][j])
                    graphics2D.setColor(Color.MAGENTA);
                else
                    graphics2D.setColor(Color.ORANGE);
                graphics2D.fillRect(x, y, radiusWidth, radiusHight);
                graphics2D.setColor(Color.ORANGE);
                graphics2D.drawString(i+" ",x+5,y+15);
                x += radiusWidth+margin;
            }
            y+= radiusHight+margin;
            x = this.x;
        }

    }


    public void pickClick(int xClick, int yClick) {
        int x = this.x;
        int y = this.y;
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if ((x <= xClick && x+radiusWidth >= xClick) && (y <= yClick && y+radiusHight >= yClick)) {
                    checkClick[i][j] = true;
                    System.out.println("["+(i+1)+"]["+(j+1)+"] = "+checkClick[i][j]);
                    i = row;
                    j = col;
                }
                x += radiusWidth+margin;
            }
            y+= radiusHight+margin;
            x = this.x;
        }
    }
}
