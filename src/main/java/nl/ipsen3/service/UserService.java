package nl.ipsen3.service;

import java.util.Collection;
import java.util.Optional;
import nl.ipsen3.model.MailType;
import nl.ipsen3.persistence.MailFactory;
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
    
    /**
     *
     * @param dao data access object 
     */
    public UserService(UserDAO dao)
    {
        this.dao = dao;
    }
    
    /**
     *
     * @return List of all users
     */
    public Collection<User> getAll()
    {
        return dao.getAll();
    }
    
    public User get(int id)
    {
        return requireResult(dao.get(id));
    }
    
    /**
     *
     * @param user user to be added
     * @return id of the added user
     */
    public int add(User user)
    {
        dao.add(user);
        try {
            new nl.ipsen3.service.MailService().send(new MailFactory(user).generate(MailType.REGISTRATION));
        } catch(Exception e) {
            e.printStackTrace();
        }
        return 1;
    }
    
    /**
     *
     * @param id id of the user
     * @param user user to be added
     */
    public void update(int id, User user)
    {
        dao.update(id, user);
    }
    
     /**
     *
     * @param user user to be updated
     */
     public void updateRole(User user)
    {
        dao.updateRole(user);
    }
    
     /**
     *
     * @param id id of user to be deleted
     */
    public void delete(int id)
    {
       // Controleren of deze gebruiker wel bestaat
        User user = get(id);
        
        dao.delete(id);
    }
    
    
    /**
     *
     * @param emailAddress email of the user
     * @return id of user 
     */
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
