/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.IPSEN3.model;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.ArrayList;
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
    
    @JsonView(View.Public.class)
    private ArrayList<Wine> wines;
    
    public Offer(int id) {
        this.name = null;
        this.startDate = null;
        this.endDate = null;
        this.wines = null;
    }
    
    public Offer(int id, String name, Date startDate, Date endDate, ArrayList<Wine> wines) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.wines = wines;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public ArrayList<Wine> getWines() {
        return wines;
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

    public void setWines(ArrayList<Wine> wines) {
        this.wines = wines;
    }
}