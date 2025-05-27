package rooster;

import java.awt.*;
import drawingTool.Drawing;

public class Eye {
    private final int OUTER_DIAMETER = 10;
    private final int X_OFFSET = 30;
    private final int Y_OFFSET = 30;
    private final Color OUTER_COLOUR = Color.GRAY;

    private int size;

    public Eye(int size) {
        this.size = size;
    }

    public void drawAt(int left, int bottom) {
    	Drawing.pen().setColor(OUTER_COLOUR);
    	Drawing.pen().fillOval(left + size * X_OFFSET, bottom + size * Y_OFFSET, size * OUTER_DIAMETER, size * OUTER_DIAMETER);
    }
}