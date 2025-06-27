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

        drawingArea = new DrawingArea((int) (frameWidth * 0.80), frameHeight);

        controlPanel = new ControlPanel();
        controlPanel.setPreferredSize(new Dimension((int) (frameWidth * 0.20), frameHeight));
        controlPanel.initialise();
        controlPanel.getUpdateBtn().addActionListener(this);
        controlPanel.getRegenerateBtn().addActionListener(this);

        super.setLayout(new BorderLayout());
        super.add(drawingArea, BorderLayout.CENTER);
        super.add(controlPanel, BorderLayout.EAST);

        super.setTitle(title);
        super.setBounds(framePlacementX, framePlacementY, frameWidth, frameHeight);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    public static void main(String[] args) {
        new TestDrawingTool("R for roosters and C for control ;)");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == controlPanel.getUpdateBtn()) {
            boolean showRockets, showCowboyBoot, showOpenMouth, showHat, showBowTie;
            Color head, eye;

            showRockets = controlPanel.getRocketsState();
            showOpenMouth = controlPanel.getOpenMouthState();
            showCowboyBoot = controlPanel.getCowboyBootState();
            showHat = controlPanel.getHatState();
            showBowTie = controlPanel.getBowTieState();
            head = controlPanel.getHeadColour();
            eye = controlPanel.getEyeColour();

            drawingArea.getScene().updateRoosters(showOpenMouth, showRockets, showCowboyBoot, showHat, showBowTie, head, eye);
            drawingArea.removeAll();
            drawingArea.repaint();
        } else if (e.getSource() == controlPanel.getRegenerateBtn()) {
            drawingArea.regenerateScene(controlPanel.getAttempts());
            drawingArea.removeAll();
            drawingArea.repaint();
        }
    }
}