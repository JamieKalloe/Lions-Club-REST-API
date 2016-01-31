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
import nl.ipsen3.model.OfferWine;

/**
 *
 * @author Philip Wong
 * @since 25-01-2016
 */
public class OfferWineDAO {
    private final List<OfferWine> offerWines;
    private final Database databaseInstance;
    
    public OfferWineDAO() {
        this.databaseInstance = Database.getInstance();
        this.offerWines = getAllFromDatabase();
    }
    
    public void add(OfferWine offerWine){
        offerWine = this.addOfferToDatabase(offerWine);
        offerWines.add(offerWine);
    }
    
    public void delete(int id) {
        OfferWine offerWine = get(id);
        this.removeOfferFromDatabase(offerWine);
        offerWines.remove(offerWine);
    }
    
    public List<OfferWine> getAll() {
        return this.offerWines;
    }
    
       public OfferWine get(int id) {
        try {
            for(OfferWine offerWine : offerWines) {
                if(offerWine.getId() == id) {
                    return offerWine;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        
        return null;
    }
       
         
    private List<OfferWine> getAllFromDatabase() {
        List<OfferWine> offerWineList = new ArrayList<>();
        ResultSet results = databaseInstance.select("offer_wine");
        
        try {
            while(results.next()) {
                OfferWine offerWine = new OfferWine();
                offerWine.setOfferId(results.getInt("offer_id"));
                offerWine.setWineId(results.getInt("wine_id"));
                              
                offerWineList.add(offerWine);  
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return offerWineList;
    }   
    
    public List<OfferWine> getAllForOfferWinesFromDatabase(int offerId) {
        List<OfferWine> offerWineList = new ArrayList<>();
        ResultSet results = databaseInstance.select("offer_wine", "offer_id=" + offerId);
        
        try {
            while(results.next()) {
                OfferWine offerWine = new OfferWine();
                offerWine.setOfferId(results.getInt("offer_id"));
                offerWine.setWineId(results.getInt("wine_id"));
                offerWineList.add(offerWine); 
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return offerWineList;
    } 
    
    private OfferWine addOfferToDatabase(OfferWine offerWine){
        HashMap databaseData = new HashMap();
        
        databaseData.put("offer_id", offerWine.getOfferId());
        databaseData.put("wine_id", offerWine.getWineId());
                
        databaseInstance.insertInto("offer_wine", databaseData);
             
        return offerWine;
    }
    
    private void removeOfferFromDatabase(OfferWine offerWine) {
        databaseInstance.delete("offer_wine", offerWine.getId());
    }
    
}
