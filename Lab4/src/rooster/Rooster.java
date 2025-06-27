package rooster;

import drawingTool.Drawing;
import drawingTool.LocatedRectangle;

import java.awt.*;

public class Rooster implements LocatedRectangle {
    private final int WIDTH = 200;
    private final int HEIGHT = 200;

    private int size;
    private Point position;
    private Head head;      // composite
    private Body body;      // composite

    public Rooster(int size, Point placeAt, Color headColour, Color eyeColour) {
        initialise(size, placeAt);
        head = new Head(this.size, headColour, eyeColour);
        body = new Body(this.size);
    }

    public Rooster(int size, Point placeAt, Color headColour, Color eyeColour, boolean openMouth, boolean rockets, boolean cowboyBoot) {
        initialise(size, placeAt);
        head = new Head(this.size, headColour, eyeColour, openMouth);
        body = new Body(this.size, rockets, cowboyBoot);
    }

    @Override
    public Point address() {
        return position;
    }

    @Override
    public int width() {
        return size * WIDTH;
    }

    @Override
    public int height() {
        return size * HEIGHT;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void draw() {
        head.drawAt(position.x, position.y);
        body.drawAt(position.x, position.y);
//        drawGrid();
    }

    private void initialise(int size, Point placeAt) {
        if (size < 1)
            this.size = 1;
        else
            this.size = Math.min(size, 3);

        position = placeAt;
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
}
