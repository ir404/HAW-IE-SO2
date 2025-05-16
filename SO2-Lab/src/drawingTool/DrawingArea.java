package drawingTool;

import javax.swing.*;
import java.awt.*;

public class DrawingArea extends JPanel {
    private static long serialVersionUID = 1L;

    protected void paintComponent(Graphics pen) {
        super.paintComponent(pen);
        Drawing.set(pen);

        Scene scene = new Scene();
        scene.drawRoosters();
    }
}
