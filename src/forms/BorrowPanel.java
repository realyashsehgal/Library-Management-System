package src.forms;
import javax.swing.*;
import java.awt.*;

public class BorrowPanel extends JPanel{
    private Font font = new Font("Montserrat", Font.BOLD, 20);
 

    public BorrowPanel()
    {
        this.setLayout(new BorderLayout());
        
        String[] buttons = {"Home", "Student", "Book", "Return"};
        JPanel ribbonPanel = LibraryApp.createRibbonPanel(buttons, font);


        JPanel returnPanel = new JPanel(new GridBagLayout());
        returnPanel.setBackground(Color.green);

        this.add(returnPanel, BorderLayout.CENTER);
        this.add(ribbonPanel, BorderLayout.NORTH);

        returnPanel.setBackground(Color.gray);
    }
}
