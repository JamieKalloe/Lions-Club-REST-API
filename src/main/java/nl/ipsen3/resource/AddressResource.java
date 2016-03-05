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
import nl.ipsen3.service.AddressService;

/**
 *
 * @author Jamie
 */
@Path("/addresses")
@Produces(MediaType.APPLICATION_JSON)
public class AddressResource
{
    private final AddressService service;
    
    /**
     * creates a new instance of the resource using the service
     * @param service
     */
    public AddressResource(AddressService service)
    {
        this.service = service;
    }
    
    /**
     *
     * @return list of all addresses
     */
    @GET
    @JsonView(View.Public.class)
    public Collection<Address> retrieveAll()
    {
        return service.getAll();
    }
    
    /**
     *
     * @param id address id
     * @return address
     */
    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    public Address retrieve(@PathParam("id") int id)
    {
        return service.get(id);
    }
    
    /**
     *
     * @param address address to be added
     * @return int address id
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Private.class)
    public int create(Address address)
    {
       return service.add(address);
    }
    
    /**
     *
     * @param id address id
     * @param address address to be updated
     */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Private.class)
    public void update(@PathParam("id") int id, Address address)
    {
        service.update(id, address);
    }
    
    /**
     *
     * @param id address id
     */
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id)
    {
        service.delete(id);
    }
}