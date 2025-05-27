package rooster;

import java.awt.*;
import drawingTool.Drawing;
import drawingTool.RandomNumber;

public class Head {
    private final int DIAMETER = 60;
    private final int X_OFFSET = 20;
    private final int Y_OFFSET = 20;
    private final Color COLOUR = Color.YELLOW;

    private int size;
    private Mouth mouth;      // composite
    private Comb comb;      // composite
    private Eye eye;        // composite

    public Head(int size) {
        this.size = size;
        mouth = new Mouth(this.size);
        comb = new Comb(this.size);
        eye = new Eye(this.size);
    }

    public void drawAt(int left, int bottom) {
        int number = RandomNumber.between(1, 2);

    	Drawing.pen().setColor(COLOUR);
    	Drawing.pen().fillOval(left + size * X_OFFSET, bottom + size * Y_OFFSET, size * DIAMETER, size * DIAMETER);

        if (number == 1)
            mouth.drawAt(left, bottom);
        else
            mouth.drawAt(left, bottom, true);

        comb.drawAt(left, bottom);
        eye.drawAt(left, bottom);
    }
}