/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ipsen3.service;

import java.util.Collection;
import nl.ipsen3.model.Attendee;
import nl.ipsen3.persistence.AttendeeDAO;

/**
 *
 * @author Jamie
 */
public class AttendeeService extends BaseService<Attendee> {
    
    private final AttendeeDAO dao;
    
    /**
     *
     * @param dao data acces object
     */
    public AttendeeService(AttendeeDAO dao) {
        this.dao = dao;
    }
    
    /**
     *
     * @return list of all attendees
     */
    public Collection<Attendee> getAll() {
        return dao.getAll();
    }
    
    /**
     *
     * @param userId user id
     * @return attendee
     */
    public Attendee get(int userId) {
        return requireResult(dao.get(userId));
    }
    
    /**
     *
     * @param attendee attendee to be added
     */
    public void add(Attendee attendee) {
        dao.add(attendee);
    }
    
    /**
     *
     * @param userId user id
     * @param attendee attendee to be updated
     */
    public void update(int userId, Attendee attendee) {
        dao.update(userId, attendee);
    }
    
    /**
     *
     * @param userId user id
     */
    public void delete(int userId) {
        dao.delete(userId);
    } 
    
}
