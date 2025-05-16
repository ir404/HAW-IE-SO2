package rooster;

import java.awt.*;
import drawingTool.Drawing;

public class Comb {
    private Color colour;

    public Comb(Color colour) {
        this.colour = colour;
    }

    public void drawAt(int left, int bottom) {
        int[] xCoords = {left, left - 25, left, left};
        int[] yCoords = {bottom, bottom + 25, bottom + 25, bottom};

        Drawing.pen().setColor(this.colour);
        Drawing.pen().fillPolygon(xCoords, yCoords, xCoords.length);
    }
}