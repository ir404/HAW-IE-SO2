package rooster;

import drawingTool.Drawing;
import drawingTool.LocatedRectangle;

import java.awt.*;

public class Rooster implements LocatedRectangle {
    private final int WIDTH = 200;
    private final int HEIGHT = 200;

    private int size;
    private Point position;
    private String name;
    private Head head;      // composite
    private Body body;      // composite

    public Rooster(int size, Point placeAt, String roosterName, Color tailColour) {
        if (size < 1)
            this.size = 1;
        else
            this.size = Math.min(size, 3);

        position = placeAt;
        name = roosterName;
        head = new Head(this.size);
        body = new Body(this.size, tailColour);
    }

    public void draw() {
        head.drawAt(position.x, position.y);
        body.drawAt(position.x, position.y);

        Drawing.pen().setColor(Color.BLACK);
        Drawing.pen().drawString(name, position.x + size * (int)(0.5 * WIDTH), position.y + (int)(0.25 * HEIGHT));
    }

    private void drawGrid() {
        Drawing.pen().setColor(Color.BLACK);
        for (int i = position.x; i < position.x + (size * WIDTH); i += 10) {
            for (int j = position.y; j < position.y + (size * HEIGHT); j += 10) {
                Drawing.pen().drawRect(i, j, 10, 10);
            }
        }
        Drawing.pen().drawRect(position.x, position.y, WIDTH * size, HEIGHT * size);
    }

    public Point address() {
        return position;
    }

    public int width() {
        return size * WIDTH;
    }

    public int height() {
        return size * HEIGHT;
    }
}
