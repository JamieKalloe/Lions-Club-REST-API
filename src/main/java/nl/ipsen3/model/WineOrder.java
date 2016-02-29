/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ipsen3.model;

import com.fasterxml.jackson.annotation.JsonView;
import nl.ipsen3.model.Wine;
import javafx.beans.property.SimpleStringProperty;
import nl.ipsen3.View;

/**
 * 
 */
public class WineOrder {

    @JsonView(View.Public.class)
    private int orderID, amount;

    private Wine wine;
    private SimpleStringProperty name = new SimpleStringProperty("");

   

    /**
     * Instantiates a new Wine order.
     *
     * @param wineID the wine id
     * @param amount the amount
     */
    public WineOrder(int wineID, int amount)
    {
        this.wine = new Wine(wineID);
        this.amount = amount;
    }

    /**
     * Instantiates a new Wine order.
     *
     * @param orderID the order id
     * @param wineID  the wine id
     * @param amount  the amount
     */
    public WineOrder(int orderID, int wineID, int amount)
    {
        this.wine = new Wine(wineID);
        this.amount = amount;
    }

    public WineOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Gets order id.
     *
     * @return the order id
     */
    public int getOrderID()
    {
        return orderID;
    }

    /**
     * Gets wine.
     *
     * @return the wine
     */
    public Wine getWine()
    {
        return wine;
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public int getAmount()
    {
        return amount;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName()
    {
        return wine.getName();
    }

    /**
     * Sets order id.
     *
     * @param orderID the order id
     */
    public void setOrderID(int orderID)
    {
        this.orderID = orderID;
    }

    /**
     * Sets wine.
     *
     * @param wine the wine
     */
    public void setWine(Wine wine)
    {
        this.wine = wine;
    }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(int amount)
    {
        this.amount = amount;
    }

}

