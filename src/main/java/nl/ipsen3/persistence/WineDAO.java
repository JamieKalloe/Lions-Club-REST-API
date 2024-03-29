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
import java.util.logging.Level;
import java.util.logging.Logger;
import nl.ipsen3.model.Wine;
import nl.ipsen3.model.WineType;
import nl.ipsen3.database.Database;
import nl.ipsen3.model.Merchant;
import nl.ipsen3.model.OfferWine;

/**
 *
 * @author Jamie
 */
public class WineDAO {
    
    private final List<Wine> allWines;
    private final Database databaseInstance;
    
    /**
     * creates a new instance of the dao
     */
    public WineDAO() {
        this.databaseInstance = Database.getInstance();
        this.allWines = this.getAllFromDatabase();
    }
    
    /**
     *
     * @return list of all wines
     */
    public List<Wine> getAll() {
        return getAllFromDatabase();
    }
    
    /**
     *
     * @param offerId offer id
     * @return list of all wine for an offer
     */
    public List<Wine> getAllForOffer(int offerId) {
        return getAllWinesForOfferFromDatabase(offerId);
    }
      
    /**
     *
     * @param id wine id
     * @return wine
     */
    public Wine get(int id) {
        
        for(Wine wine : getAllFromDatabase()) {
            if(wine.getId() == id) {
                return wine;
            }
        }
        
        return null;
    }
    
    /**
     *
     * @param wine wine to be added
     */
    public void add(Wine wine) {
        allWines.add(addWineToDatabase(wine));
    }
    
    /**
     *
     * @param id wine id
     * @param wine wine to be updated
     */
    public void update(int id, Wine wine) {
        allWines.set(id, wine);
    }
    
    /**
     *
     * @param id wine id
     */
    public void delete(int id) {
        Wine wine = this.get(id);
        this.removeFromDatabase(wine);
        allWines.remove(wine);
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
    
     private List<Wine> getAllWinesForOfferFromDatabase(int offerId) {
          
        List<Wine> wines = new ArrayList();
       
        OfferWineDAO offerWineDAO = new OfferWineDAO();
        List<OfferWine> offerWineList = offerWineDAO.getAllForOfferWinesFromDatabase(offerId);
        
        offerWineList.forEach(offerWine -> {
              ResultSet results = databaseInstance.select("wine","id=" + offerWine.getWineId());
            try {
                while(results.next()){
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
            } catch (SQLException ex) {
                Logger.getLogger(WineDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
       
     
         return wines;
     }
   }
 
