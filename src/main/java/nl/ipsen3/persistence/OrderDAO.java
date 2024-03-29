/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ipsen3.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import nl.ipsen3.model.Order;
import nl.ipsen3.database.Database;
import nl.ipsen3.model.Wine;
import nl.ipsen3.model.WineOrder;

/**
 *
 * @author Jamie
 */
public class OrderDAO {
    
    private final List<Order> orders;
    private final Database databaseInstance;
    
    /**
     * new instance of the dao
     */
    public OrderDAO() {
        this.databaseInstance = Database.getInstance();
        this.orders = this.getAllFromDatabase();
    }
    
    /**
     *
     * @return list of all orders
     */
    public List<Order> getAll() {
        return this.orders;
    }
    
    /**
     *
     * @param id order id
     * @return order
     */
    public Order get(int id) {
        try {
            for(Order order : orders) {
                if(order.getId() == id) {
                    return order;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        
        return null;
    }
    
    /**
     *
     * @param order order to be added
     * @return order
     */
    public Order add(Order order) {
        order = this.addOrderToDatabase(order);
        return order;

    }
    
    /**
     *
     * @param id order id
     * @param order order to be updated
     */
    public void update(int id, Order order) {
        Order oldOrder = this.get(id);
        order.setId(id);
        this.updateOrderFromDatabase(oldOrder);
        int idInList = orders.indexOf(oldOrder);
        orders.set(idInList, order);
    }
    
    /**
     *
     * @param id order id
     */
    public void delete(int id) {
        Order order = this.get(id);
        this.removeOrderFromDatabase(order);
        orders.remove(order);
    }
    
    private List<Order> getAllFromDatabase() {
        List<Order> orderList = new ArrayList();
        ResultSet results = databaseInstance.select("order");
        WinesOrderDAO wDao = new WinesOrderDAO();
        
        try {
            while(results.next()) {
                Order order = new Order(
                Integer.parseInt(results.getString("id")),
                Integer.parseInt(results.getString("guest_id")),
                Integer.parseInt(results.getString("status_id")));
                
                //Get all wineOrders for a specific orderId
                order.setWineOrders(new ArrayList<WineOrder>(wDao.getAllFor(order.getId())));
                
                orderList.add(order);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return orderList;
    }
    
    
    private Order addOrderToDatabase(Order order) {
        HashMap databaseData = new HashMap();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        databaseData.put("guest_id", order.getUserId());
        databaseData.put("status_id", order.getOrderStatus());
        databaseData.put("order_date", sdf.format(new Date()));
        databaseData.put("offer_id", order.getOfferId());
        
        int id = databaseInstance.insertInto("order", databaseData);
        order.setId(id);
        
        return order;
    }
    
    private void updateOrderFromDatabase(Order order) {
        HashMap databaseData = new HashMap();
        
        databaseData.put("guest_id", order.getUserId());
        databaseData.put("status_id", order.getOrderStatus());
        
        databaseInstance.update("order", order.getId(), databaseData);
    }
    
    private void removeOrderFromDatabase(Order order) {
        databaseInstance.delete("order", order.getId());
    }
}
