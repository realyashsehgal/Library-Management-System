package src.ui;
import javax.swing.*;

import src.forms.LibraryApp;
import src.gui.BaseFrame;
import src.gui.BaseHeadPanel;
import src.managers.LoginManager;
import src.models.User;

import java.awt.*;

public class LoginFrame {

    Font font = new Font("Montserrat", Font.BOLD, 20);
    Font headFont = new Font("Montserrat", Font.BOLD, 40);
    JTextField usernameField;
    JPasswordField passField;
    JPasswordField confirmPassField;
    JCheckBox showPass;

    User tempUser = new User(null, null);

    public LoginFrame() {

        System.out.println("LoginFrame created");

        JFrame frame = new BaseFrame(800, 600, "Login Window", null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color bgColor = Color.lightGray;
        Color fgColor = Color.cyan;

        JPanel headPanel = new BaseHeadPanel("Login/Sign Up", bgColor, fgColor, headFont, 20, 30);
        JPanel loginPanel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        
        JButton loginButton = new JButton("Log In");
        loginButton.setFont(font);
        loginButton.addActionListener(e -> {
            loginFrame(frame);
        });

        JButton signupButton = new JButton("Sign Up");
        signupButton.setFont(font);
        signupButton.addActionListener(e -> signupFrame());

        LibraryApp.addComponent(loginPanel, loginButton, gbc, 0, 0);
        LibraryApp.addComponent(loginPanel, signupButton, gbc, 0, 1);

        frame.add(headPanel, BorderLayout.NORTH);
        frame.add(loginPanel, BorderLayout.CENTER);

        frame.setVisible(true);

    }

    private JFrame loginFrame(JFrame frame)
    {
        JFrame mainFrame = new BaseFrame(800, 600, "Log in", null);

        Color bgColor = new Color(200, 50, 50);
        Color fgColor = Color.cyan;
        JPanel headPanel = new BaseHeadPanel("Log In", bgColor, fgColor, headFont, 20, 30);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel userLabel = LibraryApp.createLabel("Username: ", font);
        LibraryApp.addComponent(mainPanel, userLabel, gbc, 0, 0);

        
        usernameField = LibraryApp.createTextField(font);
        LibraryApp.addComponent(mainPanel, usernameField, gbc, 1, 0);

        JLabel passLabel = LibraryApp.createLabel("Password: ", font);
        LibraryApp.addComponent(mainPanel, passLabel, gbc, 0, 1);

        passField = new JPasswordField();
        passField.setFont(font);

        LibraryApp.addComponent(mainPanel, passField, gbc, 1, 1);


        showPass = new JCheckBox("Show Password");
        showPass.setFont(font);
        showPass.addActionListener(e -> {
            if(showPass.isSelected())
            {
                passField.setEchoChar((char)0);
            }
            else
            {
                passField.setEchoChar('*');
            }
        });
        LibraryApp.addComponent(mainPanel, showPass, gbc, 2, 1);

        JButton submitButton = new JButton("Login");
        submitButton.setFont(font);
        submitButton.addActionListener(e -> {
            tempUser.setUsername(usernameField.getText());
            tempUser.setPassword(new String(passField.getPassword()));

            String login = LoginManager.CheckDetails(tempUser);
            if(login.equals("SUCCESS"))
            {
                new LibraryApp();
                mainFrame.dispose();
                frame.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null, login, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });
        LibraryApp.addComponent(mainPanel, submitButton, gbc, 0, 2);

        mainFrame.add(headPanel, BorderLayout.NORTH);
        mainFrame.add(mainPanel, BorderLayout.CENTER);

        mainFrame.setVisible(true);
        
        return mainFrame;
    }

    private JFrame signupFrame()
    {
        JFrame mainFrame = new BaseFrame(800, 600, "Sign Up", null);

        Color bgColor = new Color(200, 20, 15);
        Color fgColor = Color.cyan;
        JPanel headPanel = new BaseHeadPanel("Sign Up", bgColor, fgColor, headFont, 20, 30);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel userLabel = LibraryApp.createLabel("Create Username: ", font);
        LibraryApp.addComponent(mainPanel, userLabel, gbc, 0, 0);

        
        usernameField = LibraryApp.createTextField(font);
        LibraryApp.addComponent(mainPanel, usernameField, gbc, 1, 0);

        JLabel passLabel = LibraryApp.createLabel("Create Password: ", font);
        LibraryApp.addComponent(mainPanel, passLabel, gbc, 0, 1);

        passField = new JPasswordField();
        passField.setFont(font);

        LibraryApp.addComponent(mainPanel, passField, gbc, 1, 1);

        showPass = new JCheckBox("Show Password");
        showPass.setFont(font);
        showPass.addActionListener(e -> {
            if(showPass.isSelected())
            {
                passField.setEchoChar((char)0);
            }
            else
            {
                passField.setEchoChar('*');
            }
        });
        LibraryApp.addComponent(mainPanel, showPass, gbc, 2, 1);

        JLabel confirmPassLabel = LibraryApp.createLabel("Confirm Password: ", font);
        LibraryApp.addComponent(mainPanel, confirmPassLabel, gbc, 0, 2);

        confirmPassField = new JPasswordField();
        confirmPassField.setFont(font);

        LibraryApp.addComponent(mainPanel, confirmPassField, gbc, 1, 2);

        JButton submitButton = new JButton("Create Account");
        submitButton.setFont(font);
        submitButton.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to add this User?", "Confirm Dialog", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION)
            {
                String password = new String(passField.getPassword());
                String confirmPassword = new String(confirmPassField.getPassword());
    
                if(!password.equals(confirmPassword))
                {
                    JOptionPane.showMessageDialog(null, "Password and Confirm Password should Match", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    tempUser.setUsername(usernameField.getText());
                    tempUser.setPassword(password);
        
                    String signup = LoginManager.CreateAccount(tempUser);
                    if(signup.equals("SUCCESS"))
                    {
                        JOptionPane.showMessageDialog(null, "User Creation Successful!", "Creation Successful", JOptionPane.INFORMATION_MESSAGE);
                        mainFrame.dispose();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, signup, "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }      
            }
        });
        LibraryApp.addComponent(mainPanel, submitButton, gbc, 0, 3);

        mainFrame.add(headPanel, BorderLayout.NORTH);
        mainFrame.add(mainPanel, BorderLayout.CENTER);

        mainFrame.setVisible(true);
        
        return mainFrame;
    }
    
}
