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
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import nl.ipsen3.View;
import nl.ipsen3.model.OfferWine;
import nl.ipsen3.service.OfferWineService;

/**
 *
 * @author Philip
 * @since 25-01-16
 */
@Path("/offerWines")
@Produces(MediaType.APPLICATION_JSON)
public class OfferWineResource
{
    private final OfferWineService service;
    
    public OfferWineResource(OfferWineService service)
    {
        this.service = service;
    }
    
    @GET
    @JsonView(View.Public.class)
    public Collection<OfferWine> retrieveAll()
    {
        return service.getAll();   
    }
    
    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    public OfferWine retrieve(@PathParam("id") int id)
    {
        return service.get(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Private.class)
    public void create(OfferWine offerWine)
    {
        service.add(offerWine);
    }
   
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id)
    {
        service.delete(id);
    }
}