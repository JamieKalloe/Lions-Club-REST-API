/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.IPSEN3.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nl.ipsen3.database.Database;
import nl.ipsen3.model.WineOrder;

/**
 *
 * @author Bernd
 */
public class WineOrderDAO {
    private final List<WineOrder> allWineOrders;
    private final Database databaseInstance;
    
    public WineOrderDAO() {
        this.databaseInstance = Database.getInstance();
        this.allWineOrders = this.getAllFromDatabase();
    }
    
    public List<WineOrder> getAll() {
        return allWineOrders;
    }

    public WineOrder get(int id) {
        for (WineOrder wineOrder : allWineOrders) {
            if (wineOrder.getOrderID() == id) {
                return wineOrder;
            }
        }
        
        return null;
    }
    
    public void add (WineOrder wineOrder) {
        allWineOrders.add(addWineOrderToDatabase(wineOrder));
    }
    
    
    private WineOrder addWineOrderToDatabase(WineOrder wineOrder) {
        HashMap databaseData = new HashMap();
        databaseData.put("order_id", wineOrder.getOrderID());
        databaseData.put("wine_id", wineOrder.getWine().getId());
        databaseData.put("total_boxes", wineOrder.getAmount());
        
        databaseInstance.insertInto("wine_order", databaseData);
        
        return wineOrder;
    }
    private List<WineOrder> getAllFromDatabase() {
        List<WineOrder> wineOrders = new ArrayList();
        ResultSet results = databaseInstance.select("wine_order");
        
        try {
            while(results.next()) {
                WineOrder wineOrder = new WineOrder();
                wineOrder.setOrderID(results.getInt("order_id"));
                wineOrder.getWine().setId(results.getInt("wine_id"));
                wineOrder.setAmount(results.getInt("total_boxes"));
                
                wineOrders.add(wineOrder);
            }
        } catch (SQLException ex) {
            Logger.getLogger(WineOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return wineOrders;
    }
    
  

    //This will return an ArrayList with WineOrder objects that belong to @param orderID
    public ArrayList<WineOrder> find(int orderID) {
        ArrayList<WineOrder> wineOrders = new ArrayList<>();
        ResultSet queryResult = databaseInstance.select("wine_order", "order_id="+orderID);
        try {
            while(queryResult.next()) {
                WineOrder order = new WineOrder(orderID, queryResult.getInt("wine_id"), queryResult.getInt("total_boxes"));
                wineOrders.add(order);
            }
        } catch(SQLException sqlE) {
        }
        return wineOrders;
    }

    
    public void update(int id, WineOrder wineOrder) {
        allWineOrders.set(id, wineOrder);

    }

    public void delete(int id) {
        WineOrder wineOrder = this.get(id);
        this.removeFromDatabase(wineOrder);
        allWineOrders.remove(wineOrder);

    }

    public void removeFromDatabase(WineOrder wineOrder) {
        databaseInstance.delete("wine_order", wineOrder.getOrderID());
    }
    
}
