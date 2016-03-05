/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ipsen3.resource;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import nl.ipsen3.View;
import nl.ipsen3.model.Attendee;
import nl.ipsen3.model.Event;
import nl.ipsen3.service.AttendeeService;
import nl.ipsen3.service.EventService;

/**
 *
 * @author Jamie
 */
@Path("/attendees")
@Produces(MediaType.APPLICATION_JSON)
public class AttendeeResource
{
    private final AttendeeService service;
    
    /**
     * creates a new instance of the resource, using the service
     * @param service
     */
    public AttendeeResource(AttendeeService service)
    {
        this.service = service;
    }
    
    /**
     *
     * @return list of all attendees
     */
    @GET
    @JsonView(View.Public.class)
    public Collection<Attendee> retrieveAll()
    {
        return service.getAll();
    }
    
    /**
     *
     * @param id attendee id
     * @return attendee
     */
    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    public Attendee retrieve(@PathParam("id") int id)
    {
        return service.get(id);
    }
    
    /**
     *
     * @param attendee attendee to be added
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Private.class)
    public void create(Attendee attendee)
    {
        service.add(attendee);
    }
    
    /**
     *
     * @param id attendee id
     * @param attendee attendee to be updated
     */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Private.class)
    public void update(@PathParam("id") int id, Attendee attendee)
    {
        service.update(id, attendee);
    }
    
    /**
     *
     * @param id attendee id
     */
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id)
    {
        service.delete(id);
    }
}