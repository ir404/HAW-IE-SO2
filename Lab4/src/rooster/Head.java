package rooster;

import drawingTool.Drawing;
import drawingTool.RandomNumber;

import java.awt.*;

public class Head {
    private final int DIAMETER = 60;
    private final int X_OFFSET = 20;
    private final int Y_OFFSET = 20;

    private int size, number;
    private Color colour;
    private Mouth mouth;      // composite
    private Comb comb;      // composite
    private Eye eye;        // composite

    public Head(int size, Color colour, Color eyeColour) {
        initialise(size, colour, eyeColour);
        number = RandomNumber.between(1, 2);
    }

    public Head(int size,  Color colour, Color eyeColour, boolean openMouth) {
        initialise(size, colour, eyeColour);
        number = openMouth ? 2 : 1;
    }

    private void initialise(int size, Color colour, Color eyeColour) {
        this.size = size;
        this.colour = colour;
        mouth = new Mouth(this.size);
        comb = new Comb(this.size);
        eye = new Eye(this.size, eyeColour);
    }

    public void drawAt(int left, int bottom) {
    	Drawing.pen().setColor(colour);
    	Drawing.pen().fillOval(left + size * X_OFFSET, bottom + size * Y_OFFSET, size * DIAMETER, size * DIAMETER);

        if (number == 1)
            mouth.drawAt(left, bottom);
        else
            mouth.drawAt(left, bottom, true);

        comb.drawAt(left, bottom);
        eye.drawAt(left, bottom);
    }
}