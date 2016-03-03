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
    
    public AttendeeService(AttendeeDAO dao) {
        this.dao = dao;
    }
    
    public Collection<Attendee> getAll() {
        return dao.getAll();
    }
    
    public Attendee get(int userId) {
        return requireResult(dao.get(userId));
    }
    
    public void add(Attendee attendee) {
        dao.add(attendee);
    }
    
    public void update(int userId, Attendee attendee) {
        dao.update(userId, attendee);
    }
    
    public void delete(int userId) {
        dao.delete(userId);
    } 
    
}
