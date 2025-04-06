package src.forms;

import javax.swing.*;

import src.gui.BaseFrame;
import src.gui.BaseHeadPanel;
import src.gui.BaseImagePanel;
import src.gui.BaseTable;
import src.managers.StudentManager;
import src.models.Student;

import java.awt.*;
import java.util.List;

public class StudentPanel extends JPanel {

    private Font font = new Font("Montserrat", Font.BOLD, 20);
    private Font headingFont = new Font("Montserrat", Font.BOLD, 80);
    private Font homeFont = new Font("Montserrat", Font.BOLD, 40);

    public StudentPanel() {
        this.setLayout(new BorderLayout());

        String[] buttons = { "Home", "Book", "Transaction" };
        JPanel ribbonPanel = LibraryApp.createRibbonPanel(buttons, font);

        Color bgColor = new Color(15354950);
        Color fgColor = Color.white;

        JPanel headPanel = new BaseHeadPanel("Student Data", bgColor, fgColor, headingFont, 20, 30);
        headPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        JPanel studentPanel = new JPanel(new BorderLayout());

        BaseImagePanel buttonsPanel = new BaseImagePanel("src/images/studentBackground2.jpg");
        buttonsPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton addButton = new JButton("Add Student");
        addButton.setFont(homeFont);
        addButton.addActionListener(e -> {
            addFrame();
            System.out.println("ADD");
        });
        LibraryApp.addComponent(buttonsPanel, addButton, gbc, 0, 0);

        JButton removeButton = new JButton("Remove Student");
        removeButton.setFont(homeFont);
        removeButton.addActionListener(e -> {
            removeFrame();
            System.out.println("Remove");
        });
        LibraryApp.addComponent(buttonsPanel, removeButton, gbc, 0, 1);

        JButton showButton = new JButton("Show Students");
        showButton.setFont(homeFont);
        showButton.addActionListener(e -> {
            showFrame();
            System.out.println("SHOW");
        });
        LibraryApp.addComponent(buttonsPanel, showButton, gbc, 0, 2);

        studentPanel.add(headPanel, BorderLayout.NORTH);
        studentPanel.add(buttonsPanel, BorderLayout.CENTER);

        this.add(ribbonPanel, BorderLayout.NORTH);
        this.add(studentPanel, BorderLayout.CENTER);

    }

    private JFrame addFrame() {
        JFrame mainFrame = new BaseFrame(800, 600, "Add Student", null);

        Color bgColor = new Color(15354950);
        Color fgColor = Color.white;
        JPanel headPanel = new BaseHeadPanel("Add Student", bgColor, fgColor, homeFont, 10, 20);

        JPanel addPanel = new JPanel();
        addPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel studentErp = LibraryApp.createLabel("Student ERP", font);
        JLabel studentName = LibraryApp.createLabel("Student Name", font);
        JLabel studentCourse = LibraryApp.createLabel("Student Course", font);

        JLabel[] labels = { studentErp, studentName, studentCourse };

        for (int i = 0; i < labels.length; i++) {

            LibraryApp.addComponent(addPanel, labels[i], gbc, 0, i);

        }

        JTextField erpField = LibraryApp.createTextField(font);
        JTextField nameField = LibraryApp.createTextField(font);
        JTextField courseField = LibraryApp.createTextField(font);

        JTextField[] tfs = { erpField, nameField, courseField };

        for (int i = 0; i < tfs.length; i++) {

            LibraryApp.addComponent(addPanel, tfs[i], gbc, 1, i);
        }

        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(e -> {
            String erp = erpField.getText().toUpperCase();
            String name = nameField.getText();
            String course = courseField.getText();
            int result = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to add student with ERP: " + erp + "?", "Add Confirm",
                    JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                Student student = new Student(erp, name, course);
                String addStudent = StudentManager.addStudent(student);
                if (addStudent.equals("SUCCESS")) {
                    JOptionPane.showMessageDialog(null, "Student Successfully Added!", addStudent,
                            JOptionPane.INFORMATION_MESSAGE);

                    mainFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, addStudent, "ERROR", JOptionPane.ERROR_MESSAGE);
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
        JFrame mainFrame = new BaseFrame(800, 600, "Remove Student", null);

        Color bgColor = new Color(15354950);
        Color fgColor = Color.white;
        JPanel headPanel = new BaseHeadPanel("Remove Student", bgColor, fgColor, homeFont, 10, 20);

        JPanel removePanel = new JPanel();
        removePanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel studentErp = LibraryApp.createLabel("Student ERP", font);
        LibraryApp.addComponent(removePanel, studentErp, gbc, 0, 0);

        JTextField erpField = LibraryApp.createTextField(font);
        LibraryApp.addComponent(removePanel, erpField, gbc, 1, 0);

        JButton removeButton = new JButton("Remove Student");

        removeButton.addActionListener(e -> {
            String erp = erpField.getText().toUpperCase();
            int result = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to remove student with ERP: " + erp + "?", "Remove Confirm",
                    JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                String removeStudent = StudentManager.removeStudent(erp);
                if (removeStudent.equals("SUCCESS")) {
                    JOptionPane.showMessageDialog(null, "Student Successfully Removed!", removeStudent,
                            JOptionPane.INFORMATION_MESSAGE);

                    mainFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, removeStudent, "ERROR", JOptionPane.ERROR_MESSAGE);
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

        JFrame mainFrame = new BaseFrame(800, 600, "Student Data", null);

        Color bgColor = new Color(15354950);
        Color fgColor = Color.white;

        JPanel headPanel = new BaseHeadPanel("Student Details", bgColor, fgColor, homeFont, 10, 20);

        String[] columnNames = { "ERP ID", "Name", "Course" };

        List<String[]> students = StudentManager.getAllStudents();
        String[][] data = students.toArray(new String[0][]);

        JScrollPane dataTable = new BaseTable(data, columnNames);

        mainFrame.add(dataTable, BorderLayout.CENTER);
        mainFrame.add(headPanel, BorderLayout.NORTH);

        mainFrame.setVisible(true);

        return mainFrame;
    }

}
