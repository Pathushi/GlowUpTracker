package src.ui;

import javax.swing.*;
import java.awt.*;

public class GlowUpFrame extends JFrame {
    private ProgressPanel progressPanel;
    private InputFormPanel inputFormPanel;
    private ReportPanel reportPanel;

    public GlowUpFrame() {
        setTitle("Glow Up Tracker");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        progressPanel = new ProgressPanel();
        inputFormPanel = new InputFormPanel(progressPanel);
        reportPanel = new ReportPanel(progressPanel);

        tabbedPane.addTab("Progress", progressPanel);
        tabbedPane.addTab("Add Habit", inputFormPanel);
        tabbedPane.addTab("Report", reportPanel);

        add(tabbedPane, BorderLayout.CENTER);
    }
}
