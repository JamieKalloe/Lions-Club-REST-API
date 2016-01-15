
package nl.ipsen3;

import io.dropwizard.Application;
import io.dropwizard.ConfiguredBundle;
import io.dropwizard.bundles.assets.ConfiguredAssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import nl.ipsen3.database.Database;
import nl.ipsen3.persistence.UserDAO;
import nl.ipsen3.resource.UserResource;
import nl.ipsen3.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Peter van Vliet
 */
public class ApiApplication extends Application<ApiConfiguration>
{
    private final Logger logger = LoggerFactory.getLogger(ApiApplication.class);
    
    private String name;
    
    @Override
    public String getName()
    {
        return name;
    }
    
      @Override
    public void initialize(Bootstrap<ApiConfiguration> bootstrap)
    {
        bootstrap.addBundle((ConfiguredBundle) new ConfiguredAssetsBundle("/Lions-Client", "", "index.html"));
    }
    
    
    @Override
    public void run(ApiConfiguration configuration, Environment environment)
    {
        name = configuration.getApiName();
        Database.getInstance(configuration);
        
        logger.info(String.format("Set API name to %s", name));
        
        UserDAO userDAO = new UserDAO();
        UserService userService = new UserService(userDAO);
        UserResource userResource = new UserResource(userService);
        
        environment.jersey().register(userResource);
    }
    
    public static void main(String[] args) throws Exception
    {
        new ApiApplication().run(args);
    }
}
