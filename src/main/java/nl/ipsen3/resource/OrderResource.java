/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.ipsen3.resource;

import com.fasterxml.jackson.annotation.JsonView;
import com.itextpdf.text.DocumentException;
import generators.InvoiceGenerator;
import java.io.IOException;
import java.util.ArrayList;
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
import nl.ipsen3.model.Order;
import nl.ipsen3.View;
import nl.ipsen3.service.OrderService;

/**
 *
 * @author Jamie
 */
@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
public class OrderResource
{
    private final OrderService service;
    
    public OrderResource(OrderService service)
    {
        this.service = service;
    }
    
    @GET
    @JsonView(View.Public.class)
    public Collection<Order> retrieveAll()
    {
        //test code
        Collection<Order> orders = service.getAll();
        for(Order order : orders) {
            try {
                new InvoiceGenerator().generate(order);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return service.getAll();
    }
    
    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    public Order retrieve(@PathParam("id") int id)
    {
        return service.get(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Private.class)
    public void create(Order order)
    {
        service.add(order);
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Private.class)
    public void update(@PathParam("id") int id, Order order)
    {
        service.update(id, order);
    }
    
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id)
    {
        service.delete(id);
    }
}