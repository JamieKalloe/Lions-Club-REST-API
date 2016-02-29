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

    @JsonView(View.Public.class)
    private int wineId;

    @JsonView(View.Public.class)
    private int amount;

    /**
     * Instantiates a new Wine order.
     *
     * @param wineId the wine id
     * @param amount the amount
     */
    public WineOrder(int wineId, int amount)
    {
        this.wineId = wineId;
        this.amount = amount;
    }

    /**
     * Instantiates a new Wine order.
     *
     * @param orderId the order id
     * @param wineId  the wine id
     * @param amount  the amount
     */
    public WineOrder(int orderId, int wineId, int amount)
    {
        this.orderId = orderId;
        this.wineId = wineId;
        this.amount = amount;
    }

    /**
     * Gets order id.
     *
     * @return the order id
     */
    public int getOrderID()
    {
        return orderId;
    }

    /**
     * Gets wine.
     *
     * @return the wine
     */
    public int getWineId()
    {
        return wineId;
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
     * Sets order id.
     *
     * @param orderID the order id
     */
    public void setOrderID(int orderID)
    {
        this.orderId = orderID;
    }

    /**
     * Sets wine.
     *
     * @param wineId the wine
     */
    public void setWineId(int wineId)
    {
        this.wineId = wineId;
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

