package rooster;

import java.awt.*;
import drawingTool.Drawing;
import drawingTool.RandomNumber;

public class Head {
    private final int DIAMETER = 100;
    private Color colour;
    private Beak beak;      // composite
    private Eye eye;        // composite
    private Comb comb;      // composite

    public Head(Color colour) {
        this.colour = colour;
        beak = new Beak(Color.RED);
        eye = new Eye(Color.GRAY, Color.WHITE);
        comb = new Comb(Color.red);
    }

    public void drawAt(int left, int bottom) {
        int xOffset = 25;
        int yOffset = 25;
        int number = RandomNumber.between(1, 2);

    	Drawing.pen().setColor(this.colour);
    	Drawing.pen().fillOval(left + xOffset, bottom + yOffset, DIAMETER, DIAMETER);

        if (number == 1)
            beak.drawAt(left, bottom + yOffset + 50);
        else
            beak.drawAt(left, bottom + yOffset + 50, true);

        comb.drawAt(left + xOffset + 75, bottom);
        eye.drawAt(left + xOffset + 15, bottom + yOffset + 15);
    }
}