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


    public String getName() {
        return name;
    }


    /**
     * Gets email.
     *
     * @return the email
     */

    public String getEmail() {
        return email;
    }


    /**
     * Gets address.
     *
     * @return the address
     */

    public Address getAddress() {
        return address;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */

    public void setName(String name) {
        this.name = name;
    }

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
}
