package rooster;

import java.awt.*;

import drawingTool.Drawing;

public class Body {
    private Color colour;
    private Wing wing;
    private Leg leg;
    private Tail tail;

    public Body(Color colour, Color wingColour, Color legColour, Color tailColour) {
        this.colour = colour;
        wing = new Wing(wingColour);
        leg = new Leg(legColour);
        tail = new Tail(tailColour);
    }

    public void drawAt(int left, int bottom) {
        int[] xCoords = {left, left - 25, left - 25, left + 50, left + 80, left + 200, left};
        int[] yCoords = {bottom, bottom + 25, bottom + 50, bottom + 150, bottom + 150, bottom, bottom};

        Drawing.pen().setColor(this.colour);
        Drawing.pen().fillPolygon(xCoords, yCoords, 7);

        wing.draw(left + 25, bottom);
        leg.draw(left + 50, bottom + 150);
        tail.drawAt(left + 200, bottom);
    }
}