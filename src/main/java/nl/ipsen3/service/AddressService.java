/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ipsen3.service;

import java.util.Collection;
import nl.ipsen3.model.Address;
import nl.ipsen3.persistence.AddressDAO;

/**
 *
 * @author Jamie
 */
public class AddressService extends BaseService<Address>
{
    private final AddressDAO dao;
    
    public AddressService(AddressDAO dao)
    {
        this.dao = dao;
    }
    
    public Collection<Address> getAll()
    {
        return dao.getAll();
    }
    
    public Address get(int id)
    {
        return requireResult(dao.get(id));
    }
    
    public void add(Address address)
    {
        dao.add(address);
    }
    
    public void update(int id, Address address)
    {
        // Eerst controleren of deze gebruiker wel bestaat
        Address oldAddress = get(id);
        
        dao.update(id, address);
    }
    
    public void delete(int id)
    {
        // Eerst controleren of deze gebruiker wel bestaat
        Address address = get(id);
        
        dao.delete(id);
    }
}
