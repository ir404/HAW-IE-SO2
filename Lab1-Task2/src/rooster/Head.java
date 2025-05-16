package rooster;

import java.awt.*;
import drawingTool.Drawing;

public class Head {
    private final Color colour;
    private final Beak beak;
    private final Eye eye;
    private final Comb comb;

    public Head(Color colour) {
        this.colour = colour;
        this.beak = new Beak(Color.RED);
        this.eye = new Eye(Color.GRAY, Color.WHITE);
        this.comb = new Comb(Color.red);
    }

    public void drawAt(int left, int bottom) {
    	Drawing.pen().setColor(this.colour);
    	Drawing.pen().fillOval(left, bottom, 250, 250);
    	Drawing.pen().setColor(Color.BLACK);
    	Drawing.pen().drawOval(left, bottom, 250, 250);

        // draw the other parts of the head
        beak.drawAt(left, bottom + 100);
        eye.drawAt(left + 50, bottom + 35);
        comb.drawAt(left + 110, bottom);
    }
}