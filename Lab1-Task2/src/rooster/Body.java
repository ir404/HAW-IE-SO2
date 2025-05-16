package rooster;

import java.awt.*;

import drawingTool.Drawing;
import drawingTool.RandomNumber;

public class Body {
    private Color colour;
    private Wing wing;              // composite
    private RocketWing rocketWing;
    private Leg leg;                // composite
    private Tail tail;              // composite

    public Body(Color colour, Color wingColour, Color legColour, Color tailColour) {
        int number = RandomNumber.between(0, 10);
        this.colour = colour;
        leg = new Leg(legColour);
        tail = new Tail(tailColour);

        if (number % 2 == 0 || number % 3 == 0)
            rocketWing = new RocketWing(wingColour, Color.RED);
        else
            wing = new Wing(wingColour);
    }

    public void drawAt(int left, int bottom) {
        int[] xCoords = {left, left - 25, left - 25, left + 50, left + 80, left + 200, left};
        int[] yCoords = {bottom, bottom + 25, bottom + 50, bottom + 150, bottom + 150, bottom, bottom};

        Drawing.pen().setColor(this.colour);
        Drawing.pen().fillPolygon(xCoords, yCoords, 7);

        if (wing != null)
            wing.drawAt(left + 25, bottom);
        else
            rocketWing.drawAt(left + 25, bottom);

        leg.draw(left + 50, bottom + 150);
        tail.drawAt(left + 200, bottom);
    }
}