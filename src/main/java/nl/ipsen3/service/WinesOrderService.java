/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ipsen3.service;

import java.util.Collection;
import nl.ipsen3.model.Wine;
import nl.ipsen3.model.WineOrder;
import nl.ipsen3.persistence.WineDAO;
import nl.ipsen3.persistence.WinesOrderDAO;

/**
 *
 * @author Jamie
 */
public class WinesOrderService extends BaseService<WineOrder> {
    
    private final WinesOrderDAO dao;
    private final WineDAO wineDAO;    
    
    public WinesOrderService(WinesOrderDAO dao, WineDAO wineDAO) {
        this.dao = dao;
        this.wineDAO = wineDAO;
    }
    
    public Collection<WineOrder> getAll() {
        return dao.getAll();
    }
    
    public WineOrder get(int id) {
        return requireResult(dao.get(id));
    }
    
    public void add(WineOrder wineOrder) {
        Wine wine = wineDAO.get(wineOrder.getWineId());
        wineOrder.setWine(wine);
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
