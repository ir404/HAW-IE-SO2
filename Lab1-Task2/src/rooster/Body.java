package rooster;

import java.awt.*;

public class Body {
    private final Graphics pen;
    private final Color colour;
    private final Wing wing;
    private final Leg leg;

    public Body(Graphics pen, Color colour, Color wingColour, Color legColour) {
        this.pen = pen;
        this.colour = colour;
        this.wing = new Wing(this.pen, wingColour);
        this.leg = new Leg(this.pen, legColour);
    }

    public void drawAt(int left, int bottom) {        // 600, 350
        int[] xCoords = {left, left - 50, left - 50, left + 100, left + 175, left + 400, left};
        int[] yCoords = {bottom, bottom + 50, bottom + 100, bottom + 300, bottom + 300, bottom, bottom};

        this.pen.setColor(this.colour);
        this.pen.fillPolygon(xCoords, yCoords, 7);
        this.pen.setColor(Color.BLACK);
        this.pen.drawPolygon(xCoords, yCoords, 7);

        // now drawAt the wing and leg
        this.wing.drawAt(left + 50, bottom);
        this.leg.drawAt(left + 100, bottom + 300);
    }
}
