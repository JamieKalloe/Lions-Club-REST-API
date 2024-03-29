package nl.ipsen3.resource;

import com.fasterxml.jackson.annotation.JsonView;
import io.dropwizard.auth.Auth;
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
import nl.ipsen3.model.MailType;
import nl.ipsen3.persistence.MailFactory;
import nl.ipsen3.service.MailService;
import nl.ipsen3.View;
import nl.ipsen3.model.Address;
import nl.ipsen3.model.Mail;
import nl.ipsen3.model.User;
import nl.ipsen3.service.UserService;

/**
 * 
 * @author Jamie Kalloe
 * @since 12-01-16
 */
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource
{
    private final UserService service;
    
    /**
     * creates a new instance of the resource, using the service
     * @param service user serivce
     */
    public UserResource(UserService service)
    {
        this.service = service;
    }
    
    /**
     *
     * @return list of all users
     */
    @GET
    @JsonView(View.Public.class)
    public Collection<User> retrieveAll()
    {
        return service.getAll();
    }
    
    /**
     *
     * @param id user id
     * @return user
     */
    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
    public User retrieve(@PathParam("id") int id)
    {
        return service.get(id);
    }
    
    /**
     *
     * @param email email of user
     * @return int
     */
    @GET
    @Path("/email/{email}")
    @JsonView(View.Public.class)
    public int get(@PathParam("email") String email)
    {
        return service.checkIfEmailExists(email);
    }
    
    /**
     *
     * @param user user to be added
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Private.class)
    public void create(User user)
    {
        service.add(user);
    }
    

    @POST
    @Path("/email")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Private.class)
    public void sendMail(String email)
    {
        try {
            new nl.ipsen3.service.MailService().send(new Mail("ipsen2groep1@hotmail.com", email, "Vraag Lions Club"));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    

    /**
     *
     * @param id user id
     * @param user user to be updated
     */
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Private.class)
    public void update(@PathParam("id") int id, User user)
    {
        service.update(id, user);
    }
    
    /**
     *
     * @param user user to be updated (role)
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Private.class)
    public void update(User user)
    {
        service.updateRole(user);
    }
    
    /**
     *
     * @param id user id
     */
    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") int id)
    {
        service.delete(id);
    }
    
    /**
     *
     * @param authenticator auth
     * @return user
     */
    @GET
    @Path("/me")
    @JsonView(View.Private.class)
    public User authenticate(@Auth User authenticator)
    {
        return authenticator;
    }
}
