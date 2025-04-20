package rooster;

import java.awt.*;

public class Comb {
    private final Graphics pen;
    private final Color colour;

    public Comb(Graphics pen, Color colour) {
        this.pen = pen;
        this.colour = colour;
    }

    public void drawAt(int left, int bottom) {        // 610, 100
        int[] xCoords = {left, left + 50, left + 50, left + 80, left + 50, left + 105, left + 70, left + 125, left};
        int[] yCoords = {bottom, bottom - 50, bottom - 35, bottom - 35, bottom - 25, bottom - 25, bottom - 15, bottom - 15, bottom};

        pen.setColor(this.colour);
        pen.fillPolygon(xCoords, yCoords, 9);
        pen.setColor(Color.BLACK);
        pen.drawPolygon(xCoords, yCoords, 9);
    }
}
