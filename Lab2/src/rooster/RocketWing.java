package rooster;

import drawingTool.Drawing;

import java.awt.*;

public class RocketWing extends Wing {
    private final int WIDTH = 60;
    private final int HEIGHT = 10;
    private final int X_OFFSET = 70;
    private final int Y_OFFSET_TOP_ROCKET = 90;
    private final int Y_OFFSET_BOTTOM_ROCKET = 105;
    private final Color ROCKET_COLOUR = Color.RED;

    public RocketWing(int size) {
        super(size);
    }

    @Override
    public void drawAt(int left, int bottom) {
        super.drawAt(left, bottom);

        int[] xCoords1 = {left + super.getSize() * X_OFFSET, left + super.getSize() * (X_OFFSET + WIDTH), left + super.getSize() * (X_OFFSET + WIDTH), left + super.getSize() * X_OFFSET, left + super.getSize() * (X_OFFSET - 10)};
        int[] yCoords1 = {bottom + super.getSize() * Y_OFFSET_TOP_ROCKET, bottom + super.getSize() * Y_OFFSET_TOP_ROCKET, bottom + super.getSize() * (Y_OFFSET_TOP_ROCKET + HEIGHT), bottom + super.getSize() * (Y_OFFSET_TOP_ROCKET + HEIGHT), bottom + super.getSize() * (Y_OFFSET_TOP_ROCKET + (int)(0.5 * HEIGHT))};
        int[] xCoords2 = {left + super.getSize() * X_OFFSET, left + super.getSize() * (X_OFFSET + (int)(0.75 * WIDTH)), left + super.getSize() * (X_OFFSET + (int)(0.75 * WIDTH)), left + super.getSize() * X_OFFSET, left + super.getSize() * (X_OFFSET - 10)};
        int[] yCoords2 = {bottom + super.getSize() * Y_OFFSET_BOTTOM_ROCKET, bottom + super.getSize() * Y_OFFSET_BOTTOM_ROCKET, bottom + super.getSize() * (Y_OFFSET_BOTTOM_ROCKET + HEIGHT), bottom + super.getSize() * (Y_OFFSET_BOTTOM_ROCKET + HEIGHT), bottom + super.getSize() * (Y_OFFSET_BOTTOM_ROCKET + (int)(0.5 * HEIGHT))};

        Drawing.pen().setColor(ROCKET_COLOUR);
        Drawing.pen().fillPolygon(xCoords1, yCoords1, xCoords1.length);
        Drawing.pen().fillPolygon(xCoords2, yCoords2, xCoords2.length);
    }
}
