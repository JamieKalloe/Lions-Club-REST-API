/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ipsen3.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import nl.ipsen3.database.Database;
import nl.ipsen3.model.Attendee;

/**
 *
 * @author Jamie
 */
public class AttendeeDAO {
    
    private final List<Attendee> attendees;
    private final Database databaseInstance;
    
    public AttendeeDAO() {
        this.databaseInstance = Database.getInstance();
        this.attendees = getAllFromDatabase();
    }
    
    public List<Attendee> getAll() {
        return this.attendees;
    }
    
    public Attendee get(int userId) {
        try {
            for(Attendee attendee : attendees) {
                if(attendee.getUserId() == userId) {
                    return attendee;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        
        return null;
    }
    
    public void add(Attendee attendee) {
        attendee = this.addAttendeeToDatabase(attendee);
        attendees.add(attendee);
    }
    
    public void update(int userId, Attendee attendee) {
        Attendee oldAttendee = this.get(userId);
        attendee.setUserId(userId);
        this.updateAttendeeFromDatabase(oldAttendee);
        int idInList = attendees.indexOf(oldAttendee);
        attendees.set(idInList, attendee);
    }
    
    public void delete(int userId) {
        Attendee attendee = this.get(userId);
        this.removeAttendeeFromDatabase(userId);
        attendees.remove(attendee);
    }
    
    private List<Attendee> getAllFromDatabase() {
        List<Attendee> attendeeList = new ArrayList<>();
        ResultSet results = databaseInstance.select("attendee");
        
        try {
            while(results.next()) {
                Attendee attendee = new Attendee();
                attendee.setEventId(results.getInt("event_id"));
                attendee.setUserId(results.getInt("guest_id"));
                
                if(results.getInt("attended") == 1) {
                    attendee.setAttended(true);
                } else {
                    attendee.setAttended(false);
                }
                
                attendeeList.add(attendee);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return attendeeList;
    }
    
    private Attendee addAttendeeToDatabase(Attendee attendee) {
        HashMap databaseData = new HashMap();
        
        databaseData.put("guest_id", attendee.getUserId());
        databaseData.put("event_id", attendee.getEventId());
        
        if(attendee.isAttended()) {
            databaseData.put("attended", 1);
            
        } else {
            databaseData.put("attended", 0);
        }
        
        int id = databaseInstance.insertInto("attendee", databaseData);
        //set id?
        
        return attendee;
    }
    
    private void updateAttendeeFromDatabase(Attendee attendee) {
        HashMap databaseData = new HashMap();
        
        databaseData.put("guest_id", attendee.getUserId());
        databaseData.put("event_id", attendee.getEventId());
        
        if(attendee.isAttended()) {
            databaseData.put("attended", 1);
            
        } else {
            databaseData.put("attended", 0);
        }
        
        databaseInstance.update("attendee", "guest_id=" + databaseData.get("guest_id"), databaseData);
    }
    
    private void removeAttendeeFromDatabase(int id) {
        databaseInstance.delete("attendee", "guest_id=" + id);
    }
}
