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
public class StudentPanel extends JPanel{

    private Font font = new Font("Montserrat", Font.BOLD, 20);
    private Font tableFont = new Font("Montserrat", Font.PLAIN, 15);
    private Font headingFont = new Font("Montserrat", Font.BOLD, 80);
    private Font homeFont = new Font("Montserrat", Font.BOLD, 40);

    public StudentPanel()
    {
            this.setLayout(new BorderLayout());

            String[] buttons = {"Home", "Book", "Transaction"};
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
            addButton.addActionListener(e->
            {
                addFrame();
                System.out.println("ADD");
            });
            LibraryApp.addComponent(buttonsPanel, addButton, gbc, 0, 0);

            JButton showButton = new JButton("Show Students");
            showButton.setFont(homeFont);
            showButton.addActionListener(e -> {
                    showFrame();
                    System.out.println("SHOW");
            });
            LibraryApp.addComponent(buttonsPanel, showButton, gbc, 0, 1);

            studentPanel.add(headPanel, BorderLayout.NORTH);
            studentPanel.add(buttonsPanel, BorderLayout.CENTER);


            // JButton trollButton = new JButton("TROLLOLOOL");
            // trollButton.setFont(homeFont);
            // trollButton.addActionListener(e -> {
            //         trollFrame();
            //         System.out.println("TROLL");
            // });
            // LibraryApp.addComponent(studentPanel, trollButton, gbc, 0, 2);
            
    
            this.add(ribbonPanel, BorderLayout.NORTH);
            this.add(studentPanel, BorderLayout.CENTER);

    }

    private JFrame addFrame()
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
    
            JButton addButton = new JButton("Add Student");
            addButton.addActionListener(e -> {
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
            LibraryApp.addComponent(addPanel, addButton, gbc, 0, 3);

            mainFrame.add(headPanel, BorderLayout.NORTH);
            mainFrame.add(addPanel, BorderLayout.CENTER);

            mainFrame.setVisible(true);
        
        return mainFrame;
    }

    private JFrame showFrame()
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

    // private JFrame trollFrame()
    // {
          
    //     JFrame mainFrame = new JFrame();
    //     mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    //     mainFrame.setSize(800, 600);
    //     mainFrame.setLayout(new BorderLayout());
    //     mainFrame.setResizable(false);
    //     JPanel panel = new JPanel();
    //     panel.setBackground(Color.red);

    //     mainFrame.add(panel, BorderLayout.CENTER);

    //     mainFrame.setVisible(true);

    //     return mainFrame;
    // }

}
