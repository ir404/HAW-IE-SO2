package rooster.decorators;

import drawingTool.LocatedRectangle;

import java.awt.*;

public abstract class RectangleDecorator implements LocatedRectangle {
    private LocatedRectangle decoratedLocatedRectangle;

    public RectangleDecorator(LocatedRectangle locatedRectangle) {
        decoratedLocatedRectangle = locatedRectangle;
    }

    @Override
    public Point address() {
        return decoratedLocatedRectangle.address();
    }

    @Override
    public int width() {
        return decoratedLocatedRectangle.width();
    }

    @Override
    public int height() {
        return decoratedLocatedRectangle.height();
    }

    @Override
    public void draw() {
        decoratedLocatedRectangle.draw();
    }

    @Override
    public int getSize() {
        return decoratedLocatedRectangle.getSize();
    }
}
