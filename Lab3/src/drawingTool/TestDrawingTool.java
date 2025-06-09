/**
 * Provides a test application window with a panel.
 *
 * @author Björn Gottfried
 *
 * @version 1.0
 */

package drawingTool;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TestDrawingTool extends JFrame implements ChangeListener, ActionListener {
    private final Color CONTROL_PANEL_COLOUR = Color.CYAN;
    private final int UI_GROUP_H_GAP = 100;
    private final int UI_GROUP_V_GAP = 50;

    private JPanel controlPanel;
    private JLabel attemptsLabel, sizeLabel, rocketsLabel, openMouthLabel, bootLabel;
    private JSlider attemptsSlider;
    private TextField sizeField;
    private JCheckBox rocketsCheckBox, openMouthCheckBox;
    private JComboBox bootComboBox;
    private JButton updateBtn;

    public TestDrawingTool(String title) {
        // Screen size automatically calculated
        Dimension screenSize = getToolkit().getScreenSize();

        setTitle(title);
        setLayout(new BorderLayout());

        DrawingArea drawingArea = new DrawingArea(screenSize.width, (int) (screenSize.height * 0.80));

        controlPanel = new JPanel();
        controlPanel.setBackground(Color.CYAN);
        controlPanel.setPreferredSize(new Dimension(screenSize.width, (int) (screenSize.height * 0.20)));

        initialiseControlPanel();

        // add panels to frame borderLayout
        add(drawingArea, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.CENTER);

        setBounds(0, 0, screenSize.width, screenSize.height);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initialiseControlPanel() {
        Panel attemptsGroup, sizeGroup, rocketGroup, openMouthGroup, bootGroup, buttonGroup;

//        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, UI_GROUP_H_GAP, UI_GROUP_V_GAP));
        controlPanel.setLayout(new GridLayout(2, 3, 50, 0));

        attemptsSlider = new JSlider(0, 1000, 100);
        attemptsSlider.setBackground(CONTROL_PANEL_COLOUR);
        attemptsSlider.setPaintTrack(true);
        attemptsSlider.setPaintTicks(true);
        attemptsSlider.setPaintLabels(true);
        attemptsSlider.setMajorTickSpacing(200);
        attemptsSlider.addChangeListener(this);

        attemptsLabel = new JLabel();
        attemptsLabel.setText("No. of attempts (" + attemptsSlider.getValue() + ")");

        attemptsGroup = new Panel(new FlowLayout(FlowLayout.CENTER, 5, 20));
        attemptsGroup.add(attemptsLabel);
        attemptsGroup.add(attemptsSlider);

        sizeLabel = new JLabel("Size:");
        sizeField = new TextField();
        sizeField.setPreferredSize(new Dimension(100, 20));

        sizeGroup = new Panel(new FlowLayout(FlowLayout.CENTER, 5, 20));
        sizeGroup.add(sizeLabel);
        sizeGroup.add(sizeField);

        rocketsLabel = new JLabel("Display rockets:");
        rocketsCheckBox = new JCheckBox();
        rocketsCheckBox.setBackground(CONTROL_PANEL_COLOUR);
        rocketGroup = new Panel(new FlowLayout(FlowLayout.CENTER, 5, 20));
        rocketGroup.add(rocketsLabel);
        rocketGroup.add(rocketsCheckBox);

        openMouthLabel = new JLabel("Open mouth:");
        openMouthCheckBox = new JCheckBox();
        openMouthCheckBox.setBackground(CONTROL_PANEL_COLOUR);
        openMouthGroup = new Panel(new FlowLayout(FlowLayout.CENTER, 5, 20));
        openMouthGroup.add(openMouthLabel);
        openMouthGroup.add(openMouthCheckBox);

        String[] options = {"Default boot", "Cowboy boot"};
        bootLabel = new JLabel("Type of boot:");
        bootComboBox = new JComboBox(options);
        bootGroup = new Panel(new FlowLayout(FlowLayout.CENTER, 5, 20));
        bootGroup.add(bootLabel);
        bootGroup.add(bootComboBox);


        updateBtn = new JButton("Update Roosters");
        updateBtn.addActionListener(this);
        updateBtn.setPreferredSize(new Dimension(150, 25));
        buttonGroup = new Panel(new FlowLayout(FlowLayout.CENTER, 5, 20));
        buttonGroup.add(updateBtn);

        // add groups to control panel
        controlPanel.add(attemptsGroup);
        controlPanel.add(sizeGroup);
        controlPanel.add(rocketGroup);
        controlPanel.add(openMouthGroup);
        controlPanel.add(bootGroup);
        controlPanel.add(buttonGroup);
    }

    public static void main(String[] args) {
        new TestDrawingTool("R for roosters!!");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updateBtn) {
            boolean showRockets, showCowboyBoot, showOpenMouth;

            showRockets = rocketsCheckBox.isSelected();
            showOpenMouth = openMouthCheckBox.isSelected();
            showCowboyBoot = bootComboBox.getSelectedIndex() == 1;
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == attemptsSlider) {
            attemptsLabel.setText("No. of attempts (" + attemptsSlider.getValue() + ")");
        }
    }
}