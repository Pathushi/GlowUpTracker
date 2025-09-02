package ui;

import model.Habit;

import javax.swing.*;
import java.awt.*;

public class ReportPanel extends JPanel {
    private ProgressPanel progressPanel;
    private JTextArea reportArea;

    public ReportPanel(ProgressPanel progressPanel) {
        this.progressPanel = progressPanel;
        setLayout(new BorderLayout());

        reportArea = new JTextArea();
        reportArea.setEditable(false);
        add(new JScrollPane(reportArea), BorderLayout.CENTER);

        JButton refreshButton = new JButton("Refresh Report");
        refreshButton.addActionListener(e -> generateReport());
        add(refreshButton, BorderLayout.SOUTH);

        generateReport();
    }

    private void generateReport() {
        StringBuilder sb = new StringBuilder();
        int total = 0, completed = 0;
        for (Habit habit : progressPanel.service.getProgress().getHabits()) {
            total++;
            if (habit.isCompleted()) completed++;
            sb.append(habit.getName())
              .append(" - ")
              .append(habit.isCompleted() ? "Completed" : "Pending")
              .append("\n");
        }
        sb.append("\nTotal Habits: ").append(total)
          .append("\nCompleted: ").append(completed)
          .append("\nPending: ").append(total - completed);
        reportArea.setText(sb.toString());
    }
}
