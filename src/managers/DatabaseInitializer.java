package src.managers;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseInitializer {
    public static void initialize() {
        try (Connection conn = DatabaseManager.GetConnection()) {
            Statement stmt = conn.createStatement();

            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS Student (" +
                "ERP_ID VARCHAR(10) PRIMARY KEY, " +
                "Name VARCHAR(100), " +
                "Course VARCHAR(100))");

            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS Book (" +
                "Book_ID VARCHAR(10) PRIMARY KEY, " +
                "Title VARCHAR(100), " +
                "Author VARCHAR(100), " +
                "Availability ENUM('Yes', 'No'))");

            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS Transactions (" +
                "Transaction_ID INT AUTO_INCREMENT PRIMARY KEY, " +
                "Student_ERP VARCHAR(10), " +
                "Book_ID VARCHAR(10), " +
                "Type ENUM('Borrow', 'Return'), " +
                "Transaction_Date DATE, " +
                "Due_Date DATE)");

            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS Users (" +
                "Username VARCHAR(20) PRIMARY KEY, " +
                "Password VARCHAR(20));"
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}