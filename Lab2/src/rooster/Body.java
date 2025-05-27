package rooster;

import java.awt.*;

import drawingTool.Drawing;
import drawingTool.RandomNumber;

public class Body {
    private final int WIDTH = 100;
    private final int HEIGHT = 80;
    private final int X_OFFSET = 50;
    private final int Y_OFFSET = 80;
    private final Color COLOUR = Color.ORANGE;

    private int size;
    private Wing wing;                  // composite
    private Boot boot;                  // composite
    private Tail tail;                  // composite

    public Body(int size, Color tailColour) {
        this.size = size;
        boot = new Boot(this.size);
        tail = new Tail(this.size);

        int number = RandomNumber.between(1, 50);
        if (number % 3 == 0 && number % 5 == 0) {
            wing = new RocketWing(this.size);
            boot = new CowboyBoot(this.size);
        }
        else if (number % 3 == 0) {
            wing = new RocketWing(this.size);
            boot = new Boot(this.size);
        }
        else if (number % 5 == 0) {
            wing = new Wing(this.size);
            boot = new CowboyBoot(this.size);
        }
        else {
            wing = new Wing(this.size);
            boot = new Boot(this.size);
        }
    }

    public void drawAt(int left, int bottom) {
        int[] xCoords = {left + size * X_OFFSET, left + size * (X_OFFSET + WIDTH), left + size * (X_OFFSET + (int)(0.5 * WIDTH)), left + size * (X_OFFSET + (int)(0.3 * WIDTH)), left + size * (X_OFFSET - (int)(0.2 * X_OFFSET)), left + size * (X_OFFSET - (int)(0.2 * X_OFFSET)), left + size * X_OFFSET};
        int[] yCoords = {bottom + size * Y_OFFSET, bottom + size * Y_OFFSET, bottom + size * (Y_OFFSET + HEIGHT), bottom + size * (Y_OFFSET + HEIGHT), bottom + size * (Y_OFFSET + (int)(0.5 * HEIGHT)), bottom + size * (Y_OFFSET + (int)(0.2 * HEIGHT)), bottom + size * Y_OFFSET};

        Drawing.pen().setColor(COLOUR);
        Drawing.pen().fillPolygon(xCoords, yCoords, xCoords.length);

        wing.drawAt(left, bottom);
        boot.drawAt(left, bottom);
        tail.drawAt(left, bottom);
    }
}