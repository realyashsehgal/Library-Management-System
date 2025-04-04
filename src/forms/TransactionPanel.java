package src.forms;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import src.gui.BaseFrame;
import src.gui.BaseHeadPanel;
import src.gui.BaseImagePanel;
import src.managers.StudentManager;
import src.models.Student;

import java.awt.*;
import java.util.List;
public class TransactionPanel extends JPanel{

    private Font font = new Font("Montserrat", Font.BOLD, 20);
    private Font tableFont = new Font("Montserrat", Font.PLAIN, 15);
    private Font headingFont = new Font("Montserrat", Font.BOLD, 80);
    private Font homeFont = new Font("Montserrat", Font.BOLD, 40);

    public TransactionPanel()
    {
            this.setLayout(new BorderLayout());

            String[] buttons = {"Home", "Book", "Student"};
            JPanel ribbonPanel = LibraryApp.createRibbonPanel(buttons, font);

            Color bgColor = new Color(15354950);
            Color fgColor = Color.white;

            JPanel headPanel = new BaseHeadPanel("Transactions", bgColor, fgColor, headingFont, 20, 30);
            headPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2));

            JPanel studentPanel = new JPanel(new BorderLayout());

            BaseImagePanel buttonsPanel = new BaseImagePanel("src/images/studentBackground2.jpg");
            buttonsPanel.setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(20, 20, 20, 20);
            gbc.anchor = GridBagConstraints.WEST;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            JButton borrowButton = new JButton("Borrow Book");
            borrowButton.setFont(homeFont);
            borrowButton.addActionListener(e->
            {
                borrowFrame();
                System.out.println("Borrow");
            });
            LibraryApp.addComponent(buttonsPanel, borrowButton, gbc, 0, 0);

            JButton returnButton = new JButton("Return Book");
            returnButton.setFont(homeFont);
            returnButton.addActionListener(e -> {
                    returnFrame();
                    System.out.println("Return");
            });
            LibraryApp.addComponent(buttonsPanel, returnButton, gbc, 0, 1);

            JButton showButton = new JButton("Show Transactions");
            showButton.setFont(homeFont);
            showButton.addActionListener(e -> {
                    showFrame();
                    System.out.println("Show");
            });
            LibraryApp.addComponent(buttonsPanel, showButton, gbc, 0, 2);

            studentPanel.add(headPanel, BorderLayout.NORTH);
            studentPanel.add(buttonsPanel, BorderLayout.CENTER);
    
            this.add(ribbonPanel, BorderLayout.NORTH);
            this.add(studentPanel, BorderLayout.CENTER);

    }

    private JFrame borrowFrame()
    {
            JFrame mainFrame = new BaseFrame(800, 600, "Add Student", null);

            Color bgColor = new Color(15354950);
            Color fgColor = Color.white;
            JPanel headPanel = new BaseHeadPanel("Add Student", bgColor, fgColor, homeFont, 10, 20);

            JPanel addPanel = new JPanel();   
            addPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10,10,10,10);
    
            gbc.anchor = GridBagConstraints.WEST;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            
            JLabel studentErp = LibraryApp.createLabel("Student ERP", font);
            JLabel studentName = LibraryApp.createLabel("Student Name", font);
            JLabel studentCourse = LibraryApp.createLabel("Student Course", font);
    
            JLabel[] labels = {studentErp, studentName, studentCourse};
            
            for (int i = 0; i < labels.length; i++) {
    
                LibraryApp.addComponent(addPanel, labels[i], gbc, 0, i);
    
            }
           
            JTextField erpField = LibraryApp.createTextField(font);
            JTextField nameField = LibraryApp.createTextField(font);
            JTextField courseField = LibraryApp.createTextField(font);
    
            JTextField[] tfs = {erpField, nameField, courseField};
    
            for (int i = 0; i < tfs.length; i++) {

                LibraryApp.addComponent(addPanel, tfs[i], gbc, 1, i);
            }
    
            JButton borrowButton = new JButton("Add Student");
            borrowButton.addActionListener(e -> {
                String erp = erpField.getText();
                String name = nameField.getText();
                String course = courseField.getText();

                Student student = new Student(erp, name, course);
                String addStudent = StudentManager.addStudent(student);
                if(addStudent.equals("SUCCESS"))
                {
                    JOptionPane.showMessageDialog(null, "Student Successfully Added!", addStudent, JOptionPane.INFORMATION_MESSAGE);
            
                    mainFrame.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, addStudent, "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            });
            LibraryApp.addComponent(addPanel, borrowButton, gbc, 0, 3);

            mainFrame.add(headPanel, BorderLayout.NORTH);
            mainFrame.add(addPanel, BorderLayout.CENTER);

            mainFrame.setVisible(true);
        
        return mainFrame;
    }

    private JFrame returnFrame()
    {
        
        JFrame mainFrame = new BaseFrame(800, 600, "Student Data", null);

        Color bgColor = new Color(15354950);
        Color fgColor = Color.white;

        JPanel headPanel = new BaseHeadPanel("Student Details", bgColor, fgColor, homeFont, 10, 20);

        String[] columnNames = {"ERP ID", "Name", "Course"};

        List<String[]> students = StudentManager.getAllStudents();
        String[][] data = students.toArray(new String[0][]);

        DefaultTableModel model = new DefaultTableModel(data, columnNames){
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        JTable table = new JTable(model);
        table.setFont(tableFont);
        table.setRowHeight(20);


        JScrollPane scrollPane = new JScrollPane(table);

        mainFrame.add(scrollPane, BorderLayout.CENTER);
        mainFrame.add(headPanel, BorderLayout.NORTH);

        mainFrame.setVisible(true);

        return mainFrame;
    }

    private JFrame showFrame()
    {
        JFrame mainFrame = new BaseFrame(800, 600, "Show Transactions", null);

        return mainFrame;
    }


}
