package nl.ipsen3.service;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;
import nl.ipsen3.model.User;

/**
 *
 * @author 
 * @param <T>
 */
public class BaseService<T>
{
    public T requireResult(T model)
    {
        if (model == null)
        {
            throw new NotFoundException();
        }
        
        return model;
    }
    
    public void assertSelf(User user1, User user2)
    {
        if (!user1.equals(user2))
        {
            throw new ForbiddenException();
        }
    }
}
