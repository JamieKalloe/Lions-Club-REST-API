/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ipsen3.model;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.Date;
import nl.ipsen3.View;

/**
 *
 * @author Jamie
 */
public class Offer {
    
    @JsonView(View.Public.class)
    private int id;
    
    @JsonView(View.Public.class)
    private String name;
    
    @JsonView(View.Public.class)
    private Date startDate, endDate;
    
    
    public Offer() {}
    
    public Offer(int id) {
        this.id = id;
        this.name = null;
        this.startDate = null;
        this.endDate = null;
    }
    
    public Offer(int id, String name, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate(){
          return startDate;
    }

    public Date getEndDate(){
       
        return endDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
       this.endDate = endDate;
    }
}