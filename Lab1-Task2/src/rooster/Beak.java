package rooster;

import java.awt.*;
import drawingTool.Drawing;

public class Beak {
    private Color colour;
    private Hackle hackle;      // composite

    public Beak(Color colour) {
        this.colour = colour;
        this.hackle = new Hackle(this.colour);
    }

    public void drawAt(int left, int bottom) {
        int[] xCoords = {left, left + 25, left + 25, left};
        int[] yCoords = {bottom, bottom - 15, bottom + 15, bottom};

        Drawing.pen().setColor(this.colour);
        Drawing.pen().fillPolygon(xCoords, yCoords, 4);

        hackle.drawAt(left + 20, bottom + 15);
    }

    public void drawAt(int left, int bottom, boolean open) {
        if (!open) {
            drawAt(left, bottom);
            return;
        }

        int[] xCoordsUpper = {left, left + 25, left + 25, left};
        int[] yCoordsUpper = {bottom, bottom - 15, bottom, bottom};
        int[] xCoordsLower = {left, left + 25, left + 25, left};
        int[] yCoordLower = {bottom + 2, bottom + 20, bottom + 2, bottom + 2};

        Drawing.pen().setColor(this.colour);
        Drawing.pen().fillPolygon(xCoordsUpper, yCoordsUpper, 4);
        Drawing.pen().fillPolygon(xCoordsLower, yCoordLower, 4);

        hackle.drawAt(left + 20, bottom + 15);
    }
}
