/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ipsen3.service;

import java.util.Collection;
import nl.ipsen3.model.WineOrder;
import nl.ipsen3.persistence.WineOrderDAO;

/**
 *
 * @author Jamie
 */
public class WineOrderSerivce extends BaseService<WineOrder> {
    
    private final WineOrderDAO dao;
    
    public WineOrderSerivce(WineOrderDAO dao) {
        this.dao = dao;
    }
    
    public Collection<WineOrder> getAll() {
        return dao.getAll();
    }
    
    public WineOrder get(int id) {
        return requireResult(dao.get(id));
    }
    
    public void add(WineOrder wineOrder) {
        dao.add(wineOrder);
    }
    
    public void update(int id, WineOrder wineOrder) {
        WineOrder oldWineOrder = get(id);
        
        dao.update(id, wineOrder);
    }
    
    public void delete(int id) {
        WineOrder wineOrder = get(id);
        
        dao.delete(id);
    }
    
}
