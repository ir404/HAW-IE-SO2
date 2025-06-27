package rooster.decorators;

import drawingTool.Drawing;
import drawingTool.LocatedRectangle;

import java.awt.*;

public class HatDecorator extends RectangleDecorator {
    private final Color COLOUR = Color.decode("#988558");
    private final int WIDTH = 80;
    private final int HEIGHT = 25;
    private final int X_OFFSET = 10;

    public HatDecorator(LocatedRectangle decorated) {
        super(decorated);
    }

    @Override
    public void draw() {
        super.draw();
        drawHat();
    }

    private void drawHat() {
        int left = super.address().x;
        int bottom = super.address().y;
        int size = super.getSize();
        int[] xCoords = {left + size * X_OFFSET, left + size * (X_OFFSET + (int)(WIDTH * 0.5)), left + size * (X_OFFSET + WIDTH)};
        int[] yCoords = {bottom + size * HEIGHT, bottom, bottom + size * HEIGHT};

        Drawing.pen().setColor(COLOUR);
        Drawing.pen().fillPolygon(xCoords, yCoords, 3);
    }
}
