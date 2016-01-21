package nl.ipsen3.service;

import javax.ws.rs.NotFoundException;

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
}
