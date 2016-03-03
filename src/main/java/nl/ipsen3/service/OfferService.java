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
    
    public OfferService(OfferDAO dao) {
        this.dao = dao;
    }
    
    public Collection<Offer> getAll() {
        return dao.getAll();
    }
    
    public Offer get(int id) {
        return requireResult(dao.get(id));
    }
    
    public void add(Offer offer){
        dao.add(offer);
    }
    
    public void update(int id, Offer offer){
        if(offer.isStarted() == 1){
          if(checkToBeStarted()) {
              dao.update(id, offer); 
            }
        }else {
            dao.update(id, offer);
        }
        
    }
    
    public void delete(int id) {
        Offer offer = get(id);
        
        dao.delete(id);
    }
    /*
    Checks if the current offer can be started
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
