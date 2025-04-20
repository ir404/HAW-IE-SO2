package rooster;

import java.awt.*;

public class Beak {
    private final Graphics pen;
    private final Color colour;
    private final Hackle hackle;

    public Beak(Graphics pen, Color colour) {
        this.pen = pen;
        this.colour = colour;
        this.hackle = new Hackle(this.pen, this.colour);
    }

    public void drawAt(int left, int bottom) {      // 500, 200
        int[] xCoords = {left, left - 50, left - 50, left};
        int[] yCoords = {bottom, bottom + 25, bottom + 25, bottom + 50};

        pen.setColor(this.colour);
        pen.fillPolygon(xCoords, yCoords, 4);
        pen.setColor(Color.BLACK);
        pen.drawPolygon(xCoords, yCoords, 4);

        this.hackle.drawAt(left - 15, bottom + 50);
    }
}
