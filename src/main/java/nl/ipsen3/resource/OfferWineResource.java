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
    
     /**
     * @author Philip
     * creates a new instance of the resource, using the service
     * @param service OfferWineservice
     */
    public OfferWineResource(OfferWineService service)
    {
        this.service = service;
    }
    
     /**
     * @author Philip
     * @return list of all OfferWine objects
     */
    @GET
    @JsonView(View.Public.class)
    public Collection<OfferWine> retrieveAll()
    {
        return service.getAll();   
    }
    
     /**
     * @author Philip
     * @param id of offerWine
     * @return offerWine
     */
    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    public OfferWine retrieve(@PathParam("id") int id)
    {
        return service.get(id);
    }
    
     /**
     * @author Philip
     * @param offerWine OfferWine to be created
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Private.class)
    public void create(OfferWine offerWine)
    {
        service.add(offerWine);
    }
   
    /**
     * @author Philip
     * @param id OfferWine to be deleted
     */
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id)
    {
        service.delete(id);
    }
}