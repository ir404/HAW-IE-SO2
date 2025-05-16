package rooster;

import java.awt.*;

import drawingTool.Drawing;

public class Leg {
    private final Color colour;

    public Leg(Color colour) {
        this.colour = colour;
    }

    public void draw(int left, int bottom) {        // 700, 650
        int[] xCoords = {left, left, left - 75, left + 100, left + 75};
        int[] yCoords = {bottom, bottom + 50, bottom + 75, bottom + 75, bottom};

        Drawing.pen().setColor(this.colour);
        Drawing.pen().fillPolygon(xCoords, yCoords, 5);
        Drawing.pen().setColor(Color.BLACK);
        Drawing.pen().drawPolygon(xCoords, yCoords, 5);
    }
}