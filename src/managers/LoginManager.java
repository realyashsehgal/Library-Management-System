package src.managers;
import java.util.*;

public class LoginManager {

    private static Map<String, String> details = new HashMap<>();

    public static boolean CreateAccount(String user, String pass)
    {
        if(details.containsKey(user.toLowerCase()))
        {
            return false;
        }
        else if(user.isBlank() || pass.isBlank())
        {
            return false;
        }
        else
        {
            details.put(user.toLowerCase(), pass);
            System.out.println(details);
            return true;
        }
        
    }

    public static boolean CheckDetails(String user, String pass)
    {
        if(details.containsKey(user.toLowerCase()) && details.get(user.toLowerCase()).equals(pass))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    
    
}
