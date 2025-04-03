package src.managers;
import java.sql.*;

public class DatabaseManager {

    private static final String url = "jdbc:mysql://localhost:3306/db";
    private static final String user = "root";
    private static final String password = "Rohit1Rajat@";
    
    public static Connection GetConnection() throws SQLException
    {   
        return DriverManager.getConnection(url, user, password);
    }

    public static void close (Connection conn, PreparedStatement stmt, ResultSet rs)
    {
        try 
        {
            if(conn != null)
            {
                conn.close();
            }
        }
        catch (Exception e){}
        try 
        {
            if(stmt != null)
            {
                stmt.close();
            }
        }
        catch (Exception e){}
        try 
        {
            if(rs != null)
            {
                rs.close();
            }
        }
        catch (Exception e){}
    }
}
