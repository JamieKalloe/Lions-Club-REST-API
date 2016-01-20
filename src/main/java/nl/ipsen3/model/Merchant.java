/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ipsen3.model;

import nl.IPSEN3.model.Address;

/**
 *
 * @author Jamie
 */
public class Merchant {
    private String name;
    private String email;
    private Address address;
    private int id;
    
    public Merchant(int id, String name, String email, int  addressId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = new Address(addressId);
    }
    
    public Merchant(int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
