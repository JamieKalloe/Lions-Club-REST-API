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
import nl.ipsen3.model.Address;
import nl.ipsen3.model.Merchant;
import nl.ipsen3.model.Offer;
import nl.ipsen3.model.Order;
import nl.ipsen3.service.AddressService;
import nl.ipsen3.service.MerchantService;
import nl.ipsen3.service.OrderService;

/**
 *
 * @author Philip Wong
 */
@Path("/merchants")
@Produces(MediaType.APPLICATION_JSON)
public class MerchantResource
{
    private final MerchantService service;
    
    public MerchantResource(MerchantService service)
    {
        this.service = service;
    }
    
    @GET
    @JsonView(View.Public.class)
    public Collection<Merchant> retrieveAll()
    {
        return service.getAll();
    }
    
    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    public Merchant retrieve(@PathParam("id") int id)
    {
        return service.get(id);
    }
     
}