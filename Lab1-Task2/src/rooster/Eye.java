package rooster;

import java.awt.*;

public class Eye {
    private final Graphics pen;
    private final Color outer, inner;

    public Eye(Graphics pen, Color outer, Color inner) {
        this.pen = pen;
        this.outer = outer;
        this.inner = inner;
    }

    public void drawAt(int left, int bottom) {      // 550, 135
        pen.setColor(this.outer);
        pen.fillOval(left, bottom, 50, 50);
        pen.setColor(this.inner);
        pen.fillOval(left + 10, bottom + 10, 25, 25);
    }
}
