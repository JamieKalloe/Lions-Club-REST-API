/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ipsen3.model;

/**
 *
 * @author Jamie
 */
public class Attendee {
    
    private int userId;
    private int eventId;
    private boolean attended;
    
    /**
     * New instance of Attendee
     */
    public Attendee() {
        
    }
    
    /**
     *
     * @param eventId int id
     */
    public Attendee(int eventId) {
        this.eventId = eventId;
    }

    /**
     *
     * @return int id
     */
    public int getUserId() {
        return userId;
    }

    /**
     *
     * @param guestId int id
     */
    public void setUserId(int guestId) {
        this.userId = guestId;
    }

    /**
     *
     * @return int id
     */
    public int getEventId() {
        return eventId;
    }

    /**
     *
     * @param eventId sets the id
     */
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    /**
     *
     * @return gets the attended value
     */
    public boolean isAttended() {
        return attended;
    }

    /**
     *
     * @param attended sets the  attended value
     */
    public void setAttended(boolean attended) {
        this.attended = attended;
    }
    
    
}
