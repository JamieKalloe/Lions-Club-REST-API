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

    UserService() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        
        dao.update(id, user);
    }
    
    public void delete(int id)
    {
        // Eerst controleren of deze gebruiker wel bestaat
        User user = get(id);
        
        dao.delete(id);
    }
}
