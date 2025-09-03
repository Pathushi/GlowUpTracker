package ui;

import model.Habit;

import javax.swing.*;
import java.awt.*;

public class ReportPanel extends JPanel {
    private ProgressPanel progressPanel;
    private JTextArea reportArea;

    public ReportPanel(ProgressPanel progressPanel) {
        this.progressPanel = progressPanel;
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(new Color(245, 248, 255));

        JLabel title = new JLabel("📊 Progress Report");
        title.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        reportArea = new JTextArea();
        reportArea.setEditable(false);
        reportArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        reportArea.setBackground(Color.WHITE);
        reportArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        add(new JScrollPane(reportArea), BorderLayout.CENTER);

        JButton refreshButton = new JButton("🔄 Refresh Report");
        refreshButton.setBackground(new Color(100, 150, 200));
        refreshButton.setForeground(Color.WHITE);
        refreshButton.addActionListener(e -> generateReport());
        add(refreshButton, BorderLayout.SOUTH);

        generateReport();
    }

    private void generateReport() {
        StringBuilder sb = new StringBuilder();
        int total = 0, completed = 0;
        for (Habit habit : progressPanel.getService().getProgress().getHabits()) {
            total++;
            if (habit.isCompleted()) completed++;
            sb.append("• ").append(habit.getName())
              .append(" → ")
              .append(habit.isCompleted() ? "✅ Completed" : "⏳ Pending")
              .append("\n");
        }
        sb.append("\n━━━━━━━━━━━━━━━━━━━━━━━\n");
        sb.append("Total Habits   : ").append(total).append("\n");
        sb.append("Completed      : ").append(completed).append("\n");
        sb.append("Pending        : ").append(total - completed).append("\n");

        reportArea.setText(sb.toString());
    }
}
