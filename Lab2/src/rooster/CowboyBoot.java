package rooster;

import drawingTool.Drawing;

import java.awt.*;

public class CowboyBoot extends Boot {
    private final int ARM_WIDTH = 10;
    private final int ARM_HEIGHT = 10;
    private final int ROWEL_DIAMETER = 22;
    private final int X_OFFSET = 100;
    private final int Y_OFFSET = 180;
    private final Color COLOUR = Color.ORANGE;

    public CowboyBoot(int size) {
        super(size);
    }

    @Override
    public void drawAt(int left, int bottom) {
        super.drawAt(left, bottom);

        Drawing.pen().setColor(COLOUR);
        Drawing.pen().fillRect(left + super.getSize() * X_OFFSET, bottom + super.getSize() * Y_OFFSET, super.getSize() * ARM_WIDTH, super.getSize() * ARM_HEIGHT);
        Drawing.pen().fillOval(left + super.getSize() * (X_OFFSET + ARM_WIDTH), bottom + super.getSize() * (Y_OFFSET - (int)(0.5 * ARM_HEIGHT)), super.getSize() * ROWEL_DIAMETER, super.getSize() * ROWEL_DIAMETER);
    }
}
