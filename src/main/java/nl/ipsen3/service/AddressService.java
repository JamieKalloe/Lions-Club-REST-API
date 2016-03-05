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
    
    /**
     *
     * @param dao data acces object
     */
    public AddressService(AddressDAO dao)
    {
        this.dao = dao;
    }
    
    /**
     *
     * @return list of all addresses
     */
    public Collection<Address> getAll()
    {
        return dao.getAll();
    }
    
    /**
     *
     * @param id address id
     * @return address
     */
    public Address get(int id)
    {
        return requireResult(dao.get(id));
    }
    
    /**
     *
     * @param address address to be added
     * @return address id
     */
    public int add(Address address)
    {
       return dao.add(address);
    }
    
    /**
     *
     * @param id address id
     * @param address address to be updated
     */
    public void update(int id, Address address)
    {
        // Eerst controleren of deze gebruiker wel bestaat
        Address oldAddress = get(id);
        
        dao.update(id, address);
    }
    
    /**
     *
     * @param id address id
     */
    public void delete(int id)
    {
        // Eerst controleren of deze gebruiker wel bestaat
        Address address = get(id);
        
        dao.delete(id);
    }
}
