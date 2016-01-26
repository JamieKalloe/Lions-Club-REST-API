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
    
    public WineService(WineDAO dao)
    {
        this.dao = dao;
    }
    
    public Collection<Wine> getAll()
    {
        return dao.getAll();
    }
    
     public Collection<Wine> getAllForOffer(int offerId)
    {
        return dao.getAllForOffer(offerId);
    }
    
    public Wine get(int id)
    {
        return requireResult(dao.get(id));
    }
    
    public void add(Wine wine)
    {
        dao.add(wine);
    }
    
    public void update(int id, Wine wine)
    {

        // Eerst controleren of deze wijn wel bestaat

        Wine oldWine = get(id);
        
        dao.update(id, wine);
    }
    
    public void delete(int id)
    {
        // Eerst controleren of deze gebruiker wel bestaat
        Wine wine = get(id);
        
        dao.delete(id);
    }
}
