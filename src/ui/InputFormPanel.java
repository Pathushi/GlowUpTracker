package ui;

import model.Habit;
import service.TrackerService;

import javax.swing.*;
import java.awt.*;

public class InputFormPanel extends JPanel {
    private JTextField nameField;
    private JComboBox<String> frequencyBox;
    private JButton addButton;
    private TrackerService service;
    private ProgressPanel progressPanel;

    public InputFormPanel(ProgressPanel progressPanel) {
        this.progressPanel = progressPanel;
        service = new TrackerService();

        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        setBackground(new Color(245, 245, 250));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("➕ Add a New Habit");
        title.setFont(new Font("SansSerif", Font.BOLD, 18));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(title, gbc);

        gbc.gridwidth = 1;

        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Habit Name:"), gbc);
        gbc.gridx = 1;
        nameField = new JTextField();
        add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Frequency:"), gbc);
        gbc.gridx = 1;
        frequencyBox = new JComboBox<>(new String[]{"Daily", "Weekly"});
        add(frequencyBox, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        addButton = new JButton("✅ Add Habit");
        addButton.setBackground(new Color(100, 180, 100));
        addButton.setForeground(Color.WHITE);
        add(addButton, gbc);

        addButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            if (!name.isEmpty()) {
                Habit habit = new Habit(name, frequencyBox.getSelectedItem().toString());
                service.addHabit(habit);
                nameField.setText("");
                progressPanel.refresh();
                JOptionPane.showMessageDialog(this, "Habit added successfully! 🎉");
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a habit name.");
            }
        });
    }
}
