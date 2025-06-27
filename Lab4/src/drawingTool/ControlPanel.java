package drawingTool;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ControlPanel extends JPanel implements ChangeListener {
    private final Color CONTROL_PANEL_COLOUR = Color.LIGHT_GRAY;
    private final int LABEL_WIDTH = 75;
    private final int LABEL_HEIGHT = 20;
    private final int UI_GROUP_H_GAP = 5;
    private final int UI_GROUP_V_GAP = 15;

    private JLabel rocketsLabel, openMouthLabel, bootLabel, attemptsLabel, hatLabel, bowTieLabel, headColourLabel, eyeColourLabel;
    private JCheckBox rocketsCheckBox, openMouthCheckBox, hatCheckBox, bowTieCheckBox;
    private JComboBox<String> bootComboBox, headColourComboBox, eyeColourComboBox;
    private JButton updateBtn, regenerateBtn;
    private JSlider attemptsSlider;

    public void initialise() {
        Panel attemptsGroup, rocketGroup, openMouthGroup, bootGroup, updateBtnGroup, regenerateBtnGroup, hatGroup, bowTieGroup, headColourGroup, eyeColourGroup, wrapper;
        Panel formGrid = new Panel(new GridLayout(0, 1, 5, 5));

        String[] colours1 = {"Yellow", "Orange", "Red"};
        headColourLabel = new JLabel("Head colour:");
        headColourLabel.setPreferredSize(new Dimension(LABEL_WIDTH, LABEL_HEIGHT));
        headColourComboBox = new JComboBox<>(colours1);
        headColourGroup = new Panel(new FlowLayout(FlowLayout.LEFT, UI_GROUP_H_GAP, UI_GROUP_V_GAP));
        headColourGroup.add(headColourLabel);
        headColourGroup.add(headColourComboBox);

        String[] colours2 = {"Black", "Dark grey", "Grey", "Light grey"};
        eyeColourLabel = new JLabel("Eye colour:");
        eyeColourLabel.setPreferredSize(new Dimension(LABEL_WIDTH, LABEL_HEIGHT));
        eyeColourComboBox = new JComboBox<>(colours2);
        eyeColourGroup = new Panel(new FlowLayout(FlowLayout.LEFT, UI_GROUP_H_GAP, UI_GROUP_V_GAP));
        eyeColourGroup.add(eyeColourLabel);
        eyeColourGroup.add(eyeColourComboBox);

        rocketsLabel = new JLabel("Rockets:");
        rocketsLabel.setPreferredSize(new Dimension(LABEL_WIDTH, LABEL_HEIGHT));
        rocketsCheckBox = new JCheckBox();
        rocketsCheckBox.setBackground(CONTROL_PANEL_COLOUR);
        rocketGroup = new Panel(new FlowLayout(FlowLayout.LEFT, UI_GROUP_H_GAP, UI_GROUP_V_GAP));
        rocketGroup.add(rocketsLabel);
        rocketGroup.add(rocketsCheckBox);

        openMouthLabel = new JLabel("Open mouth:");
        openMouthLabel.setPreferredSize(new Dimension(LABEL_WIDTH, LABEL_HEIGHT));
        openMouthCheckBox = new JCheckBox();
        openMouthCheckBox.setBackground(CONTROL_PANEL_COLOUR);
        openMouthGroup = new Panel(new FlowLayout(FlowLayout.LEFT, UI_GROUP_H_GAP, UI_GROUP_V_GAP));
        openMouthGroup.add(openMouthLabel);
        openMouthGroup.add(openMouthCheckBox);

        String[] bootTypes = {"Default", "Cowboy boot"};
        bootLabel = new JLabel("Boot type:");
        bootLabel.setPreferredSize(new Dimension(LABEL_WIDTH, LABEL_HEIGHT));
        bootComboBox = new JComboBox<>(bootTypes);
        bootGroup = new Panel(new FlowLayout(FlowLayout.LEFT, UI_GROUP_H_GAP, UI_GROUP_V_GAP));
        bootGroup.add(bootLabel);
        bootGroup.add(bootComboBox);

        hatLabel = new JLabel("Hat");
        hatLabel.setPreferredSize(new Dimension(LABEL_WIDTH, LABEL_HEIGHT));
        hatCheckBox = new JCheckBox();
        hatCheckBox.setBackground(CONTROL_PANEL_COLOUR);
        hatGroup =  new Panel(new FlowLayout(FlowLayout.LEFT, UI_GROUP_H_GAP, UI_GROUP_V_GAP));
        hatGroup.add(hatLabel);
        hatGroup.add(hatCheckBox);

        bowTieLabel = new JLabel("Bowtie");
        bowTieLabel.setPreferredSize(new Dimension(LABEL_WIDTH, LABEL_HEIGHT));
        bowTieCheckBox = new JCheckBox();
        bowTieCheckBox.setBackground(CONTROL_PANEL_COLOUR);
        bowTieGroup =  new Panel(new FlowLayout(FlowLayout.LEFT, UI_GROUP_H_GAP, UI_GROUP_V_GAP));
        bowTieGroup.add(bowTieLabel);
        bowTieGroup.add(bowTieCheckBox);

        updateBtn = new JButton("Update");
        updateBtn.setPreferredSize(new Dimension(100, LABEL_HEIGHT + 5));
        updateBtnGroup = new Panel(new FlowLayout(FlowLayout.LEFT, UI_GROUP_H_GAP, UI_GROUP_V_GAP));
        updateBtnGroup.add(updateBtn);

        attemptsSlider = new JSlider(0, 500, 100);
        attemptsSlider.setBackground(CONTROL_PANEL_COLOUR);
        attemptsSlider.setPaintTrack(true);
        attemptsSlider.setPaintTicks(true);
        attemptsSlider.setPaintLabels(true);
        attemptsSlider.setMajorTickSpacing(100);
        attemptsSlider.addChangeListener(this);
        attemptsLabel = new JLabel();
        attemptsLabel.setText("No. of attempts (" + attemptsSlider.getValue() + ")");
        attemptsGroup = new Panel(new GridLayout(2, 1));
        attemptsGroup.add(attemptsLabel);
        attemptsGroup.add(attemptsSlider);

        regenerateBtn = new JButton("Randomly regenerate");
        regenerateBtn.setPreferredSize(new Dimension(175, LABEL_HEIGHT + 5));
        regenerateBtnGroup = new Panel(new FlowLayout(FlowLayout.LEFT, UI_GROUP_H_GAP, UI_GROUP_V_GAP));
        regenerateBtnGroup.add(regenerateBtn);

        formGrid.add(headColourGroup);
        formGrid.add(eyeColourGroup);
        formGrid.add(rocketGroup);
        formGrid.add(openMouthGroup);
        formGrid.add(bootGroup);
        formGrid.add(hatGroup);
        formGrid.add(bowTieGroup);
        formGrid.add(updateBtnGroup);
//        formGrid.add(attemptsGroup);
        formGrid.add(regenerateBtnGroup);

        wrapper = new Panel(new FlowLayout(FlowLayout.LEFT));
        wrapper.add(formGrid);

        super.setBackground(CONTROL_PANEL_COLOUR);
        super.add(wrapper);
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

    public boolean getHatState() {
        return hatCheckBox.isSelected();
    }

    public boolean getBowTieState() {
        return bowTieCheckBox.isSelected();
    }

    public boolean getCowboyBootState() {
        return bootComboBox.getSelectedIndex() == 1;
    }

    public int getAttempts() {
        return attemptsSlider.getValue();
    }

    public Color getHeadColour() {
        return switch (headColourComboBox.getSelectedIndex()) {
            case 1 -> Color.ORANGE;
            case 2 -> Color.RED;
            default -> Color.YELLOW;
        };
    }

    public Color getEyeColour() {
        return switch (eyeColourComboBox.getSelectedIndex()) {
            case 1 -> Color.DARK_GRAY;
            case 2 -> Color.GRAY;
            case 3 -> Color.LIGHT_GRAY;
            default -> Color.BLACK;
        };
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        attemptsLabel.setText("No. of attempts (" + attemptsSlider.getValue() + ")");
    }
}
