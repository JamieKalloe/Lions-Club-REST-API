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
import nl.ipsen3.model.Offer;
import nl.ipsen3.model.Wine;

/**
 *
 * @author Jamie
 */
public class OfferDAO {
    
    private final List<Offer> offers;
    private final Database databaseInstance;
    
    public OfferDAO() {
        this.databaseInstance = Database.getInstance();
        this.offers = getAllFromDatabase();
    }
    
    public List<Offer> getAll() {
        return this.offers;
    }
    
    public Offer get(int id) {
        try {
            for(Offer offer : offers) {
                if(offer.getId() == id) {
                    return offer;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        
        return null;
    }
    
    public void add(Offer offer) {
        offer = this.addOfferToDatabase(offer);
        offers.add(offer);
    }
    
    public void update(int id, Offer offer) {
        Offer oldOffer = get(id);
        oldOffer.setId(id);
        
        this.updateOfferFromDatabase(offer);
        int idInList = offers.indexOf(offer);
        offers.set(idInList, oldOffer);
    }
    
    public void delete(int id) {
        Offer offer = get(id);
        this.removeOfferFromDatabase(offer);
        offers.remove(offer);
    }
    
    private List<Offer> getAllFromDatabase() {
        List<Offer> offerList = new ArrayList<>();
        ResultSet results = databaseInstance.select("offer");
        
        try {
            while(results.next()) {
                Offer offer = new Offer();
                offer.setId(results.getInt("id"));
                offer.setName(results.getString("name"));
                offer.setStartDate(results.getDate("start_date"));
                offer.setEndDate(results.getDate("end_date"));
                
                //TODO: correctly set wines...
                Wine wine = new Wine(results.getInt("wine_id"));
                ArrayList<Wine> wines = new ArrayList<>();
                wines.add(wine);
                offer.setWines(wines);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return offerList;
    }
    
    private Offer addOfferToDatabase(Offer offer) {
        HashMap databaseData = new HashMap();
        
        databaseData.put("id", offer.getId());
        databaseData.put("name", offer.getName());
        databaseData.put("start_date", offer.getStartDate());
        databaseData.put("end_date", offer.getEndDate());
        databaseData.put("wine_id", offer.getWines().get(0).getId());
        
        int id = databaseInstance.insertInto("offer", databaseData);
        offer.setId(id);
        
        return offer;
    }
    
    private void removeOfferFromDatabase(Offer offer) {
        databaseInstance.delete("offer", offer.getId());
    }
    
    private void updateOfferFromDatabase(Offer offer) {
        HashMap databaseData = new HashMap();
        
        databaseData.put("id", offer.getId());
        databaseData.put("name", offer.getName());
        databaseData.put("start_date", offer.getStartDate());
        databaseData.put("end_date", offer.getEndDate());
        databaseData.put("wine_id", offer.getWines().get(0).getId());
        
        databaseInstance.update("offer", offer.getId(), databaseData);
    }
    
}
