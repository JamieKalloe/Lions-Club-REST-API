package nl.ipsen3.service;


import java.util.Collection;
import nl.ipsen3.model.OfferWine;
import nl.ipsen3.persistence.OfferWineDAO;


/**
 * @author Philip
 * @since 25-01-16
 */
public class OfferWineService extends BaseService<OfferWine>{
    
    private final OfferWineDAO offerWineDAO;
    
    /**
     *
     * @param dao data acces object
     */
    public OfferWineService(OfferWineDAO dao) {
        this.offerWineDAO = dao;
    }
    
      /**
     *
     * @return list of all orders
     */
    public Collection<OfferWine> getAll() {
        return offerWineDAO.getAll();
    }
       
    /**
     *
     * @param id of the offerWine to get
     * @return offerWine
     */
    public OfferWine get(int id) {
        return requireResult(offerWineDAO.get(id));
    }
    
    /**
     *
     * @param offerWine offerWine to be added
     * 
     */
    public void add(OfferWine offerWine){
        offerWineDAO.add(offerWine);
    }
    
    /**
     *
     * @param id offerWine to be deleted
     *
     */
    public void delete(int id) {
        OfferWine offerWine = get(id);
        
        offerWineDAO.delete(id);
    }
}
