package rooster;

import drawingTool.Drawing;

import java.awt.*;

public class RocketWing extends Wing {
    private Color rocketColour;

    public RocketWing(Color colour, Color rocketColour) {
        super(colour);
        this.rocketColour = rocketColour;
    }

    @Override
    public void drawAt(int left, int bottom) {
        super.drawAt(left, bottom);

        int[] xCoords1 = {left + 10, left + 15, left + 100, left + 100, left + 15, left + 10};
        int[] yCoords1 = {bottom + 15, bottom + 10, bottom + 10, bottom + 20, bottom + 20, bottom + 15};
        int[] xCoords2 = {left + 10, left + 15, left + 75, left + 75, left + 15, left + 10};
        int[] yCoords2 = {bottom + 30, bottom + 25, bottom + 25, bottom + 35, bottom + 35, bottom + 30};

        Drawing.pen().setColor(rocketColour);
        Drawing.pen().fillPolygon(xCoords1, yCoords1, 6);
        Drawing.pen().fillPolygon(xCoords2, yCoords2, 6);
    }
}
