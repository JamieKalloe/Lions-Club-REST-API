/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.IPSEN3.model;

import com.fasterxml.jackson.annotation.JsonView;
import nl.ipsen3.View;

/**
 *
 * @author Jamie
 */
public class Wine {
    
    @JsonView(View.Public.class)
    private int id, year;
    
    @JsonView(View.Public.class)
    private WineType type;
    
    @JsonView(View.Public.class)
    private String name, country, region;
    
    @JsonView(View.Public.class)
    private double price;
    
    public Wine(int id) {
        this.id = id;
        this.type = null;
        this.name = null;
        this.country = null;
        this.region = null;
        this.year = 0;
        this.price = 0;
    }
    
    public Wine(int id, WineType type, String name, String country, String region, int year, double price) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.country = country;
        this.region = region;
        this.year = year;
        this.price = price;
    }

    public int getId() {
        return this.id;
    }
    
    public WineType getType() {
        return this.type;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getCountry() {
        return this.country;
    }
    
    public String getRegion() {
        return this.region;
    }
    
    public int getYear() {
        return this.year;
    }
    
    public double getPrice(){
        return this.price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(WineType type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
