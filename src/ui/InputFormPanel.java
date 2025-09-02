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

        setLayout(new GridLayout(3, 2, 10, 10));

        nameField = new JTextField();
        frequencyBox = new JComboBox<>(new String[]{"Daily", "Weekly"});
        addButton = new JButton("Add Habit");

        add(new JLabel("Habit Name:"));
        add(nameField);
        add(new JLabel("Frequency:"));
        add(frequencyBox);
        add(new JLabel(""));
        add(addButton);

        addButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            if (!name.isEmpty()) {
                Habit habit = new Habit(name, frequencyBox.getSelectedItem().toString());
                service.addHabit(habit);
                nameField.setText("");
                progressPanel.refresh();
            } else {
                JOptionPane.showMessageDialog(this, "Enter a habit name!");
            }
        });
    }
}
