// package src.tests;
// import java.sql.*;

// import com.mysql.cj.protocol.Resultset;

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
//             for(int i = 0; i < 10; i++)
//             {
//                 stmt.executeUpdate("INSERT INTO Book (Book_ID, Title, Author) VALUES ('B"+i+"','ABCDE', 'BCDEF')");
//             }
//         }
//         catch(Exception e)
//         {
//             System.out.println(e.getMessage());
//         }
//     }
// }

