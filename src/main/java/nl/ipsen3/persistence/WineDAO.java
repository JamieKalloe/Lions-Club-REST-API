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
import nl.ipsen3.model.Wine;
import nl.ipsen3.model.WineType;
import nl.ipsen3.database.Database;
import nl.ipsen3.model.Merchant;

/**
 *
 * @author Jamie
 */
public class WineDAO {
    
    private final List<Wine> wines;
    private final Database databaseInstance;
    
    public WineDAO() {
        this.databaseInstance = Database.getInstance();
        this.wines = this.getAllFromDatabase();
    }
    
    public List<Wine> getAll() {
        return wines;
    }
    
    public Wine get(int id) {
        
        for(Wine wine : wines) {
            if(wine.getId() == id) {
                return wine;
            }
        }
        
        return null;
    }
    
    public void add(Wine wine) {
        wines.add(addWineToDatabase(wine));
    }
    
    public void update(int id, Wine wine) {
        wines.set(id, wine);
    }
    
    public void delete(int id) {
        Wine wine = this.get(id);
        this.removeFromDatabase(wine);
        wines.remove(wine);
    }
    
    private void removeFromDatabase(Wine wine) {
        databaseInstance.delete("wine", wine.getId());
    }
    
    private Wine addWineToDatabase(Wine wine) {
        HashMap databaseData = new HashMap();
        databaseData.put("type_id", wine.getType().getId());
        databaseData.put("merchant_id", wine.getMerchant().getId());
        databaseData.put("name", wine.getName());
        databaseData.put("region", wine.getRegion());
        databaseData.put("country", wine.getCountry());
        databaseData.put("year", wine.getYear());
        databaseData.put("price", wine.getPrice());
        
        int id = databaseInstance.insertInto("wine", databaseData);
        wine.setId(id);
        
        return wine;
    }
    
    private List<Wine> getAllFromDatabase() {
        List<Wine> wines = new ArrayList();
        ResultSet results = databaseInstance.select("wine");
        
        try {
            while(results.next()) {
                Wine wine = new Wine();
                
                wine.setId(results.getInt("id"));
                wine.setType(new WineType(results.getInt("type_id")));
                wine.setMerchant(new Merchant(Integer.parseInt(results.getString("merchant_id"))));
                wine.setName(results.getString("name"));
                wine.setCountry(results.getString("country"));
                wine.setRegion(results.getString("region"));
                wine.setYear(results.getInt("year"));
                wine.setPrice(results.getDouble("price"));
                
                wines.add(wine);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return wines;
    }
    
}
