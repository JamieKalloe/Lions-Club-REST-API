
package nl.ipsen3;

import io.dropwizard.Application;
import io.dropwizard.ConfiguredBundle;
import io.dropwizard.bundles.assets.ConfiguredAssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import nl.ipsen3.database.Database;
import nl.ipsen3.persistence.AddressDAO;
import nl.ipsen3.persistence.OrderDAO;
import nl.ipsen3.persistence.OfferDAO;
import nl.ipsen3.persistence.UserDAO;
import nl.ipsen3.persistence.WineDAO;
import nl.ipsen3.resource.AddressResource;
import nl.ipsen3.resource.OfferResource;
import nl.ipsen3.resource.OrderResource;
import nl.ipsen3.resource.OfferResource;
import nl.ipsen3.resource.UserResource;
import nl.ipsen3.resource.WineResource;
import nl.ipsen3.service.AddressService;
import nl.ipsen3.service.OfferService;
import nl.ipsen3.service.OrderService;
import nl.ipsen3.service.UserService;
import nl.ipsen3.service.WineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author 
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
        bootstrap.addBundle((ConfiguredBundle) new ConfiguredAssetsBundle("/Lions-Client", "/", "index.html"));
    }
    
    
    @Override
    public void run(ApiConfiguration configuration, Environment environment)
    {
        name = configuration.getApiName();
        Database.getInstance(configuration);
        
        logger.info(String.format("Set API name to %s", name));
        
        UserDAO userDAO = new UserDAO();
        WineDAO wineDAO = new WineDAO();
        OrderDAO orderDAO = new OrderDAO();
        AddressDAO addressDAO = new AddressDAO();
        OfferDAO offerDAO = new OfferDAO();
        
        UserService userService = new UserService(userDAO);
        WineService wineService = new WineService(wineDAO);
        OrderService orderService = new OrderService(orderDAO);
        AddressService addressService = new AddressService(addressDAO);
        OfferService offerService = new OfferService(offerDAO);
        
        UserResource userResource = new UserResource(userService);
        WineResource wineResource = new WineResource(wineService);
        OrderResource orderResource = new OrderResource(orderService);
        AddressResource addressResource = new AddressResource(addressService);
        OfferResource offerResource = new OfferResource(offerService);
        
        environment.jersey().register(userResource);
        environment.jersey().register(wineResource);
        environment.jersey().register(orderResource);
        environment.jersey().register(addressResource);
        environment.jersey().register(offerResource);
    }
    
    public static void main(String[] args) throws Exception
    {
        new ApiApplication().run(args);
    }
}
