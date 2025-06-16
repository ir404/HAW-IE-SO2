package drawingTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestDrawingTool extends JFrame implements ActionListener {
    private DrawingArea drawingArea;
    private ControlPanel controlPanel;

    public TestDrawingTool(String title) {
        // Screen size automatically calculated
        int screenWidth = getToolkit().getScreenSize().width;
        int screenHeight = getToolkit().getScreenSize().height;
        int frameWidth = (int) (screenWidth * 0.95);
        int frameHeight = (int) (screenHeight * 0.95);
        int framePlacementX = (int) (screenWidth * 0.5 - frameWidth * 0.5);
        int framePlacementY = (int) (screenHeight * 0.5 - frameHeight * 0.5);

        setTitle(title);
        setLayout(new BorderLayout());

        drawingArea = new DrawingArea(frameWidth, (int) (frameHeight * 0.75));

        controlPanel = new ControlPanel();
        controlPanel.setBackground(Color.CYAN);
        controlPanel.setPreferredSize(new Dimension(frameWidth, (int) (frameHeight * 0.25)));
        controlPanel.initialise();
        controlPanel.getUpdateBtn().addActionListener(this);
        controlPanel.getRegenerateBtn().addActionListener(this);

        // add panels to frame borderLayout
        add(drawingArea, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.CENTER);

        // adjust the frame and display it
        setBounds(framePlacementX, framePlacementY, frameWidth, frameHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TestDrawingTool("R for roosters and C for control ;)");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == controlPanel.getUpdateBtn()) {
            boolean showRockets, showCowboyBoot, showOpenMouth;

            showRockets = controlPanel.getRocketsState();
            showOpenMouth = controlPanel.getOpenMouthState();
            showCowboyBoot = controlPanel.getCowboyBootState();

            drawingArea.getScene().updateRoosters(showOpenMouth, showRockets, showCowboyBoot);
            drawingArea.removeAll();
            drawingArea.repaint();
        } else if (e.getSource() == controlPanel.getRegenerateBtn()) {
            drawingArea.regenerateScene(controlPanel.getAttempts());
            drawingArea.removeAll();
            drawingArea.repaint();
        }
    }
}