package rooster;

import drawingTool.Drawing;
import drawingTool.LocatedRectangle;

import java.awt.*;

public class Rooster implements LocatedRectangle {
    private final int WIDTH = 375;
    private final int HEIGHT = 325;
    private Point position;
    private String name;
    private Head head;      // composite
    private Body body;      // composite

    public Rooster(Point placeAt, String roosterName, Color headColour, Color bodyColour, Color wingColour, Color legColour, Color tailColour) {
        position = placeAt;
        name = roosterName;
        head = new Head(headColour);
        body = new Body(bodyColour, wingColour, legColour, tailColour);
    }

    public void draw() {
        Drawing.pen().setColor(Color.BLACK);
        Drawing.pen().drawRect(position.x, position.y, WIDTH, HEIGHT);
        Drawing.pen().drawString(name, position.x + 150, position.y + 50);

        head.drawAt(position.x, position.y);
        body.drawAt(position.x + 75, position.y + 125);
    }

    public Point address() {
        return position;
    }

    public int width() {
        return WIDTH;
    }

    public int height() {
        return HEIGHT;
    }
}
