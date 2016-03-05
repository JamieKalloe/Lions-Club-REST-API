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
public class WineType {
    
    @JsonView(View.Public.class)
    private int id;
    
    @JsonView(View.Public.class)
    private String name;
    
    /**
     * new instance of wine type
     */
    public WineType() {
        
    }
    
    /**
     *
     * @param id wine type id
     */
    public WineType(int id) {
        this.id = id;
    }
    
    /**
     *
     * @return wine type id
     */
    public int getId() {
        return this.id;
    }
    
    /**
     *
     * @return wine type name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     *
     * @param id sets the wine type id
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     *
     * @param name sets the wine type name
     */
    public void setName(String name) {
        this.name = name;
    }
}
