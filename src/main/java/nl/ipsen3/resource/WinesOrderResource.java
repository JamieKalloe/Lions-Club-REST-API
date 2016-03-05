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
import nl.ipsen3.model.Wine;
import nl.ipsen3.model.WineOrder;
import nl.ipsen3.service.WinesOrderService;

/**
 *
 * @author Jamie
 */
@Path("/wineOrders")
@Produces(MediaType.APPLICATION_JSON)
public class WinesOrderResource
{
    private final WinesOrderService service;
    
    /**
     * creates a new instance of the resource, using the service
     * @param service wine order service
     */
    public WinesOrderResource(WinesOrderService service)
    {
        this.service = service;
    }
    
    /**
     *
     * @return list of all wine orders
     */
    @GET
    @JsonView(View.Public.class)
    public Collection<WineOrder> retrieveAll()
    {
        return service.getAll();
    }
    
    /**
     *
     * @param id wine order id
     * @return wine order
     */
    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    public WineOrder retrieve(@PathParam("id") int id)
    {
        return service.get(id);
    }
    
    /**
     *
     * @param wineOrder wine order to be added
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Private.class)
    public void create(WineOrder wineOrder)
    {
        service.add(wineOrder);
    }
    
    /**
     *
     * @param id wine order id
     * @param wineOrder wine order to be updated
     */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Private.class)
    public void update(@PathParam("id") int id, WineOrder wineOrder)
    {
        service.update(id, wineOrder);
    }
    
    /**
     *
     * @param id wine order id
     */
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id)
    {
        service.delete(id);
    }
}