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
public class OrderStatus {
    
    @JsonView(View.Public.class)
    private int id;
    
    @JsonView(View.Public.class)
    private String name;
    
    /**
     *
     * @param id order status id
     */
    public OrderStatus(int id) {
        this.id = id;
        this.name = null;
    }
    
    /**
     *
     * @param id order status id
     * @param name order status name
     */
    public OrderStatus(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     *
     * @return order status id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return order status name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param id sets the order status id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param name sets the order status name
     */
    public void setName(String name) {
        this.name = name;
    }
}
