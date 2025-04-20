/**
 * Provides a panel which can be used for drawing.
 *
 * @author Björn Gottfried
 * @version 1.0
 */

package drawingTool;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawingArea extends JPanel {
    private static final long serialVersionUID = 1L;

    protected void paintComponent(Graphics pen) {
        super.paintComponent(pen);

        pen.drawLine(100, 100, 950, 800);

        pen.setColor(Color.blue); // a color constant
        pen.drawRect(900, 600, 200, 100);

        pen.setColor(Color.decode("#7a5230")); // HEX representation
        pen.fillOval(300, 234, 400, 500);

        pen.setColor(new Color(255, 100, 100)); // RGB representation
        pen.drawString("Hello World", 666, 280);

        int[] xCoords = {850, 750, 950};
        int[] yCoords = {50, 100, 100};

        pen.setColor(Color.YELLOW);
        pen.fillPolygon(xCoords, yCoords, 3);
    }
}