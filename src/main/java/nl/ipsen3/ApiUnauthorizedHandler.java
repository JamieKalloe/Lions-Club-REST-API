package nl.ipsen3;

import io.dropwizard.auth.UnauthorizedHandler;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Philip Wong
 */
public class ApiUnauthorizedHandler implements UnauthorizedHandler
{
    @Override
    public Response buildResponse(String prefix, String realm)
    {
        return Response.status(Response.Status.UNAUTHORIZED)
            .type(MediaType.TEXT_PLAIN_TYPE)
            .entity("Credentials are required to access this resource.")
            .build();
    }
}
