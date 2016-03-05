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
    
    /**
     * New instance of address
     */
    public Address() {}
    
    /**
     *
     * @param id int id
     * @param zipCode string zipcode
     * @param street string street
     * @param houseNumber string housenumber
     * @param country string country
     * @param city string city
     */
    public Address(int id, String zipCode, String street, String houseNumber, String country, String city) {
        this.id = id;
        this.zipCode = zipCode;
        this.street = street;
        this.houseNumber = houseNumber;
        this.country = country;
        this.city = city;
    }
    
    /**
     *
     * @param id address id
     */
    public Address(int id) {
        this.id = id;
    }

    /**
     *
     * @return int id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return string zipcode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     *
     * @return string street
     */
    public String getStreet() {
        return street;
    }

    /**
     *
     * @return string housenumber
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     *
     * @return string country
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @return sttring city
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param id sets the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param zipCode sets the zipcode
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     *
     * @param street sets the street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     *
     * @param houseNumber sets the housenumbe
     */
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     *
     * @param country sets the country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @param city sets the city
     */
    public void setCity(String city) {
        this.city = city;
    }
}
