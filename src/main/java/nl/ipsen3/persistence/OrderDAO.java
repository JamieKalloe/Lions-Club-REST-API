package nl.ipsen3.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nl.ipsen3.model.Order;
import nl.ipsen3.database.Database;
import nl.ipsen3.model.OrderStatus;

/**
 *
 * @author Bernd
 */
public class OrderDAO {
    private final List<Order> allOrders;
    private final Database databaseInstance;
    
    public OrderDAO() {
        this.databaseInstance = Database.getInstance();
        this.allOrders = this.getAllFromDatabase();
    }
    
    public List<Order> getAll() {
        return allOrders;
    }
    
    public Order get(int id) {
        for (Order order : allOrders) {
            if (order.getId() == id) {
                return order;
            }
        }
        
        return null;
    }
    
    public void add (Order order) {
        allOrders.add(addOrderToDatabase(order));
    }
    
    public void update(int id, Order order) {
        allOrders.set(id, order);
    }
    
    public void delete(int id) {
        Order order = this.get(id);
        this.removeOrderFromDatabase(order);
        allOrders.remove(order);
    }
    
    private void removeFromDatabase(Order order) {
        databaseInstance.delete("order", order.getId());
    }
    
    private Order addOrderToDatabase(Order order) {
        HashMap databaseData = new HashMap();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        ArrayList<Integer>wineIDs = (ArrayList<Integer>) databaseData.get("wineIDs");
        ArrayList<Integer>amounts = (ArrayList<Integer>) databaseData.get("amounts");
        
       
        databaseData.put("guest_id", order.getUserId());
        databaseData.put("offer_id", order.getOfferId());
        databaseData.put("status_id", order.getOrderStatus().getId());
        databaseData.put("order_date", sdf.format(order.getDate()));
        
        int id = databaseInstance.insertInto("order", databaseData);
        order.setId(id);
        return order;
        
    }
    
    
    
    
    
    private List<Order> getAllFromDatabase() {
        List<Order> orders = new ArrayList();
        ResultSet results = databaseInstance.select("order");
        
        try {
            while(results.next()) {
                Order order = new Order();
                
                order.setId(results.getInt("id"));
                order.setOfferId(results.getInt("offer_id"));
                order.setUserId(results.getInt("guest_id"));
//                order.getOrderStatus().setId(results.getInt("status_id"));
                
                
                
              

                orders.add(order);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return orders;
    }
    
   
    private void removeOrderFromDatabase(Order order) {
        databaseInstance.delete("order", order.getId());
    }



   
}
