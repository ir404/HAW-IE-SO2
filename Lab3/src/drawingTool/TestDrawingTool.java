/**
 * Provides a test application window with a panel.
 *
 * @author Björn Gottfried
 *
 * @version 1.0
 */

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
        Dimension screenSize = getToolkit().getScreenSize();

        setTitle(title);
        setLayout(new BorderLayout());

        drawingArea = new DrawingArea(screenSize.width, (int) (screenSize.height * 0.80));

        controlPanel = new ControlPanel();
        controlPanel.setBackground(Color.CYAN);
        controlPanel.setPreferredSize(new Dimension(screenSize.width, (int) (screenSize.height * 0.20)));
        controlPanel.initialise();
        controlPanel.getUpdateBtn().addActionListener(this);
        controlPanel.getRegenerateBtn().addActionListener(this);

        // add panels to frame borderLayout
        add(drawingArea, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.CENTER);

        // adjust the frame and display
        setBounds(0, 0, screenSize.width, screenSize.height);
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
        }
        else if (e.getSource() == controlPanel.getRegenerateBtn()) {
            drawingArea.regenerateScene(controlPanel.getAttempts());
            drawingArea.removeAll();
            drawingArea.repaint();
        }
    }
}