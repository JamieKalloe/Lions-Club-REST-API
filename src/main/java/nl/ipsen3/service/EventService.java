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
    
    public EventService(EventDAO dao) {
        this.dao = dao;
    }
    
    public Collection<Event> getAll(){
        return dao.getAll();
    }
    
    public Event get(int id) {
        return requireResult(dao.get(id));
    }
    
    public void add(Event event) {
        dao.add(event);
    }
    
    public void update(int id, Event event) {
        Event oldEvent = get(id);
        
        dao.update(id, event);
    }
    
    public void delete(int id) {
        dao.delete(id);
    }
    
}
