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
import nl.ipsen3.ApiConfiguration;
import nl.ipsen3.database.Database;
import nl.ipsen3.model.Merchant;

/**
 *
 * @author Philip Wong
 */
public class MerchantDAO {
    
    private final List<Merchant> merchants;
    private final Database databaseInstance;
    
    public MerchantDAO() {
        this.databaseInstance = Database.getInstance();
        this.merchants = getAllFromDatabase();
    }
    
    public List<Merchant> getAll() {
        return this.merchants;
    }
    
    public Merchant get(int id) {
        try {
            for(Merchant merchant : merchants) {
                if(merchant.getId() == id) {
                    return merchant;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        
        return null;
    }
   
    private List<Merchant> getAllFromDatabase() {
        List<Merchant> merchantList = new ArrayList<>();
        System.out.println("getAllFromDatabase");
        ResultSet results = databaseInstance.select("wine_merchant");
        
        try {
            while(results.next()) {
                Merchant merchant = new Merchant();
                merchant.setId(results.getInt("id"));
                merchant.setName(results.getString("name"));
                merchant.setAddressId(results.getInt("address_id")); 
                merchant.setEmail(results.getString("email"));
                merchantList.add(merchant);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return merchantList;
    }
    
   
}
