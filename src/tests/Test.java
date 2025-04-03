// package src.tests;
// import java.sql.*;

// import src.managers.StudentManager;
// import src.models.Student;

// public class Test {
    
//     static Student student;
//     public static void main(String[] args) {
//         try
//         {
//             String url = "jdbc:mysql://localhost:3306/db";
//             String user = "root";
//             String password = "Rohit1Rajat@";
//             Connection conn = DriverManager.getConnection(url, user, password);
//             Statement stmt = conn.createStatement();
//             for(Integer i = 0; i < 20; i++)
//             {   
//                 if(i < 10)
//                 {
//                     student = new Student("0231BCA00"+i, i.toString()+"A", "BBA");
//                 }
//                 else
//                 {
//                     student = new Student("0231BCA0"+i, i.toString()+"A", "BBA");
                    
//                 }
//                 StudentManager.addStudent(student);
//             }

//         }
//         catch(Exception e)
//         {
//             System.out.println(e.getMessage());
//         }
//     }
// }
