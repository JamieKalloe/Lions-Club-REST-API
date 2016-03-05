/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ipsen3.service;

import java.util.Collection;
import nl.ipsen3.model.Address;
import nl.ipsen3.model.Merchant;
import nl.ipsen3.persistence.AddressDAO;
import nl.ipsen3.persistence.MerchantDAO;

/**
 *
 * @author Jamie
 */
public class MerchantService extends BaseService<Merchant>
{
    private final MerchantDAO dao;
    
    /**
     *
     * @param dao data acces object
     */
    public MerchantService(MerchantDAO dao)
    {
        this.dao = dao;
    }
    
    /**
     *
     * @return list of all merchants
     */
    public Collection<Merchant> getAll()
    {
        return dao.getAll();
    }
    
    /**
     *
     * @param id merchant id
     * @return merchant
     */
    public Merchant get(int id)
    {
        return requireResult(dao.get(id));
    }
    

}
