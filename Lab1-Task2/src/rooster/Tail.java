package rooster;

import java.awt.*;

import drawingTool.Drawing;

public class Tail {
    private final Color colour;

    public Tail(Color colour) {
        this.colour = colour;
    }

    public void drawAt(int left, int bottom) {            // 990, 100
    	Drawing.pen().setColor(this.colour);
        // big feather
    	Drawing.pen().fillArc(left, bottom, 300, 500, 0, 180);
    	Drawing.pen().setColor(Color.decode("#eeeeee"));
    	Drawing.pen().fillArc(left, bottom + 50, 300, 400, 0, 180);
        // small feather
    	Drawing.pen().setColor(this.colour);
    	Drawing.pen().fillArc(left + 10, bottom + 100, 200, 300, 0, 180);
    	Drawing.pen().setColor(Color.decode("#eeeeee"));
    	Drawing.pen().fillArc(left + 10, bottom + 150, 200, 200, 0, 180);
        
        // black outlines
    	Drawing.pen().setColor(Color.BLACK);
    	Drawing.pen().drawArc(left, bottom, 300, 500, 0, 180);
    	Drawing.pen().drawArc(left + 10, bottom + 100, 200, 300, 0, 180);
    	Drawing.pen().drawArc(left, bottom + 50, 300, 400, 0, 180);
    	Drawing.pen().drawArc(left + 10, bottom + 150, 200, 200, 0, 180);
    }
}