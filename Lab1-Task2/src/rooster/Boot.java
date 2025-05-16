package rooster;

import java.awt.*;

import drawingTool.Drawing;

public class Boot {
    private Color colour;

    public Boot(Color colour) {
        this.colour = colour;
    }

    public void drawAt(int left, int bottom) {        // 700, 650
        int[] xCoords = {left, left, left - 50, left + 30, left + 30};
        int[] yCoords = {bottom, bottom + 25, bottom + 50, bottom + 50, bottom};

        Drawing.pen().setColor(this.colour);
        Drawing.pen().fillPolygon(xCoords, yCoords, 5);
    }
}