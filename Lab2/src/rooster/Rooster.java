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

    public Rooster(int size, Point placeAt, String roosterName, Color headColour, Color bodyColour, Color wingColour, Color legColour, Color tailColour) {
        if (size < 1)
            this.size = 1;
        else
            this.size = Math.min(size, 3);

        position = placeAt;
        name = roosterName;
        head = new Head(size);
        body = new Body(bodyColour, wingColour, legColour, tailColour);
    }

    public void draw() {
        Drawing.pen().setColor(Color.BLACK);
        Drawing.pen().drawRect(position.x, position.y, WIDTH * size, HEIGHT * size);
        drawGrid();
        Drawing.pen().drawString(name, position.x + 150, position.y + 50);

        head.drawAt(position.x, position.y);
//        body.drawAt(position.x + 75, position.y + 125);
    }

    private void drawGrid() {
        Drawing.pen().setColor(Color.BLACK);

        for (int i = position.x; i < position.x + (size * WIDTH); i+=10) {
            for (int j = position.y; j < size * position.y + (size * HEIGHT); j += 10) {
                Drawing.pen().drawRect(i, j, 10, 10);
            }
        }
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
