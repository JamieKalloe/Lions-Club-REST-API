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
import nl.ipsen3.model.Event;

/**
 *
 * @author Jamie
 */
public class EventDAO {
    
    private final List<Event> events;
    private final Database databaseInstance;
    
    /**
     * creates a new instance of the dao
     */
    public EventDAO() {
        this.databaseInstance = Database.getInstance();
        this.events = getAllFromDatabase();
    }
    
    /**
     *
     * @return list of all events
     */
    public List<Event> getAll() {
        return this.events;
    }
    
    /**
     *
     * @param id event id
     * @return event object
     */
    public Event get(int id) {
        try {
            for(Event event : events) {
                if(event.getId() == id) {
                    return event;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        
        return null;
    }
    
    /**
     *
     * @param event event to be added
     */
    public void add(Event event) {
        event = this.addEventToDatabase(event);
        events.add(event);
    }
    
    /**
     *
     * @param id event id
     * @param event event to be updated
     */
    public void update(int id, Event event) {
        Event oldEvent = this.get(id);
        event.setId(id);
        this.updateEventFromDatabase(oldEvent);
        int idInList = events.indexOf(oldEvent);
        events.set(idInList, event);
    }
    
    /**
     *
     * @param id event id
     */
    public void delete(int id) {
        Event event = this.get(id);
        this.removeEventFromDatabase(event);
        events.remove(event);
    }
    
    private List<Event> getAllFromDatabase() {
        List<Event> eventList = new ArrayList<>();
        ResultSet results = databaseInstance.select("event");
        AddressDAO dao = new AddressDAO();
        
        try {
            while(results.next()) {
                Event event = new Event(
                        results.getInt("id"), 
                        results.getString("name"), 
                        dao.get(results.getInt("address_id")), 
                        results.getDate("start_date"), 
                        results.getDate("end_date")
                );
                
                eventList.add(event);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        
        return eventList;
    }
    
    private Event addEventToDatabase(Event event) {
        HashMap databaseData = new HashMap();
        
        databaseData.put("id", event.getId());
        databaseData.put("address_id", event.getAddress().getId());
        databaseData.put("name", event.getName());
        databaseData.put("start_date", event.getStartDate());
        databaseData.put("end_date", event.getEndDate());
        
        int id = databaseInstance.insertInto("event", databaseData);
        event.setId(id);
        
        return event;
    }
    
    private void updateEventFromDatabase(Event event) {
        HashMap databaseData = new HashMap();
        
        databaseData.put("address_id", event.getAddress().getId());
        databaseData.put("name", event.getName());
        databaseData.put("start_date", event.getStartDate());
        databaseData.put("end_date", event.getEndDate());
        
        databaseInstance.update("event", event.getId(), databaseData);
    }
    
    private void removeEventFromDatabase(Event event) {
        databaseInstance.delete("event", event.getId());
    }
    
    
}
