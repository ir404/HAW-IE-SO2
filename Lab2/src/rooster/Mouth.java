package rooster;

import java.awt.*;
import drawingTool.Drawing;

public class Mouth {
    private final int BEAK_WIDTH = 20;
    private final int BEAK_HEIGHT = 10;
    private final int Y_OFFSET = 50;
    private final int GAP = 2;
    private final Color COLOUR = Color.RED;

    private int size;
    private Hackle hackle;      // composite

    public Mouth(int size) {
        this.size = size;
        this.hackle = new Hackle(this.size);
    }

    public void drawAt(int left, int bottom) {
        Drawing.pen().setColor(COLOUR);
        drawUpperBeak(left, bottom);
        drawLowerBeak(left, bottom);

        hackle.drawAt(left, bottom);
    }

    public void drawAt(int left, int bottom, boolean open) {
        if (!open) {
            drawAt(left, bottom);
            return;
        }

        Drawing.pen().setColor(COLOUR);
        drawUpperBeak(left, bottom);
        drawLowerBeak(left, bottom + size * GAP);

        hackle.drawAt(left, bottom);
    }

    private void drawUpperBeak(int left, int bottom) {
        int[] xCoords = {left, left + size * BEAK_WIDTH, left + size * BEAK_WIDTH, left};
        int[] yCoords = {bottom + size * Y_OFFSET, bottom + size * (Y_OFFSET - BEAK_HEIGHT), bottom + size * Y_OFFSET, bottom + size * Y_OFFSET};

        Drawing.pen().fillPolygon(xCoords, yCoords, xCoords.length);
    }

    private void drawLowerBeak(int left, int bottom) {
        int[] xCoords = {left, left + size * BEAK_WIDTH, left + size * BEAK_WIDTH, left};
        int[] yCoords = {bottom + size * Y_OFFSET, bottom + size * (Y_OFFSET + BEAK_HEIGHT), bottom + size * Y_OFFSET, bottom + size * Y_OFFSET};

        Drawing.pen().fillPolygon(xCoords, yCoords, xCoords.length);
    }
}
