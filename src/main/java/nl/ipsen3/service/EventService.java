/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ipsen3.service;

import java.util.Collection;
import nl.ipsen3.model.Event;
import nl.ipsen3.persistence.EventDAO;

/**
 *
 * @author Jamie
 */
public class EventService extends BaseService<Event> {
    
    private final EventDAO dao;
    
    /**
     *
     * @param dao data acces object
     */
    public EventService(EventDAO dao) {
        this.dao = dao;
    }
    
    /**
     *
     * @return list of all events
     */
    public Collection<Event> getAll(){
        return dao.getAll();
    }
    
    /**
     *
     * @param id event id
     * @return event
     */
    public Event get(int id) {
        return requireResult(dao.get(id));
    }
    
    /**
     *
     * @param event event to be added
     */
    public void add(Event event) {
        dao.add(event);
    }
    
    /**
     *
     * @param id event id
     * @param event event to be updated
     */
    public void update(int id, Event event) {
        Event oldEvent = get(id);
        
        dao.update(id, event);
    }
    
    /**
     *
     * @param id event id
     */
    public void delete(int id) {
        dao.delete(id);
    }
    
}
