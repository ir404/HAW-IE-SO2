package rooster;

import java.awt.Color;
import java.awt.Graphics;

public class Wing {
    private final Graphics pen;
    private final Color colour;

    public Wing(Graphics pen, Color colour) {
        this.pen = pen;
        this.colour = colour;
    }

    public void drawAt(int left, int bottom) {        // 650, 350
        int[] xCoords = {left, left + 50, left + 100, left + 250};
        int[] yCoords = {bottom, bottom + 150, bottom + 150, bottom};

        pen.setColor(this.colour);
        pen.fillPolygon(xCoords, yCoords, 4);
        pen.setColor(Color.BLACK);
        pen.drawPolygon(xCoords, yCoords, 4);
    }
}
