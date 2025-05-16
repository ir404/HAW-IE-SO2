package rooster;

import java.awt.*;

import drawingTool.Drawing;

public class Body {
    private final Color colour;
    private final Wing wing;
    private final Leg leg;

    public Body(Color colour, Color wingColour, Color legColour) {
        this.colour = colour;
        this.wing = new Wing(wingColour);
        this.leg = new Leg(legColour);
    }

    public void drawAt(int left, int bottom) {        // 600, 350
        int[] xCoords = {left, left - 50, left - 50, left + 100, left + 175, left + 400, left};
        int[] yCoords = {bottom, bottom + 50, bottom + 100, bottom + 300, bottom + 300, bottom, bottom};

        Drawing.pen().setColor(this.colour);
        Drawing.pen().fillPolygon(xCoords, yCoords, 7);
        Drawing.pen().setColor(Color.BLACK);
        Drawing.pen().drawPolygon(xCoords, yCoords, 7);

        // now drawAt the wing and leg
        this.wing.draw(left + 50, bottom);
        this.leg.draw(left + 100, bottom + 300);
    }
}