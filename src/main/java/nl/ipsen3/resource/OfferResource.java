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
import nl.ipsen3.model.Offer;
import nl.ipsen3.service.OfferService;

/**
 *
 * @author Jamie
 */
@Path("/offers")
@Produces(MediaType.APPLICATION_JSON)
public class OfferResource
{
    private final OfferService service;
    
    /**
     * creates a new instance of the resource, using the service
     * @param service offer service
     */
    public OfferResource(OfferService service)
    {
        this.service = service;
    }
    
    /**
     *
     * @return list of all offers
     */
    @GET
    @JsonView(View.Public.class)
    public Collection<Offer> retrieveAll()
    {
        return service.getAll();   
    }
    
    /**
     *
     * @param id offer id
     * @return offer
     */
    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    public Offer retrieve(@PathParam("id") int id)
    {
        return service.get(id);
    }
    
    /**
     *
     * @param offer offer to be added
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Private.class)
    public void create(Offer offer)
    {
        service.add(offer);
    }
    
    /**
     *
     * @param id offer id
     * @param offer offer to be updated
     */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Private.class)
    public void update(@PathParam("id") int id, Offer offer)
    {
        service.update(id, offer);
    }
    
    /**
     *
     * @param id offer id
     */
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id)
    {
        service.delete(id);
    }
}