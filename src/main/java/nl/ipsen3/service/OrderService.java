/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ipsen3.service;

import java.util.Collection;
import nl.IPSEN3.model.Order;
import nl.ipsen3.persistence.OrderDAO;

/**
 *
 * @author Jamie
 */
public class OrderService extends BaseService<Order>{
    
    private final OrderDAO dao;
    
    public OrderService(OrderDAO dao) {
        this.dao = dao;
    }
    
    public Collection<Order> getAll() {
        return dao.getAll();
    }
    
    public Order get(int id) {
        return requireResult(dao.get(id));
    }
    
    public void add(Order order) {
        dao.add(order);
    }
    
    public void update(int id, Order order) {
        Order oldOrder = get(id);
        
        dao.update(id, order);
    }
    
    public void delete(int id) {
        Order order = get(id);
        
        dao.delete(id);
    }
}
