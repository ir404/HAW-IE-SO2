package rooster;

import drawingTool.Drawing;

import java.awt.*;

public class Hackle {
    private final int WIDTH = 10;
    private final int HEIGHT = 40;
    private final int X_OFFSET = 15;
    private final int Y_OFFSET = 60;
    private final Color COLOUR = Color.RED;

    private int size;

    public Hackle(int size) {
        this.size = size;
    }

    public void drawAt(int left, int bottom) {
    	Drawing.pen().setColor(COLOUR);
    	Drawing.pen().fillOval(left + size * X_OFFSET, bottom + size * Y_OFFSET, size * WIDTH, size * HEIGHT);
    }
}