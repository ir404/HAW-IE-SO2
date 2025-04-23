package rooster;

import drawingTool.Drawing;
import java.awt.*;

public class Rooster {
    private final String name;
    private final Head head;
    private final Body body;
    private final Tail tail;

    public Rooster(String name, Color headColour, Color bodyColour, Color tailColour) {
        this.name = name;
        this.head = new Head(headColour);
        this.body = new Body(bodyColour, Color.GREEN, Color.ORANGE);
        this.tail = new Tail(tailColour);
    }

    public void drawAt(int left, int bottom) {
        Drawing.pen().setColor(Color.BLACK);
        Drawing.pen().drawString(this.name, left + 350, bottom - 50);

        this.head.drawAt(left, bottom);
        this.body.drawAt(left + 100, bottom + 250);
        this.tail.drawAt(left + 490, bottom);
    }
}
