import java.awt.*;

public class GroupNum {

    private Graphics2D graphics2D;

    public GroupNum(Graphics2D graphics2D) {
        this.graphics2D = graphics2D;
    }

    public void draw() {
        graphics2D.setColor(Color.ORANGE);
        graphics2D.fillRect(50, 220, 100, 100);
        graphics2D.fillRect(200, 220, 100, 100);
        graphics2D.fillRect(350, 220, 100, 100);

        graphics2D.setColor(Color.WHITE);
        graphics2D.setFont(new Font("Courier New", Font.BOLD, 20));
        graphics2D.drawString("3x3", 70, 280);
        graphics2D.drawString("6x6", 220, 280);
        graphics2D.drawString("12x12", 370, 280);

        graphics2D.setFont(new Font("Courier New", Font.BOLD, 30));
        graphics2D.drawString("เลือกขนาดตาราง", 170, 90);
    }

    public void click(int x, int y) {
        if (x > 50 && x < 150 && y > 220 && y < 320) {
            System.out.println("Click 3x3");
            GamePanel.numRow = 3;
            GamePanel.numCol = 3;
            GamePanel.page = 4;
            GamePanel.nextPage = true;
        } else if (x > 200 && x < 300 && y > 220 && y < 320) {
            System.out.println("Click 4x4");
            GamePanel.numRow = 4;
            GamePanel.numCol = 4;
            GamePanel.page = 4;
            GamePanel.nextPage = true;
        } else if (x > 350 && x < 450 && y > 220 && y < 320) {
            System.out.println("Click 5x5");
            GamePanel.numRow = 5;
            GamePanel.numCol = 5;
            GamePanel.page = 4;
            GamePanel.nextPage = true;
        }
    }
}
