package nl.ipsen3.service;

import java.util.Collection;
import java.util.Optional;
import nl.ipsen3.model.Address;
import nl.ipsen3.model.User;
import nl.ipsen3.persistence.UserDAO;

/**
 *
 * @author Philip Wong
 */
public class UserService extends BaseService<User>
{
    private final UserDAO dao;
    private AddressService addressService;
    
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
    
    public int add(User user)
    {
        dao.add(user);
        return 1;
    }
    
    public void update(int id, User user)
    {
        dao.update(id, user);
    }
    
     public void updateRole(User user)
    {
        dao.updateRole(user);
    }
    
    public void delete(int id)
    {
       // Controleren of deze gebruiker wel bestaat
        User user = get(id);
        
        dao.delete(id);
    }
    
    public int checkIfEmailExists(String emailAddress)
    {
        Collection<User> users = getAll();
        Optional<User> result = users.stream()
            .filter(user -> user.getEmail().equals(emailAddress))
            .findAny();

        return result.isPresent()
            ? 1
            : 0;
    }

}
