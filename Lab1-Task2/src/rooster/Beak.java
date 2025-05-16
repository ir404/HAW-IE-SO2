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
}
