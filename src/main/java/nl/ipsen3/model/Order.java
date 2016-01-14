/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.IPSEN3.model;

import nl.ipsen3.model.User;
import com.fasterxml.jackson.annotation.JsonView;
import java.util.ArrayList;
import nl.ipsen3.View;

/**
 *
 * @author Jamie
 */
public class Order {
    
    private int id;
    
    @JsonView(View.Public.class)
    private User user;
    
    @JsonView(View.Public.class)
    private OrderStatus orderStatus;
    
    @JsonView(View.Public.class)
    private ArrayList<Wine> wines;

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public ArrayList<Wine> getWines() {
        return wines;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setWines(ArrayList<Wine> wines) {
        this.wines = wines;
    }  
}
