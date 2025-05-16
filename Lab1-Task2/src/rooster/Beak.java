package rooster;

import java.awt.*;
import drawingTool.Drawing;

public class Beak {
    private final Color colour;
    private final Hackle hackle;

    public Beak(Color colour) {
        this.colour = colour;
        this.hackle = new Hackle(this.colour);
    }

    public void drawAt(int left, int bottom) {
        int[] xCoords = {left, left - 50, left - 50, left};
        int[] yCoords = {bottom, bottom + 25, bottom + 25, bottom + 50};

        Drawing.pen().setColor(this.colour);
        Drawing.pen().fillPolygon(xCoords, yCoords, 4);
        Drawing.pen().setColor(Color.BLACK);
        Drawing.pen().drawPolygon(xCoords, yCoords, 4);

        this.hackle.drawAt(left - 10, bottom + 50);
    }
}
