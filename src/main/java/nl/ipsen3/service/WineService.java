package nl.ipsen3.service;

import java.util.Collection;
import nl.ipsen3.model.Wine;
import nl.ipsen3.persistence.WineDAO;

/**
 *
 * @author Philip Wong
 * @since 19-01-16
 */
public class WineService extends BaseService<Wine>
{
    
    private final WineDAO dao;
    
    /**
     *
     * @param dao database access object 
     */
    public WineService(WineDAO dao)
    {
        this.dao = dao;
    }
    
    
    /**
     *
     * @return list of all wines in database
     */
    public Collection<Wine> getAll()
    {
        return dao.getAll();
    }
    
    
     /*
     * @offerId id of offer
     * @return List of all wines for this offer
     *
     */
     public Collection<Wine> getAllForOffer(int offerId)
    {
        return dao.getAllForOffer(offerId);
    }
    
     /*
     * @param id id of wine
     * @return List of all wines for this offer
     *
     */
    public Wine get(int id)
    {
        return requireResult(dao.get(id));
    }
    
    /*
     * @param wine wine to be added
     *
     */
    public void add(Wine wine)
    {
        dao.add(wine);
    }
    
     /*
     * @param id id of wine
     * @param wine wine to be added
     *
     */
    public void update(int id, Wine wine)
    {
        
        dao.update(id, wine);
    }
    
    public void delete(int id)
    {   
        dao.delete(id);
    }
}
