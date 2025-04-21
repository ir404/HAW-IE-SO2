package rooster;

import java.awt.*;

public class Head {
    private final Graphics pen;
    private final Color colour;
    private final Beak beak;
    private final Eye eye;
    private final Comb comb;

    public Head(Graphics pen, Color colour) {
        this.pen = pen;
        this.colour = colour;
        this.beak = new Beak(this.pen, Color.RED);
        this.eye = new Eye(this.pen, Color.GRAY, Color.WHITE);
        this.comb = new Comb(this.pen, Color.red);
    }

    public void drawAt(int left, int bottom) {
        pen.setColor(this.colour);
        pen.fillOval(left, bottom, 250, 250);
        pen.setColor(Color.BLACK);
        pen.drawOval(left, bottom, 250, 250);

        // drawAt the other parts of the head
        beak.drawAt(left, bottom + 100);
        eye.drawAt(left + 50, bottom + 35);
        comb.drawAt(left + 110, bottom);
    }
}
