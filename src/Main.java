package src;
import javax.swing.SwingUtilities;

import src.forms.LibraryApp;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LibraryApp();
        });
    }   
}
