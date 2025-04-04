package src.forms;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

import src.gui.BaseFrame;
import src.gui.BaseHeadPanel;

public class LibraryApp {

    public static JPanel mainPanel;
    public static CardLayout cardLayout;

    private Font headingFont = new Font("Montserrat", Font.BOLD, 80);
    private Font homeFont = new Font("Montserrat", Font.BOLD, 40);
    
    JButton homeButton;
    public LibraryApp()
    {
        JFrame frame = new BaseFrame(1600, 900, "Library Management System", null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        JPanel homePanel = createHomePanel();
        JPanel studentPanel = new StudentPanel();
        JPanel bookPanel = new BookPanel();
        JPanel transactionPanel = new TransactionPanel();

        mainPanel.add(homePanel, "Home");
        mainPanel.add(studentPanel, "Student");
        mainPanel.add(bookPanel, "Book");
        mainPanel.add(transactionPanel, "Transaction");

        frame.add(mainPanel);
        frame.setVisible(true);
    }
   
    private JPanel createHomePanel()
    {
        JPanel mainHomePanel = new JPanel(new BorderLayout());

        Color bgColor = new Color(15354950);
        Color fgColor = Color.white;
        
        JPanel headPanel = new BaseHeadPanel("Library Management System", bgColor, fgColor, headingFont, 30, 50);

        JPanel homePanel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton studentButton = null;
        JButton bookButton = null;
        JButton transactionButton = null;

        String[] buttonNames = {"Student", "Book", "Transaction"};
        JButton[] buttons = {studentButton, bookButton, transactionButton};

        for (int i = 0; i < buttons.length; i++) {
            final int index = i;
            buttons[i] = new JButton();
            JLabel label = LibraryApp.createLabel(buttonNames[i] + " Panel" , homeFont);
            buttons[i].add(label);
            buttons[i].addActionListener(e->{
                cardLayout.show(mainPanel, buttonNames[index]);
            });
        }
        

        for(int i = 0; i < buttons.length; i++)
        {
            addComponent(homePanel, buttons[i], gbc, 0, i);
        }
        homePanel.setBackground(new Color(123, 50, 250));

        homePanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));

        mainHomePanel.add(headPanel, BorderLayout.NORTH);
        mainHomePanel.add(homePanel, BorderLayout.CENTER);

        return mainHomePanel;
    }

    public static JPanel createRibbonPanel (String[] buttons, Font font)
    {   
        JPanel ribbonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 30));

        for (String buttonName : buttons) {
            
            JButton button = new JButton();
            JLabel buttonLabel = createLabel(buttonName + " Panel", font);
            button.add(buttonLabel);
            button.addActionListener(e->
            {
                cardLayout.show(mainPanel, buttonName);
            });
            ribbonPanel.add(button);
        }
        ribbonPanel.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        ribbonPanel.setBackground(new Color(123, 50, 250));
        return ribbonPanel;
    }
    public static JLabel createLabel(String text, Font newFont)
    {
        JLabel label = new JLabel(text);
        label.setFont(newFont);
        return label;
    }

    public static JTextField createTextField(Font font)
    {
        JTextField tf = new JTextField(20);
        tf.setFont(font);
        return tf;
    }

    public static void addComponent(JPanel panel, Component comp, GridBagConstraints gbc, int x, int y)
    {
        if(gbc != null)
        {
            gbc.gridx = x;
            gbc.gridy = y;
            panel.add(comp, gbc);
        }
        else
        {
            panel.add(comp);
        }
    }

}
