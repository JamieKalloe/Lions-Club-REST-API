/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ipsen3.model;

import com.fasterxml.jackson.annotation.JsonView;
import nl.ipsen3.View;

/**
 *
 * @author Jamie
 */
public class Address {
    
    @JsonView(View.Public.class)
    private int id;
    
    @JsonView(View.Public.class)
    private String zipCode, street, houseNumber, country, city;
    
    public Address(int id, String zipCode, String street, String houseNumber, String country, String city) {
        this.id = id;
        this.zipCode = zipCode;
        this.street = street;
        this.houseNumber = houseNumber;
        this.country = country;
        this.city = city;
    }
    
    public Address(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
