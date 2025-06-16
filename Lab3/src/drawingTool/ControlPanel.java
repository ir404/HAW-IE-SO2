package drawingTool;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ControlPanel extends JPanel implements ChangeListener {
    private final Color CONTROL_PANEL_COLOUR = Color.CYAN;
    private final int UI_GROUP_H_GAP = 5;
    private final int UI_GROUP_V_GAP = 15;

    private JLabel rocketsLabel, openMouthLabel, bootLabel, attemptsLabel;
    private JCheckBox rocketsCheckBox, openMouthCheckBox;
    private JComboBox<String> bootComboBox;
    private JButton updateBtn, regenerateBtn;
    private JSlider attemptsSlider;

    public void initialise() {
        Panel attemptsGroup, rocketGroup, openMouthGroup, bootGroup, updateBtnGroup, regenerateBtnGroup;

        setLayout(new GridLayout(2, 4, 20, 0));

        rocketsLabel = new JLabel("Rockets:");
        rocketsCheckBox = new JCheckBox();
        rocketsCheckBox.setBackground(CONTROL_PANEL_COLOUR);
        rocketGroup = new Panel(new FlowLayout(FlowLayout.CENTER, UI_GROUP_H_GAP, UI_GROUP_V_GAP));
        rocketGroup.add(rocketsLabel);
        rocketGroup.add(rocketsCheckBox);

        openMouthLabel = new JLabel("Open mouth:");
        openMouthCheckBox = new JCheckBox();
        openMouthCheckBox.setBackground(CONTROL_PANEL_COLOUR);
        openMouthGroup = new Panel(new FlowLayout(FlowLayout.CENTER, UI_GROUP_H_GAP, UI_GROUP_V_GAP));
        openMouthGroup.add(openMouthLabel);
        openMouthGroup.add(openMouthCheckBox);

        String[] options = {"Default", "Cowboy boot"};
        bootLabel = new JLabel("Boot type:");
        bootComboBox = new JComboBox<>(options);
        bootGroup = new Panel(new FlowLayout(FlowLayout.CENTER, UI_GROUP_H_GAP, UI_GROUP_V_GAP));
        bootGroup.add(bootLabel);
        bootGroup.add(bootComboBox);

        updateBtn = new JButton("Update Roosters");
        updateBtn.setPreferredSize(new Dimension(175, 30));
        updateBtnGroup = new Panel(new FlowLayout(FlowLayout.CENTER, UI_GROUP_H_GAP, UI_GROUP_V_GAP));

        attemptsSlider = new JSlider(0, 1000, 100);
        attemptsSlider.setBackground(CONTROL_PANEL_COLOUR);
        attemptsSlider.setPaintTrack(true);
        attemptsSlider.setPaintTicks(true);
        attemptsSlider.setPaintLabels(true);
        attemptsSlider.setMajorTickSpacing(200);
        attemptsSlider.addChangeListener(this);
        attemptsLabel = new JLabel();
        attemptsLabel.setText("No. of attempts (" + attemptsSlider.getValue() + ")");
        attemptsGroup = new Panel(new FlowLayout(FlowLayout.CENTER, UI_GROUP_H_GAP, UI_GROUP_V_GAP));
        attemptsGroup.add(attemptsLabel);
        attemptsGroup.add(attemptsSlider);
        updateBtnGroup.add(updateBtn);

        regenerateBtn = new JButton("Randomly regenerate");
        regenerateBtn.setPreferredSize(new Dimension(175, 30));
        regenerateBtnGroup = new Panel(new FlowLayout(FlowLayout.CENTER, UI_GROUP_H_GAP, UI_GROUP_V_GAP));
        regenerateBtnGroup.add(regenerateBtn);

        // add groups to control panel
        super.add(rocketGroup);
        super.add(openMouthGroup);
        super.add(bootGroup);
        super.add(updateBtnGroup);
        super.add(new Panel(new FlowLayout(FlowLayout.CENTER, UI_GROUP_H_GAP, UI_GROUP_V_GAP)));
        super.add(attemptsGroup);
        super.add(regenerateBtnGroup);
        super.add(new Panel(new FlowLayout(FlowLayout.CENTER, UI_GROUP_H_GAP, UI_GROUP_V_GAP)));
    }

    public JButton getUpdateBtn() {
        return updateBtn;
    }

    public JButton getRegenerateBtn() {
        return regenerateBtn;
    }

    public boolean getRocketsState() {
        return rocketsCheckBox.isSelected();
    }

    public boolean getOpenMouthState() {
        return openMouthCheckBox.isSelected();
    }

    public boolean getCowboyBootState() {
        return bootComboBox.getSelectedIndex() == 1;
    }

    public int getAttempts() {
        return attemptsSlider.getValue();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        attemptsLabel.setText("No. of attempts (" + attemptsSlider.getValue() + ")");
    }
}
