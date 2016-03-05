/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ipsen3.service;

import java.util.Collection;
import nl.ipsen3.model.Order;
import nl.ipsen3.persistence.OrderDAO;

/**
 *
 * @author Jamie
 */
public class OrderService extends BaseService<Order>{
    
    private final OrderDAO dao;
    
    /**
     *
     * @param dao data acces object
     */
    public OrderService(OrderDAO dao) {
        this.dao = dao;
    }
    
    /**
     *
     * @return list of all orders
     */
    public Collection<Order> getAll() {
        return dao.getAll();
    }
    
    /**
     *
     * @param id order id
     * @return order
     */
    public Order get(int id) {
        return requireResult(dao.get(id));
    }
    
    /**
     *
     * @param order order to be added
     * @return order id
     */
    public int add(Order order) {
        return dao.add(order).getId();
    }
    
    /**
     *
     * @param id order id
     * @param order order to be updated
     */
    public void update(int id, Order order) {
        Order oldOrder = get(id);
        
        dao.update(id, order);
    }
    
    /**
     *
     * @param id order id
     */
    public void delete(int id) {
        Order order = get(id);
        
        dao.delete(id);
    }
}
