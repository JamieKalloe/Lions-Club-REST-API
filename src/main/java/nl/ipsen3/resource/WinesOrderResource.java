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
import nl.ipsen3.model.WineOrder;
import nl.ipsen3.service.WinesOrderService;

/**
 *
 * @author Jamie
 */
@Path("/wineorders")
@Produces(MediaType.APPLICATION_JSON)
public class WinesOrderResource
{
    private final WinesOrderService service;
    
    public WinesOrderResource(WinesOrderService service)
    {
        this.service = service;
    }
    
    @GET
    @JsonView(View.Public.class)
    public Collection<WineOrder> retrieveAll()
    {
        return service.getAll();
    }
    
    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    public WineOrder retrieve(@PathParam("id") int id)
    {
        return service.get(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Private.class)
    public void create(WineOrder wineOrder)
    {
        service.add(wineOrder);
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Private.class)
    public void update(@PathParam("id") int id, WineOrder wineOrder)
    {
        service.update(id, wineOrder);
    }
    
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id)
    {
        service.delete(id);
    }
}