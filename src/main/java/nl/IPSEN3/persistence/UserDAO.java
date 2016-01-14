package nl.ipsen3.persistence;

import java.util.ArrayList;
import java.util.List;
import nl.ipsen3.model.User;
import nl.ipsen3.database.Database;
//Imports for SQL results
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Peter van Vliet
 */
public class UserDAO
{
    private final List<User> users;
    private final Database databaseInstance;
    
    public UserDAO()
    {
        this.databaseInstance = Database.getInstance();
        users = this.getAllFromDatabase();
    }
    
    public List<User> getAll()
    {
        return users;
    }
    
    public User get(int id)
    {
        try
        {
            for(User user : users) {
                if(user.getId() == id) {
                    return user;
                }
            }
            return null;
        }
        catch(IndexOutOfBoundsException exception)
        {
            return null;
        }
    }
    
    public void add(User user)
    {
        users.add(user);
    }
    
    public void update(int id, User user)
    {
        users.set(id, user);
    }
    
    public void delete(int id)
    {
        users.remove(id);
    }
    
    // PRIVATE functions
    
    private List<User> getAllFromDatabase(){
        List<User> users = new ArrayList();
        ResultSet results = databaseInstance.select("guest");
        try {
            while(results.next()) {
                User user = new User();
                
                user.setId(results.getInt("id"));
                user.setAddressId(results.getInt("address_id"));
                user.setReferralId(results.getInt("referral_id"));
                user.setEmail(results.getString("email"));
                user.setFirstName(results.getString("first_name"));
                user.setLastName(results.getString("last_name"));
                user.setPrefixLastName(results.getString("prefix_last_name"));
                user.setGender(results.getString("gender"));
                user.setNotes(results.getString("notes"));
                user.setPassword(results.getString("password"));
                user.setRole(results.getInt("role"));
                
                users.add(user);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
