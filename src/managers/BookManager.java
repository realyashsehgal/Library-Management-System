package src.managers;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import src.models.Book;

public class BookManager {
   
    private static final String addQuery = "INSERT INTO Book (Book_ID, Title, Author) VALUES (?, ?, ?)";
    private static final String showQuery = "SELECT * FROM Book ORDER BY Book_ID ASC";
    private static final String removeQuery = "DELETE FROM Book WHERE Book_ID = ?";

    private static Connection conn;
    private static PreparedStatement st;
    private static ResultSet rs;

    public static String addBook(Book book)
    {
        if(book.getId().isEmpty() || book.getTitle().isEmpty() || book.getAuthor().isEmpty())
        {
            return "Fields can not be empty!";
        }
        try
        {
        conn = DatabaseManager.GetConnection();
        st = conn.prepareStatement(addQuery);
        st.setString(1, book.getId());
        st.setString(2, book.getTitle());
        st.setString(3, book.getAuthor());

        st.executeUpdate();

        return "SUCCESS";
        }
        catch(SQLException e)
        {
            return e.getMessage();
        } 
        finally
        {
            DatabaseManager.close(conn, st, null);
        }
    }

    public static String removeBook(String id)
    {
        if(id.isEmpty())
        {
            return "Fields can not be empty!";
        }
        try
        {
        conn = DatabaseManager.GetConnection();
        st = conn.prepareStatement(removeQuery);
        st.setString(1, id);
        int result = st.executeUpdate();
        
        if(result == 0 )
        {
            return "Book with this ID does not exist!";
        }
        return "SUCCESS";
        }
        catch(SQLException e)
        {
            return e.getMessage();
        } 
        finally
        {
            DatabaseManager.close(conn, st, null);
        }
    }
    
    public static List<String[]> getAllBooks()
    {
        try
        {
        conn = DatabaseManager.GetConnection();
        st = conn.prepareStatement(showQuery);
        rs = st.executeQuery();

        List<String[]> books = new ArrayList<>();
        
        while (rs.next()) {
            books.add(new String[] { rs.getString(1),
                                        rs.getString(2), 
                                        rs.getString(3)});
        }
        
        return books;
    
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
            return null;
        }
        finally
        {
            DatabaseManager.close(conn, st, rs);
        }
    }
}

