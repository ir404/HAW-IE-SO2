package rooster;

import java.awt.*;
import drawingTool.Drawing;

public class Hackle {
    private final Color colour;

    public Hackle(Color colour) {
        this.colour = colour;
    }

    public void drawAt(int left, int bottom) {     // 485, 250
    	Drawing.pen().setColor(this.colour);
    	Drawing.pen().fillOval(left, bottom, 15, 100);
    	Drawing.pen().setColor(Color.BLACK);
    	Drawing.pen().drawOval(left, bottom, 15, 100);
    }
}