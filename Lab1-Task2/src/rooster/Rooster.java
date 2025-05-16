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

    public Rooster(Point placeAt, String roosterName) {
        position = placeAt;
        name = roosterName;
    }

    public Rooster(Point placeAt, String roosterName, Color headColour, Color bodyColour, Color wingColour, Color legColour, Color tailColour) {
        position = placeAt;
        name = roosterName;
        head = new Head(headColour);
        body = new Body(bodyColour, wingColour, legColour, tailColour);
    }

    public void draw() {
        int xOffset = 25;
        int yOffset = 25;

        position.x += xOffset;
        position.y += yOffset;

        Drawing.pen().setColor(Color.BLACK);
        Drawing.pen().drawString(name, position.x + 150, position.y + 50);

        Drawing.pen().drawRect(position.x - xOffset, position.y - yOffset, WIDTH, HEIGHT);

        head.drawAt(position.x, position.y);
        body.drawAt(position.x + 50, position.y + 100);
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
