package rooster;

import java.awt.*;

public class Leg {
    private final Graphics pen;
    private final Color colour;

    public Leg(Graphics pen, Color colour) {
        this.pen = pen;
        this.colour = colour;
    }

    public void draw(int left, int bottom) {        // 700, 650
        int[] xCoords = {left, left, left - 75, left + 100, left + 75};
        int[] yCoords = {bottom, bottom + 50, bottom + 75, bottom + 75, bottom};

        this.pen.setColor(this.colour);
        this.pen.fillPolygon(xCoords, yCoords, 5);
        this.pen.setColor(Color.BLACK);
        this.pen.drawPolygon(xCoords, yCoords, 5);
    }
}
