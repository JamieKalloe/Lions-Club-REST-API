package nl.ipsen3.service;

import java.util.Collection;
import nl.ipsen3.model.User;
import nl.ipsen3.persistence.UserDAO;

/**
 *
 * @author 
 */
public class UserService extends BaseService<User>
{
    private final UserDAO dao;
    
    public UserService(UserDAO dao)
    {
        this.dao = dao;
    }
    
    public Collection<User> getAll()
    {
        return dao.getAll();
    }
    
    public User get(int id)
    {
        return requireResult(dao.get(id));
    }
    
    public void add(User user)
    {
        dao.add(user);
    }
    
    public void update(int id, User user)
    {
        // Eerst controleren of deze gebruiker wel bestaat
        User oldUser = get(id);
        System.out.println("UserService: update user" );
        dao.update(id, user);
    }
    
    public void delete(int id)
    {
        // Eerst controleren of deze gebruiker wel bestaat
        User user = get(id);
        
        dao.delete(id);
    }
}
