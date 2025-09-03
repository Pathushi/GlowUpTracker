package ui;

import javax.swing.*;
import java.awt.*;

public class GlowUpFrame extends JFrame {
    private ProgressPanel progressPanel;
    private InputFormPanel inputFormPanel;
    private ReportPanel reportPanel;

    public GlowUpFrame() {
        setTitle("🌟 Glow Up Tracker");
        setSize(700, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Nice modern font
        UIManager.put("Label.font", new Font("SansSerif", Font.PLAIN, 14));
        UIManager.put("Button.font", new Font("SansSerif", Font.BOLD, 14));
        UIManager.put("TextField.font", new Font("SansSerif", Font.PLAIN, 14));

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("SansSerif", Font.BOLD, 14));

        progressPanel = new ProgressPanel();
        inputFormPanel = new InputFormPanel(progressPanel);
        reportPanel = new ReportPanel(progressPanel);

        tabbedPane.addTab("📌 Progress", progressPanel);
        tabbedPane.addTab("➕ Add Habit", inputFormPanel);
        tabbedPane.addTab("📊 Report", reportPanel);

        add(tabbedPane, BorderLayout.CENTER);
    }
}
