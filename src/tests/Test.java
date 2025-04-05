// package src.tests;
// import java.sql.*;
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

//             stmt.executeUpdate("CREATE TABLE Book(Book_ID VARCHAR(10) PRIMARY KEY, Title VARCHAR(20) NOT NULL, Author VARCHAR(20) NOT NULL)");

//         }
//         catch(Exception e)
//         {
//             System.out.println(e.getMessage());
//         }
//     }
// }

