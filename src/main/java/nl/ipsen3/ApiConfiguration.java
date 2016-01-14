package nl.ipsen3;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Peter van Vliet
 */
public class ApiConfiguration extends Configuration
{
    @NotEmpty
    @JsonProperty
    private String apiName;
    
    @NotEmpty
    @JsonProperty
    private String databaseURL;
    
    @NotEmpty
    @JsonProperty
    private String databaseUser;
    
    @NotEmpty
    @JsonProperty
    private String databasePwd;
    
    @NotEmpty
    @JsonProperty
    private String databaseName;

    public String getApiName()
    {
        return apiName;
    }

    public void setApiName(String apiName)
    {
        this.apiName = apiName;
    }

    public String getDatabaseURL() {
        return databaseURL;
    }

    public void setDatabaseURL(String databaseURL) {
        this.databaseURL = databaseURL;
    }

    public String getDatabaseUser() {
        return databaseUser;
    }

    public void setDatabaseUser(String databaseUser) {
        this.databaseUser = databaseUser;
    }

    public String getDatabasePwd() {
        return databasePwd;
    }

    public void setDatabasePwd(String databasePwd) {
        this.databasePwd = databasePwd;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }
    
}
