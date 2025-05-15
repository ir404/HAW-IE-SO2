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
    private static long serialVersionUID = 1L;

    protected void paintComponent(Graphics pen) {
        super.paintComponent(pen);
        Drawing.set(pen);

        Rooster ricky = new Rooster("Ricky", Color.ORANGE, Color.RED);
        ricky.drawAt(0, 0);
    }
}
