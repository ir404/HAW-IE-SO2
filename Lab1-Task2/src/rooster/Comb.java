package rooster;

import java.awt.*;
import drawingTool.Drawing;

public class Comb {
    private final Color colour;

    public Comb(Color colour) {
        this.colour = colour;
    }

    public void drawAt(int left, int bottom) {        // 610, 100
        int[] xCoords = {left, left + 50, left + 50, left + 80, left + 50, left + 105, left + 70, left + 125, left};
        int[] yCoords = {bottom, bottom - 50, bottom - 35, bottom - 35, bottom - 25, bottom - 25, bottom - 15, bottom - 15, bottom};

        Drawing.pen().setColor(this.colour);
        Drawing.pen().fillPolygon(xCoords, yCoords, 9);
        Drawing.pen().setColor(Color.BLACK);
        Drawing.pen().drawPolygon(xCoords, yCoords, 9);
    }
}