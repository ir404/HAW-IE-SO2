package rooster;

import java.awt.*;

import drawingTool.Drawing;

public class Boot {
    private Color colour;

    public Boot(Color colour) {
        this.colour = colour;
    }

    public void drawAt(int left, int bottom) {
        int[] xCoords = {left, left, left - 50, left + 30, left + 30};
        int[] yCoords = {bottom, bottom + 25, bottom + 50, bottom + 50, bottom};

        Drawing.pen().setColor(this.colour);
        Drawing.pen().fillPolygon(xCoords, yCoords, 5);
    }

    /**
     * Draws a boot with spurs (like a cowboy boot)
     * */
    public void drawAt(int left, int bottom, Color spurColour) {
        drawAt(left, bottom);

        Drawing.pen().setColor(spurColour);
        Drawing.pen().fillRect(left + 30, bottom + 25, 15, 10);
        Drawing.pen().fillOval(left + 40, bottom + 15, 25, 25);
    }
}