package src.ui;
import javax.swing.*;

import src.forms.LibraryApp;
import src.managers.LoginManager;

import java.awt.*;

public class LoginFrame {

    Font font = new Font("Montserrat", Font.BOLD, 20);
    JTextField usernameField;
    JPasswordField passField;
    JCheckBox showPass;

    LoginFrame() {

        System.out.println("LoginFrame created");

        JFrame frame = new JFrame("Library Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new GridBagLayout());
        frame.setResizable(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        JLabel userLabel = new JLabel("Username: ");
        userLabel.setFont(font);
        frame.add(userLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        usernameField = new JTextField(20);
        usernameField.setFont(font);
        frame.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JLabel passLabel = new JLabel("Password: ");
        passLabel.setFont(font);
        frame.add(passLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        passField = new JPasswordField();
        passField.setFont(font);
        frame.add(passField, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
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
        frame.add(showPass, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        JButton submitButton = new JButton("Login");
        submitButton.setBounds(200, 220, 250, 50);
        submitButton.setFont(font);
        submitButton.addActionListener(e -> {
            if(LoginManager.CheckDetails(usernameField.getText(), (new String(passField.getPassword()))))
            {
                new LibraryApp();
                frame.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "ENTER RIGHT USER AND PASS IDOT", "Invalid User/Pass", JOptionPane.ERROR_MESSAGE);
                ResetFields();
            }
        });
        frame.add(submitButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        JButton createButton = new JButton("Create Account");
        createButton.setBounds(200, 280, 250, 50);
        createButton.setFont(font);
        createButton.addActionListener(e -> {
            if(LoginManager.CreateAccount(usernameField.getText(), (new String(passField.getPassword()))))
            {
                JOptionPane.showMessageDialog(null, "Account Creation Successful", "User Created!", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "User Already Exists!", "Creation Unsuccessful", JOptionPane.ERROR_MESSAGE);
            }
            ResetFields();
        });
        frame.add(createButton, gbc);


        frame.setVisible(true);

    }
    
    void ResetFields()
    {
        usernameField.setText("");
        passField.setText("");
        showPass.setSelected(false);
    }
}
