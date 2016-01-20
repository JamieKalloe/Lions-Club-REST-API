<<<<<<< HEAD
package nl.ipsen3.model;

import com.fasterxml.jackson.annotation.JsonView;
import nl.ipsen3.View;


/**
 * Created by Philip on 20-01-16.
 */
public class Merchant{
    
     @JsonView(View.Public.class)
    private int id;
    
    @JsonView(View.Public.class)
    private String name, email;
    
    @JsonView(View.Public.class)
    private Address address;

     public Merchant(int id) {
        this.id = id;
    }
    
     
    public int getId() {
        return id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
=======
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

>>>>>>> 8431469c62f22cafcbd03b84a9df8a234736bb73
    public String getName() {
        return name;
    }

<<<<<<< HEAD
    /**
     * Gets email.
     *
     * @return the email
     */
=======
>>>>>>> 8431469c62f22cafcbd03b84a9df8a234736bb73
    public String getEmail() {
        return email;
    }

<<<<<<< HEAD
    /**
     * Gets address.
     *
     * @return the address
     */
=======
>>>>>>> 8431469c62f22cafcbd03b84a9df8a234736bb73
    public Address getAddress() {
        return address;
    }
    
<<<<<<< HEAD
    
=======
>>>>>>> 8431469c62f22cafcbd03b84a9df8a234736bb73
    public void setId(int id) {
        this.id = id;
    }

<<<<<<< HEAD

    /**
     * Sets name.
     *
     * @param name the name
     */
=======
>>>>>>> 8431469c62f22cafcbd03b84a9df8a234736bb73
    public void setName(String name) {
        this.name = name;
    }

<<<<<<< HEAD

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }
=======
    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
>>>>>>> 8431469c62f22cafcbd03b84a9df8a234736bb73
}
