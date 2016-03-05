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
    private int id, isStarted;
    
    @JsonView(View.Public.class)
    private String name;
    
    @JsonView(View.Public.class)
    private Date startDate, endDate;
    
    /**
     * Instance of offer
     */
    public Offer() {}
    
    /**
     *
     * @param id offer id
     */
    public Offer(int id) {
        this.id = id;
        this.name = null;
        this.startDate = null;
        this.endDate = null;
    }
    
    /**
     *
     * @param id offer id
     * @param name offer name
     * @param startDate offer start date
     * @param endDate ofer end date
     */
    public Offer(int id, String name, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     *
     * @return offer id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return offer name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return offer start date
     */
    public Date getStartDate(){
          return startDate;
    }

    /**
     *
     * @return offer end date
     */
    public Date getEndDate(){
       
        return endDate;
    }
    
    /**
     *
     * @return offer istarted boolean
     */
    public int isStarted(){
       
        return isStarted;
    }

    /**
     *
     * @param id sets the offer id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param name sets the offer name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param startDate sets the offer start date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    
    }

    /**
     *
     * @param endDate sets the offer end date
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    /**
     *
     * @param isStarted sets the boolean istarted
     */
    public void setStarted(int isStarted) {
        this.isStarted = isStarted;
    }
    
}