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

    /**
     * Draws a wing with rockets
     */
    public void drawAt(int left, int bottom, Color rocketColour) {
        drawAt(left, bottom);

        int[] xCoords1 = {left + 10, left + 15, left + 100, left + 100, left + 15, left + 10};
        int[] yCoords1 = {bottom + 15, bottom + 10, bottom + 10, bottom + 20, bottom + 20, bottom + 15};
        int[] xCoords2 = {left + 10, left + 15, left + 75, left + 75, left + 15, left + 10};
        int[] yCoords2 = {bottom + 30, bottom + 25, bottom + 25, bottom + 35, bottom + 35, bottom + 30};

        Drawing.pen().setColor(rocketColour);
        Drawing.pen().fillPolygon(xCoords1, yCoords1, 6);
        Drawing.pen().fillPolygon(xCoords2, yCoords2, 6);
    }
}