package src.forms;
import java.awt.*;

import javax.swing.*;

public class LibraryApp {

    public static JPanel mainPanel;
    public static CardLayout cardLayout;

    private Font homeFont = new Font("Montserrat", Font.BOLD, 40);
    
    JButton homeButton;
    public LibraryApp()
    {
        System.out.println("Library app");
        JFrame frame = new JFrame("Library Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout());
        frame.setSize(1600,900);
        frame.setResizable(false);
        
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        JPanel homePanel = createHomePanel();
        JPanel studentPanel = new StudentPanel();
        JPanel bookPanel = new BookPanel();
        JPanel borrowPanel = new BorrowPanel();
        JPanel returnPanel = new ReturnPanel();

        mainPanel.add(homePanel, "Home");
        mainPanel.add(studentPanel, "Student");
        mainPanel.add(bookPanel, "Book");
        mainPanel.add(borrowPanel, "Borrow");
        mainPanel.add(returnPanel, "Return");

        frame.add(mainPanel);
        frame.setVisible(true);
    }
   
    private JPanel createHomePanel()
    {
        
        JPanel homePanel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton studentButton = null;
        JButton bookButton = null;
        JButton borrowButton = null;
        JButton returnButton = null;

        String[] buttonNames = {"Student", "Book", "Borrow", "Return"};
        JButton[] buttons = {studentButton, bookButton, borrowButton, returnButton};

        for (int i = 0; i < buttons.length; i++) {
            final int index = i;
            buttons[i] = new JButton();
            JLabel label = LibraryApp.createLabel(buttonNames[i] + " Panel" , homeFont);
            buttons[i].add(label);
            buttons[i].addActionListener(e->{
                cardLayout.show(mainPanel, buttonNames[index]);
            });
        }
        

        for(int i = 0; i < 4; i++)
        {
            addComponent(homePanel, buttons[i], gbc, 0, i);
        }
        return homePanel;
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
