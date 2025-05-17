package rooster;

import java.awt.*;
import drawingTool.Drawing;

public class Beak {
    private final int GAP = 2;
    private Color colour;
    private Hackle hackle;      // composite

    public Beak(Color colour) {
        this.colour = colour;
        this.hackle = new Hackle(this.colour);
    }

    public void drawAt(int left, int bottom) {
        Drawing.pen().setColor(this.colour);
        drawUpper(left, bottom);
        drawLower(left, bottom);

        hackle.drawAt(left + 20, bottom + 15);
    }

    public void drawAt(int left, int bottom, boolean open) {
        if (!open) {
            drawAt(left, bottom);
            return;
        }

        Drawing.pen().setColor(this.colour);
        drawUpper(left, bottom);
        drawLower(left, bottom + GAP);

        hackle.drawAt(left + 20, bottom + GAP + 15);
    }

    private void drawUpper(int left, int bottom) {
        int[] xCoords = {left, left + 25, left + 25, left};
        int[] yCoords = {bottom, bottom - 15, bottom, bottom};

        Drawing.pen().fillPolygon(xCoords, yCoords, 4);
    }

    private void drawLower(int left, int bottom) {
        int[] xCoords = {left, left + 25, left + 25, left};
        int[] yCoords = {bottom, bottom + 15, bottom, bottom};

        Drawing.pen().fillPolygon(xCoords, yCoords, 4);
    }
}
