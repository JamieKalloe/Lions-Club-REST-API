/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ipsen3.model;

import nl.ipsen3.model.User;
import com.fasterxml.jackson.annotation.JsonView;
import java.util.ArrayList;
import java.util.Date;
import nl.ipsen3.View;

/**
 *
 * @author Jamie
 */
public class Order {
        
    @JsonView(View.Public.class)
    private int id, userId, offerId, orderStatus;
    

    private ArrayList<Wine> wines;
    
//    @JsonView(View.Public.class)
//    private double totalAmount;
    

    private Date date;
    
    private Offer offer;
    
    public Order() {
        
    }
    
    public Order(int id, int userId, int orderStatusId) {
        this.id = id;
        this.userId = userId;
        this.orderStatus = orderStatusId;
        this.wines = null;
        this.date = new Date();
        
    }
    
    public Date getDate() {
        return date;
    }
    
    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public ArrayList<Wine> getWines() {
        return wines;
    }
    
    public int getOfferId() {
       return this.offerId;
    }
     
    public Offer getOffer() {
       return this.offer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setWines(ArrayList<Wine> wines) {
        this.wines = wines;
    }  

    public void setDate(Date date) {
        this.date = date;
    }
    
     public void setOfferId(int offerId) {
        this.offerId = offerId;
    }
     
      public void setOfferId(Offer offerId) {
        this.offer = offer;
    }
}
