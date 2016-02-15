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
    private int id, userId, offerId;
    
    @JsonView(View.Public.class)
    private OrderStatus orderStatus;
    
    @JsonView(View.Public.class)
    private ArrayList<Wine> wines;
    
    @JsonView(View.Public.class)
    private double totalAmount;
    
    @JsonView(View.Public.class)
    private Date date;
    
    private Offer offer;
    
    private ArrayList<WineOrder> wineOrders;
    
    public Order() {
        
    }
    
    public Order(int id, int userId, int orderStatusId) {
        this.id = id;
        this.userId = userId;
        this.orderStatus = new OrderStatus(orderStatusId);
        this.totalAmount = 0;
        this.wines = null;
        this.date = new Date();
        
    }

    public double getTotalAmount() {
        return totalAmount;
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

    public OrderStatus getOrderStatus() {
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

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setWines(ArrayList<Wine> wines) {
        this.wines = wines;
    }
    
    public void setWineOrders(ArrayList<WineOrder> wineOrders) {
        this.wineOrders = wineOrders;
        double total = 0.0;
        for (WineOrder order : wineOrders)
        {
            total += order.getAmount() * order.getWine().getPrice();
        }
        this.totalAmount = total;
    }
    
    public ArrayList<WineOrder> getWineOrders() {
        return this.wineOrders;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
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
