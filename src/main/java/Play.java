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
    private int[][] numBlock;

    private boolean[] checkClickBlock1;
    private boolean[] checkClickBlock2;

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

        checkClick = new boolean[row][col]; // เก็บสถานะของ block ; true = แสดง
        numBlock = new int[row][col]; // เก็บหมายเลขของแต่ละ block

        checkClickBlock1 = new boolean[(row*col)/2];
        checkClickBlock2 = new boolean[(row*col)/2];

        ranNumBlock();
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
                graphics2D.setFont(new Font("Courier New", Font.BOLD, radiusHight/3));
                graphics2D.drawString(numBlock[i][j]+" ",x+(radiusWidth/2),y+(radiusHight/2));
                x += radiusWidth+margin;
            }
            y += radiusHight+margin;
            x = this.x;
        }

    }

    // ให้ block แสดงในตำแหน่งที่คลิกโดน block นั้นๆ
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
            y += radiusHight+margin;
            x = this.x;
        }
    }

    // สุ่มเลขเข้่าไปใน Block โดยหนึ่งเลขจะมี 2 block ที่เหมือนกัน หากมี block เศษเหลือจะให้เป็นเลข 0
    private void ranNumBlock() {
        int randRow;
        int randCol;
        int randNum;
        boolean check;
        int loop;
        if ((row*col) % 2 == 0)
            loop = row*col;
        else
            loop = (row*col)-1;
        for (int i=0; i<loop; i++) {
            check = true;
            // random row and col
            do {
                randRow = (int)(Math.random()*row);
                randCol = (int)(Math.random()*col);
                System.out.println("Random["+randRow+"]["+randCol+"] / ranNum : "+numBlock[randRow][randCol]);
                if (numBlock[randRow][randCol] == 0) check = false;
            } while(check);
            // random number block
            do {
                randNum = 1+(int)(Math.random()*((row*col)/2));
                System.out.println("randNum : "+randNum);
                int count = 0;
                for (int j=0; j<row; j++) {
                    for (int k=0; k<col; k++) {
                        if (numBlock[j][k] == randNum) count++;
                    }
                }
                if (count >= 2)
                    check = true;
                else
                    check = false;
            } while (check);
            numBlock[randRow][randCol] = randNum;
        }
    }
}
