/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ipsen3.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import nl.ipsen3.database.Database;
import nl.ipsen3.model.WineOrder;

/**
 *
 * @author Jamie
 */
public class WinesOrderDAO {
    private final List<WineOrder> wineOrders;
    private final Database databaseInstance;
    
    /**
     * creates a new instance of the dao
     */
    public WinesOrderDAO() {
        this.databaseInstance = Database.getInstance();
        this.wineOrders = this.getAllFromDatabase();
    }
    
    /**
     *
     * @return list of all wineorders
     */
    public List<WineOrder> getAll() {
        return this.wineOrders;
    }
    
    /**
     *
     * @param id wine order id
     * @return wine order
     */
    public List<WineOrder> getAllFor(int id) {
        return this.getAllForOrder(id);
    }
    
    /**
     *
     * @param id wine order id
     * @return wine order
     */
    public WineOrder get(int id) {
        try {
            for(WineOrder wineOrder : wineOrders) {
                if(wineOrder.getOrderId() == id) {
                    return wineOrder;
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
     * @param wineOrder wine order to be added
     */
    public void add(WineOrder wineOrder) {
        wineOrder = this.addWineOrderToDatabase(wineOrder);
        wineOrders.add(wineOrder);
    }
    
    /**
     *
     * @param id wine order id
     * @param wineOrder wine order to be updated
     */
    public void update(int id, WineOrder wineOrder) {
        WineOrder oldWineOrder = this.get(id);
        wineOrder.setOrderID(id);
        this.updateWineOrderFromDatabase(wineOrder);
        int idInList = wineOrders.indexOf(oldWineOrder);
        wineOrders.set(idInList, wineOrder);
    }
    
    /**
     *
     * @param id wine order id
     */
    public void delete(int id) {
        WineOrder wineOrder = this.get(id);
        this.removeWineOrderFromDatabase(wineOrder);
        wineOrders.remove(wineOrder);
    }
    
    private List<WineOrder> getAllFromDatabase() {
        List<WineOrder> wineOrderList = new ArrayList();
        ResultSet results = databaseInstance.select("wine_order");
        
        try {
            while(results.next()) {
                WineOrder wineOrder = new WineOrder(
                Integer.parseInt(results.getString("order_id")),
                Integer.parseInt(results.getString("wine_id")),
                Integer.parseInt(results.getString("total_boxes")));
                
                wineOrderList.add(wineOrder);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return wineOrderList;
    }
    
    private List<WineOrder> getAllForOrder(int orderId) {
        List<WineOrder> wineOrderList = new ArrayList();
        ResultSet results = databaseInstance.select("wine_order", "order_id = " + orderId);
        
        try {
            while(results.next()) {
                WineOrder wineOrder = new WineOrder(
                Integer.parseInt(results.getString("order_id")),
                Integer.parseInt(results.getString("wine_id")),
                Integer.parseInt(results.getString("total_boxes")));
                
                wineOrderList.add(wineOrder);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return wineOrderList;
    }
    
    private WineOrder addWineOrderToDatabase(WineOrder wineOrder) {
        HashMap databaseData = new HashMap();
        
        databaseData.put("order_id", wineOrder.getOrderId());
        databaseData.put("wine_id", wineOrder.getWineId());
        databaseData.put("total_boxes", wineOrder.getAmount());
        
        int id = databaseInstance.insertInto("wine_order", databaseData);
        wineOrder.setOrderID(id);
        
        return wineOrder;
    }
    
    private void updateWineOrderFromDatabase(WineOrder wineOrder) {
        HashMap databaseData = new HashMap();
        
        databaseData.put("order_id", wineOrder.getOrderId());
        databaseData.put("wine_id", wineOrder.getWine().getId());
        databaseData.put("total_boxes", wineOrder.getAmount());
        
        databaseInstance.update("wine_order", wineOrder.getOrderId(), databaseData);
    }
    
    private void removeWineOrderFromDatabase(WineOrder wineOrder) {
        databaseInstance.delete("wine_order", wineOrder.getOrderId());
    }

}
