package rooster;

import java.awt.*;

import drawingTool.Drawing;

public class Boot {
    private final int SHAFT_WIDTH = 20;
    private final int SHAFT_HEIGHT = 20;
    private final int SOLE_WIDTH = 40;
    private final int HEEL_HEIGHT = 20;
    private final int X_OFFSET = 80;
    private final int Y_OFFSET = 160;
    private final Color COLOUR = Color.decode("#7a5230");

    private int size;

    public Boot(int size) {
        this.size = size;
    }

    public void drawAt(int left, int bottom) {
        int[] xCoords = {left + size * X_OFFSET, left + size * (X_OFFSET + SHAFT_WIDTH), left + size * (X_OFFSET + SHAFT_WIDTH), left + size * (X_OFFSET - (int)(0.5 * SOLE_WIDTH)), left + size * X_OFFSET};
        int[] yCoords = {bottom + size * Y_OFFSET, bottom + size * Y_OFFSET, bottom + size * (Y_OFFSET + SHAFT_HEIGHT + HEEL_HEIGHT), bottom + size * (Y_OFFSET + SHAFT_HEIGHT + HEEL_HEIGHT), bottom + size * (Y_OFFSET + SHAFT_HEIGHT)};

        Drawing.pen().setColor(COLOUR);
        Drawing.pen().fillPolygon(xCoords, yCoords, xCoords.length);
    }

    public int getSize() {
        return size;
    }
}