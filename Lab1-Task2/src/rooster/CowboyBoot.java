package rooster;

import drawingTool.Drawing;

import java.awt.*;

public class CowboyBoot extends Boot{
    public CowboyBoot(Color colour) {
        super(colour);
    }

    @Override
    public void drawAt(int left, int bottom) {
        super.drawAt(left, bottom);

        Drawing.pen().setColor(Color.ORANGE);
        Drawing.pen().fillRect(left + 30, bottom + 25, 15, 10);
        Drawing.pen().fillOval(left + 40, bottom + 15, 25, 25);
    }
}
