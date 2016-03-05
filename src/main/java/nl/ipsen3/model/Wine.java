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
public class Wine {
    
    @JsonView(View.Public.class)
    private int id, year, typeId, merchantId, offerId;
      
    @JsonView(View.Public.class)
    private String name, country, region;
    
    @JsonView(View.Public.class)
    private double price;

    private Merchant merchant;
    
    /**
     * new instance of wine
     */
    public Wine() {}
   
    private WineType type;
    
    /**
     *
     * @param id wine id
     */
    public Wine(int id) {
        this.id = id;
        this.type = null;
        this.name = null;
        this.country = null;
        this.region = null;
        this.merchant = null;
        this.year = 0;
        this.price = 0;
    }
    
    /**
     *
     * @return wine id
     */
    public int getId() {
        return this.id;
    }
    
    /**
     *
     * @return offer id
     */
    public int getOfferId() {
        return this.offerId;
    }
    
    /**
     *
     * @return merchant
     */
    public Merchant getMerchant() {
        return new Merchant(this.merchantId);
    }
    
    /**
     *
     * @return wine type
     */
    public WineType getType() {
        return new WineType(this.typeId);
    }
    
    /**
     *
     * @return wine name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     *
     * @return wine country
     */
    public String getCountry() {
        return this.country;
    }
    
    /**
     *
     * @return wine region
     */
    public String getRegion() {
        return this.region;
    }
    
    /**
     *
     * @return wine year
     */
    public int getYear() {
        return this.year;
    }
    
    /**
     *
     * @return wine price
     */
    public double getPrice(){
        return this.price;
    }
    
    /**
     *
     * @param id sets the wine id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param typeId sets the wine type id
     */
    public void setTypeId(int typeId){
       this.typeId = typeId;
   }
   
    /**
     *
     * @param type sets the type
     */
    public void setType(WineType type){
       this.type = type;
   }

    /**
     *
     * @param name sets the name
     */
    public void setName(String name) {
        this.name = name;
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
     * @param merchantId sets the merchant id
     */
    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }
        /**
     * Sets merchant.
     *
     * @param merchant the merchant
     */
    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    /**
     *
     * @param offerId sets the offer id
     */
    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }
    
    /**
     *
     * @param region sets the region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     *
     * @param year sets the year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     *
     * @param price sets the price
     */
    public void setPrice(double price) {
        this.price = price;
    }
}