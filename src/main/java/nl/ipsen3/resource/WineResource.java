
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
import nl.ipsen3.service.WineService;

/** 
 * @author Philip Wong
 * @since 19-01-16
 */
@Path("/wines")
@Produces(MediaType.APPLICATION_JSON)
public class WineResource
{
    private final WineService service;
    
     /**
     * @author Philip
     * creates a new instance of the resource, using the service
     * @param service WineService
     */
    public WineResource(WineService service)
    {
        this.service = service;
    }
    
    /**
     * @author Philip
     * @return list of all Wine objects
     */
    @GET
    @JsonView(View.Public.class)
    public Collection<Wine> retrieveAll()
    {
        return service.getAll();
    }
    
    /**
     * @author Philip
     * @param offerId id of offer
     * @return list of all Wine objects from this offer
     */
    @GET
    @Path("/offer/{id}")
    @JsonView(View.Public.class)
    public Collection<Wine> retrieveAllForOffer(@PathParam("id") int offerId)
    {
        return service.getAllForOffer(offerId);
    }
    
    /**
     * @author Philip
     * @param id id of wine to get
     * @return Wine 
     */
    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    public Wine retrieve(@PathParam("id") int id)
    {
        return service.get(id);
    }
    
    /**
     * @author Philip
     * @param wine wine to be created
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Private.class)
    public void create(Wine wine)
    {
        service.add(wine);
    }
    
    /**
     * @author Philip
     * @param id id of wine to be updated
     * @param wine wine to be updated
     */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Private.class)
    public void update(@PathParam("id") int id, Wine wine)
    {
        service.update(id, wine);
    }
    
    /**
     * @author Philip
     * @param id id of wine to be deleted
     */
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id)
    {
        service.delete(id);
    }
}
