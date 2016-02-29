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
    
    public Wine() {}
   
    private WineType type;
    
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
    
    public boolean checkIfOnlyID() {
        return this.type == null && this.name == null && this.country == null && this.region == null && this.year == 0 && this.purchasePrice == 0 && this.price == 0 && this.merchant == null && this.typeName == null;
    }

    
    public int getId() {
        return this.id;
    }
    
    public int getOfferId() {
        return this.offerId;
    }
    
    public Merchant getMerchant() {
        return new Merchant(this.merchantId);
    }
    
    public WineType getType() {
        return new WineType(this.typeId);
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

   public void setTypeId(int typeId){
       this.typeId = typeId;
   }
   
   public void setType(WineType type){
       this.type = type;
   }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
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

    public void setOfferId(int offerId) {
        this.offerId = offerId;
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