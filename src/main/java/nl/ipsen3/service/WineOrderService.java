/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.IPSEN3.service;

import java.util.ArrayList;
import java.util.HashMap;
import nl.IPSEN3.persistence.WineOrderDAO;
import nl.ipsen3.model.WineOrder;

/**
 *
 * @author Bernd
 */
public class WineOrderService {
    private final WineOrderDAO dao;
    private final WineService wineService;
    
    public WineOrderService() {
        this.dao = new WineOrderDAO();
        this.wineService = new WineService();
    }
    
    public ArrayList<WineOrder> all () {
        ArrayList<WineOrder> wineOrders = dao.all();
        for (WineOrder wineOrder : wineOrders) {
            if (wineOrder.getWine().checkIfOnlyID()) {
                wineOrder.setWine(wineService.find(wineOrder.getWine().getId()));
            }
        }
        return wineOrders;
    }
    
    public ArrayList<WineOrder> allForOrder(int orderID) {
        ArrayList<WineOrder> wineOrders = dao.find(orderID);
        for (WineOrder wineOrder : wineOrders) {
            wineOrder.setWine(wineService.find(wineOrder.getWine().getId()));
        }
        return wineOrders;
    }
    
    public int create(HashMap data) {
        return dao.create(data);
    }
    
    public void update (int wineOrderID, HashMap data) {
        dao.update(wineOrderID, data);
    }
    
    public void delete(int orderID, int WineID) {
        this.dao.delete(orderID, WineID);
    }

    
    
    
}
