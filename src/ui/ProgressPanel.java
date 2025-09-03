package ui;

import service.TrackerService;
import model.Habit;

import javax.swing.*;
import java.awt.*;

public class ProgressPanel extends JPanel {
    private TrackerService service;
    private JPanel habitListPanel;

    public ProgressPanel() {
        service = new TrackerService();
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        setBackground(new Color(250, 250, 255));

        JLabel title = new JLabel("📌 Your Habits");
        title.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        habitListPanel = new JPanel();
        habitListPanel.setLayout(new BoxLayout(habitListPanel, BoxLayout.Y_AXIS));
        habitListPanel.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(habitListPanel);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
        add(scrollPane, BorderLayout.CENTER);

        refresh();
    }

    public void refresh() {
        habitListPanel.removeAll();
        for (Habit habit : service.getProgress().getHabits()) {
            JCheckBox checkBox = new JCheckBox(habit.getName(), habit.isCompleted());
            checkBox.setFont(new Font("SansSerif", Font.PLAIN, 14));
            checkBox.setBackground(Color.WHITE);
            checkBox.addActionListener(e -> {
                service.updateHabit(habit, checkBox.isSelected());
            });
            habitListPanel.add(checkBox);
            habitListPanel.add(Box.createRigidArea(new Dimension(0, 8)));
        }
        revalidate();
        repaint();
    }

    public TrackerService getService() {
        return service;
    }
}
