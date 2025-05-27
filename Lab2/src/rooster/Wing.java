package rooster;

import java.awt.Color;
import drawingTool.Drawing;

public class Wing {
    private final int WIDTH = 60;
    private final int HEIGHT = 45;
    private final int X_OFFSET = 60;
    private final int Y_OFFSET = 80;
    private final Color COLOUR = Color.YELLOW;

    private int size;

    public Wing(int size) {
        this.size = size;
    }

    public void drawAt(int left, int bottom) {
        int[] xCoords = {left + size * X_OFFSET, left + size * (X_OFFSET + WIDTH), left + size * (X_OFFSET + (int)(0.5 * WIDTH))};
        int[] yCoords = {bottom + size * Y_OFFSET, bottom + size * Y_OFFSET, bottom + size * (Y_OFFSET + HEIGHT)};

        Drawing.pen().setColor(COLOUR);
        Drawing.pen().fillPolygon(xCoords, yCoords, xCoords.length);
    }

    public int getSize() {
        return size;
    }
}