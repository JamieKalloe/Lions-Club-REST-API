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
    
    private int guestId;
    private int eventId;
    private boolean attended;
    
    public Attendee() {
        
    }
    
    public Attendee(int eventId) {
        this.eventId = eventId;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }
    
    
}
