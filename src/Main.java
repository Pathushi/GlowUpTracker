package src;

import ui.GlowUpFrame;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new GlowUpFrame().setVisible(true);
        });
    }
}
