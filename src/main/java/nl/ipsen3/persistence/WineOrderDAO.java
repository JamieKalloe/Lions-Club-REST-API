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
public class WineOrderDAO {
    
    private final List<WineOrder> wineOrders;
    private final Database databaseInstance;
    
    public WineOrderDAO() {
        this.databaseInstance = Database.getInstance();
        this.wineOrders = this.getAllFromDatabase();
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
    
    private WineOrder addWineOrderToDatabase(WineOrder wineOrder) {
        HashMap databaseData = new HashMap();
        
        databaseData.put("order_id", wineOrder.getOrderID());
        databaseData.put("wine_id", wineOrder.getWine().getId());
        databaseData.put("total_boxes", wineOrder.getAmount());
        
        int id = databaseInstance.insertInto("wine_order", databaseData);
        wineOrder.setOrderID(id);
        
        return wineOrder;
    }
    
    private void updateWineOrderFromDatabase(WineOrder wineOrder) {
        HashMap databaseData = new HashMap();
        
        databaseData.put("order_id", wineOrder.getOrderID());
        databaseData.put("wine_id", wineOrder.getWine().getId());
        databaseData.put("total_boxes", wineOrder.getAmount());
        
        databaseInstance.update("wine_order", wineOrder.getOrderID(), databaseData);
    }
    
    private void removeWineOrderFromDatabase(WineOrder wineOrder) {
        databaseInstance.delete("wine_order", wineOrder.getOrderID());
    }
    
}
