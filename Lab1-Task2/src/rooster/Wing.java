package rooster;

import java.awt.Color;
import drawingTool.Drawing;

public class Wing {
    private final Color colour;

    public Wing(Color colour) {
        this.colour = colour;
    }

    public void draw(int left, int bottom) {
        int[] xCoords = {left, left + 50, left + 100, left + 250};
        int[] yCoords = {bottom, bottom + 150, bottom + 150, bottom};

        Drawing.pen().setColor(this.colour);
        Drawing.pen().fillPolygon(xCoords, yCoords, 4);
        Drawing.pen().setColor(Color.BLACK);
        Drawing.pen().drawPolygon(xCoords, yCoords, 4);
    }
}