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
    
    /**
     * New instance of Event
     */
    public Event() {
        
    }
    
    /**
     *
     * @param id event id
     */
    public Event(int id) {
        this.id = id;
        this.name = null;
        this.address = null;
        this.startDate = null;
        this.endDate = null;
    }
    
    /**
     *
     * @param id event id
     * @param name event name
     * @param address event address
     * @param startDate event start date
     * @param endDate event end date
     */
    public Event(int id, String name, Address address, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     *
     * @return event name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name sets the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return gets the event address
     */
    public Address getAddress() {
        return address;
    }

    /**
     *
     * @param address sets the event address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     *
     * @return gets the start date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     *
     * @param startDate sets the start date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     *
     * @return gets the end date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     *
     * @param endDate sets the end date
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     *
     * @return gets the event id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id sets te event id
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
