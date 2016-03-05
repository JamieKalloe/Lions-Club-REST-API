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
    
    /**
     *
     * @param dao data acces object
     * @param wineDAO data acces object
     */
    public WinesOrderService(WinesOrderDAO dao, WineDAO wineDAO) {
        this.dao = dao;
        this.wineDAO = wineDAO;
    }
    
    /**
     *
     * @return list of all wine orders
     */
    public Collection<WineOrder> getAll() {
        return dao.getAll();
    }
    
    /**
     *
     * @param id wine order id
     * @return wine order
     */
    public WineOrder get(int id) {
        return requireResult(dao.get(id));
    }
    
    /**
     *
     * @param wineOrder wine order to be added
     */
    public void add(WineOrder wineOrder) {
        Wine wine = wineDAO.get(wineOrder.getWineId());
        wineOrder.setWine(wine);
        dao.add(wineOrder);
    }
    
    /**
     *
     * @param id wine order id
     * @param wineOrder wine order to be updated
     */
    public void update(int id, WineOrder wineOrder) {
        WineOrder oldWineOrder = get(id);
        
        dao.update(id, wineOrder);
    }
    
    /**
     *
     * @param id wine order id
     */
    public void delete(int id) {
        WineOrder wineOrder = get(id);
        
        dao.delete(id);
    }
}
