package rooster;

import java.awt.*;

import drawingTool.Drawing;

public class Leg {
    private Color colour;

    public Leg(Color colour) {
        this.colour = colour;
    }

    public void draw(int left, int bottom) {        // 700, 650
        int[] xCoords = {left, left, left - 50, left + 50, left + 30};
        int[] yCoords = {bottom, bottom + 15, bottom + 25, bottom + 25, bottom};

        Drawing.pen().setColor(this.colour);
        Drawing.pen().fillPolygon(xCoords, yCoords, 5);
    }
}