package src;
import javax.swing.SwingUtilities;

import src.managers.DatabaseInitializer;
import src.ui.LoginFrame;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DatabaseInitializer.initialize();
            new LoginFrame();
        });
    }   
}
