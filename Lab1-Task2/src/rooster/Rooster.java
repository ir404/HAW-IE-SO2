package rooster;

import drawingTool.Drawing;
import java.awt.*;

public class Rooster {
	private String name;
    private Head head;
    private Body body;
    private Tail tail;

    public Rooster(String name, Color headColour, Color bodyColour, Color tailColour) {
    	this.name = name;
        head = new Head(headColour);
        body = new Body(bodyColour, Color.GREEN, Color.ORANGE);
        tail = new Tail(tailColour);
    }

    public void drawAt(int left, int bottom) {
        Drawing.pen().setColor(Color.BLACK);
        Drawing.pen().drawString(name, left + 350, bottom - 50);

        head.drawAt(left, bottom);
        body.drawAt(left + 100, bottom + 250);
        tail.drawAt(left + 490, bottom);
    }
}
