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
    
    public EventResource(EventService service)
    {
        this.service = service;
    }
    
    @GET
    @JsonView(View.Public.class)
    public Collection<Event> retrieveAll()
    {
        return service.getAll();
    }
    
    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    public Event retrieve(@PathParam("id") int id)
    {
        return service.get(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Private.class)
    public void create(Event event)
    {
        service.add(event);
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Private.class)
    public void update(@PathParam("id") int id, Event event)
    {
        service.update(id, event);
    }
    
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id)
    {
        service.delete(id);
    }
}