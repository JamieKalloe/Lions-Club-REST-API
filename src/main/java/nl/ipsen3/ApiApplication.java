
package nl.ipsen3;

import io.dropwizard.Application;
import io.dropwizard.ConfiguredBundle;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.bundles.assets.ConfiguredAssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import java.util.EnumSet;
import javax.servlet.DispatcherType;
import nl.ipsen3.database.Database;
import nl.ipsen3.model.User;
import nl.ipsen3.persistence.AddressDAO;
import nl.ipsen3.persistence.MerchantDAO;
import nl.ipsen3.persistence.OrderDAO;
import nl.ipsen3.persistence.OfferDAO;
import nl.ipsen3.persistence.OfferWineDAO;
import nl.ipsen3.persistence.UserDAO;
import nl.ipsen3.persistence.WineDAO;
import nl.ipsen3.resource.AddressResource;
import nl.ipsen3.resource.MerchantResource;
import nl.ipsen3.resource.OrderResource;
import nl.ipsen3.resource.OfferResource;
import nl.ipsen3.resource.OfferWineResource;
import nl.ipsen3.resource.UserResource;
import nl.ipsen3.resource.WineResource;
import nl.ipsen3.service.AddressService;
import nl.ipsen3.service.AuthenticationService;
import nl.ipsen3.service.MerchantService;
import nl.ipsen3.service.OfferService;
import nl.ipsen3.service.OfferWineService;
import nl.ipsen3.service.OrderService;
import nl.ipsen3.service.UserService;
import nl.ipsen3.service.WineService;
import org.eclipse.jetty.servlet.FilterHolder;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Groep 1 
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
        MerchantDAO merchantDAO = new MerchantDAO();
        OrderDAO orderDAO = new OrderDAO();
        OfferWineDAO offerWineDAO = new OfferWineDAO();
        AddressDAO addressDAO = new AddressDAO();
        OfferDAO offerDAO = new OfferDAO();
        
        UserService userService = new UserService(userDAO);
        WineService wineService = new WineService(wineDAO);
        MerchantService merchantService = new MerchantService(merchantDAO);
        OrderService orderService = new OrderService(orderDAO);
        AddressService addressService = new AddressService(addressDAO);
        OfferService offerService = new OfferService(offerDAO);
        OfferWineService offerWineService = new OfferWineService(offerWineDAO);
        
        UserResource userResource = new UserResource(userService);
        WineResource wineResource = new WineResource(wineService);
        MerchantResource merchantResource = new MerchantResource(merchantService);
        OrderResource orderResource = new OrderResource(orderService);
        AddressResource addressResource = new AddressResource(addressService);
        OfferResource offerResource = new OfferResource(offerService);
        OfferWineResource offerWineResource = new OfferWineResource(offerWineService);
        
        setupAuthentication(environment, userDAO);
        configureClientFilter(environment);
        
        environment.jersey().register(userResource);
        environment.jersey().register(wineResource);
        environment.jersey().register(merchantResource);
        environment.jersey().register(orderResource);
        environment.jersey().register(addressResource);
        environment.jersey().register(offerResource);
        environment.jersey().register(offerWineResource);

    }
    
     private void setupAuthentication(Environment environment, UserDAO userDAO)
    {
        AuthenticationService authenticationService = new AuthenticationService(userDAO);
        ApiUnauthorizedHandler unauthorizedHandler = new ApiUnauthorizedHandler();
        
        environment.jersey().register(new AuthDynamicFeature(
            new BasicCredentialAuthFilter.Builder<User>()
                .setAuthenticator(authenticationService)
                .setAuthorizer(authenticationService)
                .setRealm("SUPER SECRET STUFF")
                .setUnauthorizedHandler(unauthorizedHandler)
                .buildAuthFilter())
        );
        
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(User.class));
    }
    
    private void configureClientFilter(Environment environment)
    {
        environment.getApplicationContext().addFilter(
            new FilterHolder(new ClientFilter()),
            "/*",
            EnumSet.allOf(DispatcherType.class)
        );
    }
    
    public static void main(String[] args) throws Exception
    {
        new ApiApplication().run(args);
    }
    
    
}
