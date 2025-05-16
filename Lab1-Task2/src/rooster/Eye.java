package rooster;

import java.awt.*;
import drawingTool.Drawing;

public class Eye {
    private final Color outer, inner;

    public Eye(Color outer, Color inner) {
        this.outer = outer;
        this.inner = inner;
    }

    public void drawAt(int left, int bottom) {      // 550, 135
    	Drawing.pen().setColor(this.outer);
    	Drawing.pen().fillOval(left, bottom, 50, 50);
    	Drawing.pen().setColor(this.inner);
    	Drawing.pen().fillOval(left + 10, bottom + 10, 25, 25);
    }
}