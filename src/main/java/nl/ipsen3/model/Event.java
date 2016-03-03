/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ipsen3.model;

import java.util.Date;

/**
 *
 * @author Jamie
 */
public class Event {
    
    //Variables
    private String name;
    private Address address;
    private Date startDate, endDate;
    private int id;
    
    public Event() {
        
    }
    
    public Event(int id) {
        this.id = id;
        this.name = null;
        this.address = null;
        this.startDate = null;
        this.endDate = null;
    }
    
    public Event(int id, String name, Address address, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
