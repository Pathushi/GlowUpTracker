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
        setLayout(new BorderLayout());

        habitListPanel = new JPanel();
        habitListPanel.setLayout(new BoxLayout(habitListPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(habitListPanel);
        add(scrollPane, BorderLayout.CENTER);

        refresh();
    }

    public void refresh() {
        habitListPanel.removeAll();
        for (Habit habit : service.getProgress().getHabits()) {
            JCheckBox checkBox = new JCheckBox(habit.getName(), habit.isCompleted());
            checkBox.addActionListener(e -> {
                service.updateHabit(habit, checkBox.isSelected());
            });
            habitListPanel.add(checkBox);
        }
        revalidate();
        repaint();
    }

    // ✅ Add this getter to allow ReportPanel to access the service
    public TrackerService getService() {
        return service;
    }
}
