package src.forms;

import javax.swing.*;

import src.gui.BaseFrame;
import src.gui.BaseHeadPanel;
import src.gui.BaseImagePanel;
import src.gui.BaseTable;
import src.managers.BookManager;
import src.models.Book;

import java.awt.*;
import java.util.List;

public class BookPanel extends JPanel {

    private Font font = new Font("Montserrat", Font.BOLD, 20);
    private Font headingFont = new Font("Montserrat", Font.BOLD, 80);
    private Font homeFont = new Font("Montserrat", Font.BOLD, 40);

    public BookPanel() {
        this.setLayout(new BorderLayout());

        String[] buttons = { "Home", "Student", "Transaction" };
        JPanel ribbonPanel = LibraryApp.createRibbonPanel(buttons, font);

        Color bgColor = new Color(15354950);
        Color fgColor = Color.white;

        JPanel headPanel = new BaseHeadPanel("Book Data", bgColor, fgColor, headingFont, 20, 30);
        headPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        JPanel bookPanel = new JPanel(new BorderLayout());

        BaseImagePanel buttonsPanel = new BaseImagePanel("src/images/studentBackground2.jpg");
        buttonsPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton addButton = new JButton("Add Book");
        addButton.setFont(homeFont);
        addButton.addActionListener(e -> {
            addFrame();
            System.out.println("ADD");
        });
        LibraryApp.addComponent(buttonsPanel, addButton, gbc, 0, 0);

        JButton removeButton = new JButton("Remove Book");
        removeButton.setFont(homeFont);
        removeButton.addActionListener(e -> {
            removeFrame();
            System.out.println("Remove");
        });
        LibraryApp.addComponent(buttonsPanel, removeButton, gbc, 0, 1);

        JButton showButton = new JButton("Show Books");
        showButton.setFont(homeFont);
        showButton.addActionListener(e -> {
            showFrame();
            System.out.println("SHOW");
        });
        LibraryApp.addComponent(buttonsPanel, showButton, gbc, 0, 2);

        bookPanel.add(headPanel, BorderLayout.NORTH);
        bookPanel.add(buttonsPanel, BorderLayout.CENTER);

        this.add(ribbonPanel, BorderLayout.NORTH);
        this.add(bookPanel, BorderLayout.CENTER);

    }

    private JFrame addFrame() {
        JFrame mainFrame = new BaseFrame(800, 600, "Add Book", null);

        Color bgColor = new Color(15354950);
        Color fgColor = Color.white;
        JPanel headPanel = new BaseHeadPanel("Add Book", bgColor, fgColor, homeFont, 10, 20);

        JPanel addPanel = new JPanel();
        addPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel bookId = LibraryApp.createLabel("Book ID: ", font);
        JLabel bookName = LibraryApp.createLabel("Book Title: ", font);
        JLabel bookAuthor = LibraryApp.createLabel("Book Author: ", font);

        JLabel[] labels = { bookId, bookName, bookAuthor };

        for (int i = 0; i < labels.length; i++) {

            LibraryApp.addComponent(addPanel, labels[i], gbc, 0, i);

        }

        JTextField idField = LibraryApp.createTextField(font);
        JTextField titleField = LibraryApp.createTextField(font);
        JTextField authorField = LibraryApp.createTextField(font);

        JTextField[] tfs = { idField, titleField, authorField };

        for (int i = 0; i < tfs.length; i++) {

            LibraryApp.addComponent(addPanel, tfs[i], gbc, 1, i);
        }

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(e -> {
            String id = idField.getText().toUpperCase();
            String title = titleField.getText();
            String author = authorField.getText();
            int result = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to add Book with ID: " + id + "?", "Add Confirm",
                    JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                Book book = new Book(id, title, author);
                String addBook = BookManager.addBook(book);
                if (addBook.equals("SUCCESS")) {
                    JOptionPane.showMessageDialog(null, "Book Successfully Added!", addBook,
                            JOptionPane.INFORMATION_MESSAGE);

                    mainFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, addBook, "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        LibraryApp.addComponent(addPanel, addButton, gbc, 0, 3);

        mainFrame.add(headPanel, BorderLayout.NORTH);
        mainFrame.add(addPanel, BorderLayout.CENTER);

        mainFrame.setVisible(true);

        return mainFrame;
    }

    private JFrame removeFrame() {
        JFrame mainFrame = new BaseFrame(800, 600, "Remove Book", null);

        Color bgColor = new Color(15354950);
        Color fgColor = Color.white;
        JPanel headPanel = new BaseHeadPanel("Remove Book", bgColor, fgColor, homeFont, 10, 20);

        JPanel removePanel = new JPanel();
        removePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel bookId = LibraryApp.createLabel("Book ID: ", font);
        LibraryApp.addComponent(removePanel, bookId, gbc, 0, 0);

        JTextField idField = LibraryApp.createTextField(font);
        LibraryApp.addComponent(removePanel, idField, gbc, 1, 0);

        JButton removeButton = new JButton("Remove Book");

        removeButton.addActionListener(e -> {
            String id = idField.getText().toUpperCase();
            int result = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to remove Book with ID: " + id + "?", "Remove Confirm",
                    JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                String removeBook = BookManager.removeBook(id);
                if (removeBook.equals("SUCCESS")) {
                    JOptionPane.showMessageDialog(null, "Book Successfully Removed!", removeBook,
                            JOptionPane.INFORMATION_MESSAGE);

                    mainFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, removeBook, "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        LibraryApp.addComponent(removePanel, removeButton, gbc, 0, 3);

        mainFrame.add(headPanel, BorderLayout.NORTH);
        mainFrame.add(removePanel, BorderLayout.CENTER);

        mainFrame.setVisible(true);

        return mainFrame;
    }


    private JFrame showFrame() {

        JFrame mainFrame = new BaseFrame(800, 600, "Book Data", null);

        Color bgColor = new Color(15354950);
        Color fgColor = Color.white;

        JPanel headPanel = new BaseHeadPanel("Book Details", bgColor, fgColor, homeFont, 10, 20);

        String[] columnNames = { "Book ID", "Title", "Author" , "Availability"};

        List<String[]> books = BookManager.getAllBooks();
        String[][] data = books.toArray(new String[0][]);

        JScrollPane dataTable = new BaseTable(data, columnNames);

        mainFrame.add(dataTable, BorderLayout.CENTER);
        mainFrame.add(headPanel, BorderLayout.NORTH);

        mainFrame.setVisible(true);

        return mainFrame;
    }


}