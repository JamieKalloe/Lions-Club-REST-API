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
import nl.ipsen3.model.Event;
import nl.ipsen3.model.Order;
import nl.ipsen3.service.EventService;
import nl.ipsen3.service.OrderService;

/**
 *
 * @author Jamie
 */
@Path("/events")
@Produces(MediaType.APPLICATION_JSON)
public class EventResource
{
    private final EventService service;
    
    /**
     * creates a new instance of the resource, using the service
     * @param service event service
     */
    public EventResource(EventService service)
    {
        this.service = service;
    }
    
    /**
     *
     * @return list of all events
     */
    @GET
    @JsonView(View.Public.class)
    public Collection<Event> retrieveAll()
    {
        return service.getAll();
    }
    
    /**
     *
     * @param id event id
     * @return event
     */
    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    public Event retrieve(@PathParam("id") int id)
    {
        return service.get(id);
    }
    
    /**
     *
     * @param event event to be added
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Private.class)
    public void create(Event event)
    {
        service.add(event);
    }
    
    /**
     *
     * @param id event id
     * @param event event to be updated
     */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Private.class)
    public void update(@PathParam("id") int id, Event event)
    {
        service.update(id, event);
    }
    
    /**
     *
     * @param id event to be deleted
     */
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id)
    {
        service.delete(id);
    }
}