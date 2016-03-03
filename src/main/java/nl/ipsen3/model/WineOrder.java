/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ipsen3.model;

import com.fasterxml.jackson.annotation.JsonView;
import nl.ipsen3.View;

/**
 * The Order status.
 * Date of creation: 15-10-15.
 *
 * @author Mike Bazuin
 */
public class WineOrder {

    @JsonView(View.Public.class)
    private int orderId;

    private Wine wine;
    
    @JsonView(View.Public.class)
    private int wineId;
    
    @JsonView(View.Public.class)
    private int amount;

    
    public WineOrder(){}
    /**
     * Instantiates a new Wine order.
     *
     * @param wineId the wine id
     * @param amount the amount
     */
    public WineOrder(int wineId, int amount)
    {
        this.wine = new Wine(wineId);
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

    /**
     * Gets order id.
     *
     * @return the order id
     */
    public int getOrderId()
    {
        return orderId;
    }
    
      /**
     * Gets order id.
     *
     * @return the order id
     */
    public int getWineId()
    {
        return wineId;
    }

    /**
     * Gets wineId.
     *
     * @return the wineId
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
     * @param orderId the order id
     */
    public void setOrderID(int orderId)
    {
        this.orderId = orderId;
    }
    
     /**
     * Sets wineId.
     *
     * @param wineId the wineId
     */
    public void setWineId(int wineId)
    {
        this.wineId = wineId;
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

