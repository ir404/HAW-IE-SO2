package rooster;

import java.awt.*;
import drawingTool.Drawing;

public class Comb {
    private final int WIDTH = 20;
    private final int HEIGHT = 20;
    private final int X_OFFSET = 75;
    private final Color COLOUR = Color.RED;

    private int size;

    public Comb(int size) {
        this.size = size;
    }

    public void drawAt(int left, int bottom) {
        int[] xCoords = {left + size * X_OFFSET, left + size * (X_OFFSET - WIDTH), left + size * X_OFFSET, left + size * X_OFFSET};
        int[] yCoords = {bottom, bottom + size * HEIGHT, bottom + size * HEIGHT, bottom};

        Drawing.pen().setColor(COLOUR);
        Drawing.pen().fillPolygon(xCoords, yCoords, xCoords.length);
    }
}