package src;
import javax.swing.SwingUtilities;

import src.managers.DatabaseInitializer;
import src.ui.LoginFrame;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
           try {
                DatabaseManager.getCreds();
                DatabaseInitializer.getCreds();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            new LoginFrame();
        });
    }   
}
