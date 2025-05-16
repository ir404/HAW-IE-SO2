package rooster;

import java.awt.Color;
import drawingTool.Drawing;

public class Wing {
    private Color colour;

    public Wing(Color colour) {
        this.colour = colour;
    }

    public void drawAt(int left, int bottom) {
        int[] xCoords = {left, left + 25, left + 50, left + 100};
        int[] yCoords = {bottom, bottom + 50, bottom + 50, bottom};

        Drawing.pen().setColor(this.colour);
        Drawing.pen().fillPolygon(xCoords, yCoords, 4);
    }

    public Color getColour() {
        return colour;
    }
}