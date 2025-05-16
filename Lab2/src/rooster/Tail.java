package rooster;

import java.awt.*;

import drawingTool.Drawing;

public class Tail {
    private Color colour;

    public Tail(Color colour) {
        this.colour = colour;
    }

    public void drawAt(int left, int bottom) {
    	Drawing.pen().setColor(this.colour);
    	Drawing.pen().fillArc(left, bottom - 100, 100, 200, 0, 180);
    	Drawing.pen().setColor(Color.decode("#eeeeee"));
		Drawing.pen().fillArc(left, bottom - 80, 100, 180, 0, 180);
    }
}