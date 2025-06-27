package rooster.decorators;

import drawingTool.Drawing;
import drawingTool.LocatedRectangle;

import java.awt.*;

public class BowTieDecorator extends RectangleDecorator {
    private final Color COLOUR = Color.GREEN;
    private final int X_OFFSET = 40;
    private final int Y_OFFSET = 70;
    private final int WIDTH = 20;
    private final int HEIGHT = 20;

    public BowTieDecorator(LocatedRectangle decorated) {
        super(decorated);
    }

    @Override
    public void draw() {
        super.draw();
        drawBowTie();
    }

    private void drawBowTie() {
        int left = super.address().x;
        int bottom = super.address().y;
        int size = super.getSize();
        int[] xCoords = {left + size * X_OFFSET, left + size * (X_OFFSET + (int)(WIDTH * 0.5)), left + size * (X_OFFSET + WIDTH), left + size * (X_OFFSET + WIDTH), left + size * (X_OFFSET + (int)(WIDTH * 0.5)), left + size * (X_OFFSET)};
        int[] yCoords = {bottom + size * Y_OFFSET, bottom + size * (Y_OFFSET + (int)(HEIGHT * 0.5)), bottom + size * Y_OFFSET, bottom + size * (Y_OFFSET + HEIGHT), bottom + size * (Y_OFFSET + (int)(HEIGHT * 0.5)), bottom + size * (Y_OFFSET + HEIGHT)};

        Drawing.pen().setColor(COLOUR);
        Drawing.pen().fillPolygon(xCoords, yCoords, 6);
        Drawing.pen().setColor(Color.BLACK);
        Drawing.pen().drawPolygon(xCoords, yCoords, 6);
    }
}
