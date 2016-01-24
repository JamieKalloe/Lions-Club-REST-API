package nl.ipsen3.persistence;

import java.util.ArrayList;
import java.util.List;
import nl.ipsen3.model.User;
import nl.ipsen3.database.Database;

import java.util.HashMap;

//Imports for SQL results
import java.sql.ResultSet;
import java.sql.SQLException;
import nl.ipsen3.ApiConfiguration;
/**
 *
 * @author 
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
        user = this.addUserToDatabase(user);
        users.add(user);
    }
    
    public void update(int id, User user)
    {
        User oldUser = this.get(id);
        user.setId(id);
        this.updateUserFromDatabase(user);
        int idInList = users.indexOf(oldUser);
        users.set(idInList, user);
        
    }
    
    public void delete(int id)
    {
        User user = this.get(id);
        this.removeUserFromDatabase(user);
        users.remove(user);
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
    
    private User addUserToDatabase(User user) {
        HashMap databaseData = new HashMap();
        databaseData.put("address_id", user.getAddressId());
        databaseData.put("referral_id", user.getReferralId());
        databaseData.put("email", user.getEmail());
        databaseData.put("first_name", user.getFirstName());
        databaseData.put("last_name", user.getLastName());
        databaseData.put("prefix_last_name", user.getPrefixLastName());
        databaseData.put("gender", user.getGender());
        databaseData.put("notes", user.getNotes());
        databaseData.put("password", user.getPassword());
        databaseData.put("role", user.getRole());

        int id = databaseInstance.insertInto("guest", databaseData);
        user.setId(id);
        return user;
    }
    
    private void updateUserFromDatabase(User user) {
        HashMap databaseData = new HashMap();
        databaseData.put("address_id", user.getAddressId());
        databaseData.put("referral_id", user.getReferralId());
        databaseData.put("email", user.getEmail());
        databaseData.put("first_name", user.getFirstName());
        databaseData.put("last_name", user.getLastName());
        databaseData.put("prefix_last_name", user.getPrefixLastName());
        databaseData.put("gender", user.getGender());
        databaseData.put("notes", user.getNotes());
        databaseData.put("password", user.getPassword());
        databaseData.put("role", user.getRole());

        databaseInstance.update("guest", user.getId(), databaseData);
    }
    
    private void removeUserFromDatabase(User user) {
        databaseInstance.delete("guest", user.getId());
    }
}
