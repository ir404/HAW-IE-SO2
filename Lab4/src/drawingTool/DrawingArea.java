package drawingTool;

import javax.swing.*;
import java.awt.*;

public class DrawingArea extends JPanel {
    private static final long serialVersionUID = 1L;
    private int width, height;
    private Scene scene;

    public DrawingArea(int width, int height) {
        this.width = width;
        this.height = height;
        super.setPreferredSize(new Dimension(this.width, this.height));
        scene = new Scene(this.width, this.height);
    }

    public Scene getScene() {
        return scene;
    }

    public void regenerateScene(int attempts) {
        scene = new Scene(width, height, attempts);
    }

    protected void paintComponent(Graphics pen) {
        super.paintComponent(pen);
        Drawing.set(pen);
        scene.drawRoosters();
    }
}
