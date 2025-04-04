package src.forms;
import javax.swing.*;
import java.awt.*;

public class BookPanel extends JPanel{
    
    private Font font = new Font("Montserrat", Font.BOLD, 20);

    public BookPanel()
    {
        this.setLayout(new BorderLayout());

        JPanel bookPanel = new JPanel(new GridBagLayout());
       
        String[] buttons = {"Home", "Student", "Transaction"};
        JPanel ribbonPanel = LibraryApp.createRibbonPanel(buttons, font);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel bookId = LibraryApp.createLabel("Book ID", font);
        JLabel bookAuthor = LibraryApp.createLabel("Book Author", font);
        JLabel bookTitle = LibraryApp.createLabel("Book Title", font);

        JLabel[] labels = {bookId, bookAuthor, bookTitle};

        for(int i = 0; i < labels.length; i++)
        {
            LibraryApp.addComponent(bookPanel, labels[i], gbc, 0, i);
        }

        JTextField idField = LibraryApp.createTextField(font);
        JTextField authorField = LibraryApp.createTextField(font);
        JTextField titleField = LibraryApp.createTextField(font);

        JTextField[] tfs = {idField, authorField, titleField};

        for(int i = 0; i < tfs.length; i++)
        {
            LibraryApp.addComponent(bookPanel, tfs[i], gbc, 1, i);
        }

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(e -> {
            try {
                System.out.println("Add Book");
            } catch (Exception e1) {
                
                e1.printStackTrace();
            }
        });
        LibraryApp.addComponent(bookPanel, addButton, gbc, 0, 3);

      
        JButton showButton = new JButton("Show Books");
        showButton.addActionListener(e -> {
            try {
                System.out.println("Show Books");
            } catch (Exception e1) {

                e1.printStackTrace();
            }
        });
        LibraryApp.addComponent(bookPanel, showButton, gbc, 0, 4);

        this.add(bookPanel, BorderLayout.CENTER);
        this.add(ribbonPanel, BorderLayout.NORTH);

        bookPanel.setBackground(Color.gray);
    }
}
