package rooster;

import java.awt.*;

import drawingTool.Drawing;

public class Tail {
    private final int X_OFFSET = 150;
    private final int WIDTH = 50;
    private final int HEIGHT = 160;
    private final Color COLOUR = Color.RED;

    private int size;

    public Tail(int size) {
        this.size = size;
    }

    public void drawAt(int left, int bottom) {
    	Drawing.pen().setColor(COLOUR);
    	Drawing.pen().fillArc(left + size * X_OFFSET, bottom, size * WIDTH, size * HEIGHT, 0, 180);
    	Drawing.pen().setColor(Color.decode("#eeeeee"));

        Drawing.pen().fillArc(left + size * (X_OFFSET + 2), bottom + size * 20, size * (WIDTH - 4), size * (int)(0.75 * HEIGHT), 0, 180);
    }
}