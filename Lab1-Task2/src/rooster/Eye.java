package rooster;

import java.awt.*;
import drawingTool.Drawing;

public class Eye {
    private Color outer, inner;
    private final int OUTER_DIAMETER = 20;
    private final int INNER_DIAMETER = 10;

    public Eye(Color outer, Color inner) {
        this.outer = outer;
        this.inner = inner;
    }

    public void drawAt(int left, int bottom) {
    	Drawing.pen().setColor(this.outer);
    	Drawing.pen().fillOval(left, bottom, OUTER_DIAMETER, OUTER_DIAMETER);
    	Drawing.pen().setColor(this.inner);
    	Drawing.pen().fillOval(left + 5, bottom + 5, INNER_DIAMETER, INNER_DIAMETER);
    }
}