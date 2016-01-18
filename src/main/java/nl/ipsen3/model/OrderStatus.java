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
public class OrderStatus {
    
    @JsonView(View.Public.class)
    private int id;
    
    @JsonView(View.Public.class)
    private String name;
    
    public OrderStatus(int id) {
        this.id = id;
        this.name = null;
    }
    
    public OrderStatus(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
