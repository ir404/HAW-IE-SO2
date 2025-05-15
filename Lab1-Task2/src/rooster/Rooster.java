package rooster;

import drawingTool.Drawing;
import java.awt.*;

public class Rooster {
    private final int LEFT_OFFSET = 25;
    private final int BOTTOM_OFFSET = 15;
    private String name;
    private Head head;
    private Body body;

    public Rooster(String name, Color headColour, Color bodyColour) {
        this.name = name;
        head = new Head(headColour);
        body = new Body(bodyColour, Color.GREEN, Color.ORANGE, Color.YELLOW);
    }

    public void drawAt(int left, int bottom) {
        left += LEFT_OFFSET;
        bottom += BOTTOM_OFFSET;

        Drawing.pen().setColor(Color.BLACK);
        Drawing.pen().drawString(name, left + 350, bottom - 50);

        head.drawAt(left, bottom);
        body.drawAt(left + 50, bottom + 100);
    }
}
