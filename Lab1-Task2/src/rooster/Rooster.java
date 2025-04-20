package rooster;

import java.awt.*;

public class Rooster {
    private final Graphics pen;
    private final String name;
    private final Head head;
    private final Body body;
    private final Tail tail;

    public Rooster(Graphics pen, String name, Color headColour, Color bodyColour, Color tailColour) {
        this.pen = pen;
        this.name = name;
        this.head = new Head(this.pen, headColour);
        this.body = new Body(this.pen, bodyColour, Color.GREEN, Color.ORANGE);
        this.tail = new Tail(this.pen, tailColour);
    }

    public void drawAt(int left, int bottom) {
        this.pen.setColor(Color.BLACK);
        this.pen.drawString(this.name, left + 350, bottom - 50);

        this.head.drawAt(left, bottom);
        this.body.drawAt(left + 100, bottom + 250);
        this.tail.drawAt(left + 490, bottom);
    }
}
