/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ipsen3.service;

import java.util.Collection;
import nl.IPSEN3.model.Wine;
import nl.IPSEN3.persistence.WineDAO;

/**
 *
 * @author Jamie
 */
public class WineService extends BaseService<Wine>{
    
    private final WineDAO dao;
    
    public WineService(WineDAO dao)
    {
        this.dao = dao;
    }
    
    public Collection<Wine> getAll()
    {
        return dao.getAll();
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
        // Eerst controleren of deze gebruiker wel bestaat
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
