/**
 * Provides a panel which can be used for drawing.
 *
 * @author Björn Gottfried
 * @version 1.0
 */

package drawingTool;

import rooster.Rooster;

import javax.swing.*;
import java.awt.*;

public class DrawingArea extends JPanel {
    private static final long serialVersionUID = 1L;

    protected void paintComponent(Graphics pen) {
        super.paintComponent(pen);

        Rooster ricky = new Rooster(pen, "Ricky", Color.ORANGE, Color.RED, Color.YELLOW);
        ricky.drawAt(450, 125);
    }
}
