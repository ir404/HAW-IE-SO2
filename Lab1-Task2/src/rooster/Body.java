package rooster;

import java.awt.*;

import drawingTool.Drawing;
import drawingTool.RandomNumber;

public class Body {
    private Color colour;
    private Wing wing;                  // composite
    private Boot boot;                  // composite
    private Tail tail;                  // composite

    public Body(Color colour, Color wingColour, Color bootColour, Color tailColour) {
        int number = RandomNumber.between(1, 50);
        this.colour = colour;
        boot = new Boot(bootColour);
        tail = new Tail(tailColour);

        if (number % 3 == 0 && number % 5 == 0) {
            wing = new RocketWing(wingColour, Color.RED);
            boot = new CowboyBoot(bootColour);
        }
        else if (number % 3 == 0) {
            wing = new RocketWing(wingColour, Color.RED);
            boot = new Boot(bootColour);
        }
        else if (number % 5 == 0) {
            wing = new Wing(wingColour);
            boot = new CowboyBoot(bootColour);
        }
        else {
            wing = new Wing(wingColour);
            boot = new Boot(bootColour);
        }
    }

    public void drawAt(int left, int bottom) {
        int[] xCoords = {left, left - 25, left - 25, left + 50, left + 80, left + 200, left};
        int[] yCoords = {bottom, bottom + 25, bottom + 50, bottom + 150, bottom + 150, bottom, bottom};

        Drawing.pen().setColor(this.colour);
        Drawing.pen().fillPolygon(xCoords, yCoords, 7);

        wing.drawAt(left + 25, bottom);
        boot.drawAt(left + 50, bottom + 150);
        tail.drawAt(left + 200, bottom);
    }
}