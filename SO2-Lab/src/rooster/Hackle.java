package rooster;

import java.awt.*;
import drawingTool.Drawing;

public class Hackle {
    private Color colour;

    public Hackle(Color colour) {
        this.colour = colour;
    }

    public void drawAt(int left, int bottom) {     // 485, 250
    	Drawing.pen().setColor(this.colour);
    	Drawing.pen().fillOval(left, bottom, 10, 50);
    }
}