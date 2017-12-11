import java.awt.*;

public class Mode {

    Graphics2D graphics2D;

    public Mode(Graphics2D graphics2D) {
        this.graphics2D = graphics2D;
    }

    public void draw() {
        graphics2D.setColor(Color.ORANGE);
        graphics2D.fillRect(75, 220, 150, 60);
        graphics2D.fillRect(300, 220, 150, 60);

        graphics2D.setColor(Color.WHITE);
        graphics2D.setFont(new Font("Courier New", Font.BOLD, 23));
        graphics2D.drawString("ง่าย", 125, 250);
        graphics2D.drawString("ยาก", 345, 250);

        graphics2D.setFont(new Font("Courier New", Font.BOLD, 30));
        graphics2D.drawString("เลือกโหมด", 170, 90);
    }

    public void click(int x, int y) {
        if (x > 75 && x < 225 && y > 220 && y < 280) {
            System.out.println("Click Easy");
            GamePanel.page = 2;
            GamePanel.nextPage = true;
        } else if (x > 300 && x < 450 && y > 220 && y < 280) {
            System.out.println("Click Hard");
        }
    }
}
