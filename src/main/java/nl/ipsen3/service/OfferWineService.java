/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public OfferWineService(OfferWineDAO offerWineDAO) {
        this.offerWineDAO = offerWineDAO;
    }
    
    public Collection<OfferWine> getAll() {
        return offerWineDAO.getAll();
    }
       
    public OfferWine get(int id) {
        return requireResult(offerWineDAO.get(id));
    }
       
    public void add(OfferWine offerWine){
        offerWineDAO.add(offerWine);
    }
    
 
    public void delete(int id) {
        OfferWine offerWine = get(id);
        
        offerWineDAO.delete(id);
    }
}
