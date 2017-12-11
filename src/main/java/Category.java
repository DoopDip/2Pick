import java.awt.*;

public class Category {

    private Graphics2D graphics2D;

    public Category(Graphics2D graphics2D) {
        this.graphics2D = graphics2D;
    }

    public void draw() {
        graphics2D.setColor(Color.ORANGE);
        graphics2D.fillRect(50, 220, 100, 100);
        graphics2D.fillRect(200, 220, 100, 100);
        graphics2D.fillRect(350, 220, 100, 100);

        graphics2D.setColor(Color.WHITE);
        graphics2D.setFont(new Font("Courier New", Font.BOLD, 23));
        graphics2D.drawString("ผลไม้", 70, 280);
        graphics2D.drawString("สัตว์", 220, 280);
        graphics2D.drawString("รถ", 370, 280);

        graphics2D.setFont(new Font("Courier New", Font.BOLD, 30));
        graphics2D.drawString("เลือกหมวดหมู่", 170, 90);
    }

    public void click(int x, int y) {
        if (x > 50 && x < 150 && y > 220 && y < 320) {
            System.out.println("Click Fruit");
            GamePanel.page = 3;
            GamePanel.nextPage = true;
        } else if (x > 200 && x < 300 && y > 220 && y < 320) {
            System.out.println("Click Animal");
            GamePanel.page = 3;
            GamePanel.nextPage = true;
        } else if (x > 350 && x < 450 && y > 220 && y < 320) {
            System.out.println("Click Car");
            GamePanel.page = 3;
            GamePanel.nextPage = true;
        }
    }

}
