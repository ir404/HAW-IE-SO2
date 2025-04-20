package rooster;

import java.awt.*;

public class Tail {
    private final Graphics pen;
    private final Color colour;

    public Tail(Graphics pen, Color colour) {
        this.pen = pen;
        this.colour = colour;
    }

    public void drawAt(int left, int bottom) {            // 990, 100
        pen.setColor(this.colour);
        // big feather
        pen.fillArc(left, bottom, 300, 500, 0, 180);
        pen.setColor(Color.decode("#eeeeee"));
        pen.fillArc(left, bottom + 50, 300, 400, 0, 180);
        // small feather
        pen.setColor(this.colour);
        pen.fillArc(left + 10, bottom + 100, 200, 300, 0, 180);
        pen.setColor(Color.decode("#eeeeee"));
        pen.fillArc(left + 10, bottom + 150, 200, 200, 0, 180);
    }
}
