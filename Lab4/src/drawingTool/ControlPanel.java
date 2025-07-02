package drawingTool;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ControlPanel extends JPanel implements ChangeListener {
    private final Color CONTROL_PANEL_COLOUR = Color.LIGHT_GRAY;

    private JLabel titleLabel, rocketsLabel, openMouthLabel, bootLabel, hatLabel, bowTieLabel, headColourLabel, eyeColourLabel, attemptsLabel;
    private JCheckBox rocketsCheckBox, openMouthCheckBox, hatCheckBox, bowTieCheckBox;
    private JComboBox<String> bootComboBox, headColourComboBox, eyeColourComboBox;
    private JSlider attemptsSlider;
    private JButton updateBtn, regenerateBtn;

    public void initialise() {
        // Set Panel and Layout Manager
        super.setBackground(CONTROL_PANEL_COLOUR);
        super.setLayout(new GridBagLayout());

        initialiseUIComponents();
        addUIComponentsToGrid();
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

    private void initialiseUIComponents() {
        titleLabel = new JLabel("Configurations");
        titleLabel.setFont(new Font(titleLabel.getFont().getName(), Font.BOLD, 14));

        String[] colours1 = {"Yellow", "Orange", "Red"};
        headColourLabel = new JLabel("Head colour:");
        headColourComboBox = new JComboBox<>(colours1);

        String[] colours2 = {"Black", "Dark grey", "Grey", "Light grey"};
        eyeColourLabel = new JLabel("Eye colour:");
        eyeColourComboBox = new JComboBox<>(colours2);

        rocketsLabel = new JLabel("Rockets:");
        rocketsCheckBox = new JCheckBox();
        rocketsCheckBox.setBackground(CONTROL_PANEL_COLOUR);

        openMouthLabel = new JLabel("Open mouth:");
        openMouthCheckBox = new JCheckBox();
        openMouthCheckBox.setBackground(CONTROL_PANEL_COLOUR);

        String[] bootTypes = {"Default", "Cowboy boot"};
        bootLabel = new JLabel("Boot type:");
        bootComboBox = new JComboBox<>(bootTypes);

        hatLabel = new JLabel("Hat:");
        hatCheckBox = new JCheckBox();
        hatCheckBox.setBackground(CONTROL_PANEL_COLOUR);

        bowTieLabel = new JLabel("Bowtie:");
        bowTieCheckBox = new JCheckBox();
        bowTieCheckBox.setBackground(CONTROL_PANEL_COLOUR);

        updateBtn = new JButton("Update");

        attemptsSlider = new JSlider(0, 500, 100);
        attemptsSlider.setBackground(CONTROL_PANEL_COLOUR);
        attemptsSlider.setPaintTicks(true);
        attemptsSlider.setMajorTickSpacing(100);
        attemptsSlider.addChangeListener(this);
        attemptsLabel = new JLabel("No. of attempts (" + attemptsSlider.getValue() + ")");

        regenerateBtn = new JButton("Randomly regenerate");
    }

    private void addUIComponentsToGrid() {
        GridBagConstraints gbc = new GridBagConstraints();

        // --- Row 0: Title Label (Spans 2 columns) ---
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span 2 columns
        gbc.anchor = GridBagConstraints.CENTER;         // Center within the spanned cell
        gbc.fill = GridBagConstraints.NONE;             // Do not stretch the component
        gbc.insets = new Insets(15, 8, 15, 8);          // Top, Left, Bottom, Right
        add(titleLabel, gbc);

        // --- Reset constraints for all standard rows that follow ---
        gbc.gridwidth = 1;                              // Reset grid width
        gbc.fill = GridBagConstraints.HORIZONTAL;       // Stretch components horizontally
        gbc.anchor = GridBagConstraints.LINE_START;     // Align to the left
        gbc.insets = new Insets(2, 8, 2, 8);

        // --- Row 1: Head Colour ---
        gbc.gridy = 1;
        gbc.gridx = 0;
        add(headColourLabel, gbc);
        gbc.gridx = 1;
        add(headColourComboBox, gbc);

        // --- Row 2: Eye Colour ---
        gbc.gridy = 2;
        gbc.gridx = 0;
        add(eyeColourLabel, gbc);
        gbc.gridx = 1;
        add(eyeColourComboBox, gbc);

        // --- Row 3: Rockets ---
        gbc.gridy = 3;
        gbc.gridx = 0;
        add(rocketsLabel, gbc);
        gbc.gridx = 1;
        add(rocketsCheckBox, gbc);

        // --- Row 4: Open Mouth ---
        gbc.gridy = 4;
        gbc.gridx = 0;
        add(openMouthLabel, gbc);
        gbc.gridx = 1;
        add(openMouthCheckBox, gbc);

        // --- Row 5: Boot Type ---
        gbc.gridy = 5;
        gbc.gridx = 0;
        add(bootLabel, gbc);
        gbc.gridx = 1;
        add(bootComboBox, gbc);

        // --- Row 6: Hat ---
        gbc.gridy = 6;
        gbc.gridx = 0;
        add(hatLabel, gbc);
        gbc.gridx = 1;
        add(hatCheckBox, gbc);

        // --- Row 7: Bowtie ---
        gbc.gridy = 7;
        gbc.gridx = 0;
        add(bowTieLabel, gbc);
        gbc.gridx = 1;
        add(bowTieCheckBox, gbc);

        // --- Set constrains for update and regenerate buttons
        gbc.gridwidth = 2;                              // Span 2 columns
        gbc.insets = new Insets(15, 8, 2, 8);           // Add margin above the first button
        gbc.gridx = 0;

        // --- Row 8: Update Button
        gbc.gridy = 8;
        add(updateBtn, gbc);

        // --- Row 9 & 10: Attempts Slider ---
        gbc.insets = new Insets(30, 8, 2, 8);
        gbc.gridy = 9;
        add(attemptsLabel, gbc);

        gbc.insets = new Insets(2, 8, 2, 8); // Reset insets
        gbc.gridy = 10;
        add(attemptsSlider, gbc);

        // --- Row 11: Regenerate Button ---
        gbc.gridy = 11;
        add(regenerateBtn, gbc);

        // --- Spacer to push everything to the top ---
        gbc.gridy = 12;
        gbc.weighty = 1.0;
        JPanel dummyPanel = new JPanel();
        dummyPanel.setBackground(CONTROL_PANEL_COLOUR);
        add(dummyPanel, gbc);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        attemptsLabel.setText("No. of attempts (" + attemptsSlider.getValue() + ")");
    }
}
