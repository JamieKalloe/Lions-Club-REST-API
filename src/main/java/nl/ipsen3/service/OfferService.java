/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ipsen3.service;


import java.util.ArrayList;
import java.util.Collection;
import nl.ipsen3.persistence.OfferDAO;
import nl.ipsen3.model.Offer;

/**
 *
 * @author Jamie
 */
public class OfferService extends BaseService<Offer>{
    
    private final OfferDAO dao;
    
    /**
     *
     * @param dao data acces object
     */
    public OfferService(OfferDAO dao) {
        this.dao = dao;
    }
    
    /**
     *
     * @return list of all offers
     */
    public Collection<Offer> getAll() {
        return dao.getAll();
    }
    
    /**
     *
     * @param id offer id
     * @return offer
     */
    public Offer get(int id) {
        return requireResult(dao.get(id));
    }
    
    /**
     *
     * @param offer offer to be added
     */
    public void add(Offer offer){
        dao.add(offer);
    }
    
    /**
     *
     * @param id offer id
     * @param offer offer to be updated
     */
    public void update(int id, Offer offer){
        if(offer.isStarted() == 1){
          if(checkToBeStarted()) {
              dao.update(id, offer); 
            }
        }else {
            dao.update(id, offer);
        }
        
    }
    
    /**
     *
     * @param id offer id
     */
    public void delete(int id) {
        Offer offer = get(id);
        
        dao.delete(id);
    }
    /*
    Checks if the current offer can be started
    */

    /**
     *
     * @return boolean
     */

    public boolean checkToBeStarted() {
        Collection<Offer> offers = getAll();
        boolean start = true;
        
        for(Offer offer : offers) {
            if(offer.isStarted() == 1) {
                start = false;
                offer.setStarted(0);
            }
        }
        
        return start;
    }
}
