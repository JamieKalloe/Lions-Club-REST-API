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
import nl.ipsen3.model.Address;

/**
 *
 * @author Jamie
 */
public class AddressDAO {
    
    private final List<Address> addresses;
    private final Database databaseInstance;
    
    public AddressDAO() {
        this.databaseInstance = Database.getInstance();
        this.addresses = this.getAllFromDatabase();
    }
    
    public List<Address> getAll() {
        return this.addresses;
    }
    
    public Address get(int id) {
        try {
            for(Address address : addresses) {
                if(address.getId() == id) {
                    return address;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        
        return null;
    }
    
    public void add(Address address) {
        address = this.addAddressToDatabase(address);
        addresses.add(address);
    }
    
    public void update(int id, Address address) {
        Address oldAddress = get(id);
        address.setId(id);
        
        this.updateAdrdressFromDatabase(address);
        int idInList = addresses.indexOf(oldAddress);
        addresses.set(idInList, oldAddress);
    }
    
    public void delete(int id) {
        Address address = get(id);
        this.removeAddressFromDatabase(address);
        addresses.remove(address);
    }
    
    private List<Address> getAllFromDatabase() {
        List<Address> addressList = new ArrayList();
        ResultSet results = databaseInstance.select("address");
        
        try {
            while(results.next()) {
                Address address = new Address(
                results.getInt("id"),
                results.getString("zipcode"),
                results.getString("street"),
                results.getString("house_number"),
                results.getString("country"),
                results.getString("city"));
                
                addressList.add(address);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return addressList;
    }
    
    private Address addAddressToDatabase(Address address) {
        HashMap databaseData = new HashMap();
        
        databaseData.put("zipcode", address.getZipCode());
        databaseData.put("street", address.getStreet());
        databaseData.put("house_number", address.getHouseNumber());
        databaseData.put("country", address.getCountry());
        databaseData.put("city", address.getCity());
        
        int id = databaseInstance.insertInto("address", databaseData);
        address.setId(id);
        
        return address;
    }
    
    private void removeAddressFromDatabase(Address address) {
        databaseInstance.delete("address", address.getId());
    }
    
    private void updateAdrdressFromDatabase(Address address) {
        HashMap databaseData = new HashMap();
        
        databaseData.put("zipcode", address.getZipCode());
        databaseData.put("street", address.getStreet());
        databaseData.put("house_number", address.getHouseNumber());
        databaseData.put("country", address.getCountry());
        databaseData.put("city", address.getCity());
        
        databaseInstance.update("Address", address.getId(), databaseData);
    }
    
}
