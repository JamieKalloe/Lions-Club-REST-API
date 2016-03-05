package nl.ipsen3.model;

import com.fasterxml.jackson.annotation.JsonView;
import nl.ipsen3.View;


/**
 * Created by Philip on 20-01-16.
 */
public class Merchant{
    
     @JsonView(View.Public.class)
    private int id, addressId;
    
    @JsonView(View.Public.class)
    private String name, email;
    
    /**
     * new instance of merchant
     */
    public Merchant(){}
       
    /**
     *
     * @param id merchant id
     */
    public Merchant(int id) {
        this.id = id;
    }
        
    /**
     *
     * @return merchant id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return merchant name
     */
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
    public int getAddressId() {
        return this.addressId;
    }
    
    /**
     *
     * @param id
     */
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
     * @param addressId
     */
    public void setAddressId(int addressId) {
        this.addressId = addressId;
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