package rooster;

import java.awt.*;

public class Hackle {
    private final Graphics pen;
    private final Color colour;

    public Hackle(Graphics pen, Color colour) {
        this.pen = pen;
        this.colour = colour;
    }

    public void drawAt(int left, int bottom) {     // 485, 250
        pen.setColor(this.colour);
        pen.fillOval(left, bottom, 25, 200);
        pen.setColor(Color.BLACK);
        pen.drawOval(left, bottom, 25, 200);
    }
}
