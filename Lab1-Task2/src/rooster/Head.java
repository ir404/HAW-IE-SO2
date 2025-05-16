package rooster;

import java.awt.*;
import drawingTool.Drawing;

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
    	Drawing.pen().setColor(this.colour);
    	Drawing.pen().fillOval(left, bottom, DIAMETER, DIAMETER);

        beak.drawAt(left + 2, bottom + 35);
        eye.drawAt(left + 15, bottom + 25);
        comb.drawAt(left + 50, bottom);
    }
}