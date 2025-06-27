package rooster;

import drawingTool.Drawing;

import java.awt.*;

public class Eye {
    private final Color OUTER_COLOUR = Color.WHITE;
    private final int OUTER_DIAMETER = 10;
    private final int INNER_DIAMETER = 6;
    private final int X_OFFSET = 30;
    private final int Y_OFFSET = 30;

    private int size;
    private Color colour;

    public Eye(int size, Color colour) {
        this.size = size;
        this.colour = colour;
    }

    public void drawAt(int left, int bottom) {
    	Drawing.pen().setColor(OUTER_COLOUR);
    	Drawing.pen().fillOval(left + size * X_OFFSET, bottom + size * Y_OFFSET, size * OUTER_DIAMETER, size * OUTER_DIAMETER);

        Drawing.pen().setColor(colour);
        Drawing.pen().fillOval(left + size * (X_OFFSET + 1), bottom + size * (Y_OFFSET + 2), size * INNER_DIAMETER, size * INNER_DIAMETER);
    }
}