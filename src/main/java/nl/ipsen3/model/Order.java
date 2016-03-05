/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ipsen3.model;

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
    private int id, userId, offerId;
    
    @JsonView(View.Public.class)
    private int orderStatus;
    

    private ArrayList<Wine> wines;
    
    
    private double totalAmount;
    
    @JsonView(View.Public.class)
    private Date date;
    
    private Offer offer;
    
    private ArrayList<WineOrder> wineOrders;
    
    /**
     * new order
     */
    public Order() {
        
    }
    
    /**
     *
     * @param id order id
     * @param userId user id
     * @param orderStatusId order status id
     */
    public Order(int id, int userId, int orderStatusId) {
        this.id = id;
        this.userId = userId;
        this.orderStatus = orderStatusId;
        this.totalAmount = 0;
        this.wines = null;
        this.date = new Date();
        
    }

    /**
     *
     * @return total amout
     */
    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     *
     * @return date
     */
    public Date getDate() {
        return date;
    }
    
    /**
     *
     * @return order d
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     *
     * @return order status id
     */
    public int getOrderStatus() {
        return orderStatus;
    }

    /**
     *
     * @return arraylist wines
     */
    public ArrayList<Wine> getWines() {
        return wines;
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
     * @return order
     */
    public Offer getOffer() {
       return this.offer;
    }

    /**
     *
     * @param id sets the order id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param userId sets the user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     *
     * @param orderStatus sets the order status id
     */
    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     *
     * @param wines sets the wines
     */
    public void setWines(ArrayList<Wine> wines) {
        this.wines = wines;
    }
    
    /**
     *
     * @param wineOrders sets the wine orders
     */
    public void setWineOrders(ArrayList<WineOrder> wineOrders) {
        this.wineOrders = wineOrders;
        double total = 0.0;
        for (WineOrder order : wineOrders)
        {
            total += order.getAmount() * order.getWine().getPrice();
        }
        this.totalAmount = total;
    }
    
    /**
     *
     * @return gets the wine orders
     */
    public ArrayList<WineOrder> getWineOrders() {
        return this.wineOrders;
    }

    /**
     *
     * @param totalAmount gets the total amount
     */
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     *
     * @param date gets the date
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
    /**
     *
     * @param offerId gets the offer id
     */
    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }
}
