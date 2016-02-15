package nl.ipsen3.model;

import com.fasterxml.jackson.annotation.JsonView;
import nl.ipsen3.View;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

/**
 * Meer informatie over validatie:
 *  http://hibernate.org/validator/
 * 
 * @author Groep1
 */
public class User
{
    @JsonView(View.Public.class)
    private int id;
    
    @JsonView(View.Public.class)
    private int addressId;
    
    @JsonView(View.Public.class)
    private int referralId;
    
    @Email
    @JsonView(View.Public.class)
    private String email;
    
    @Length(min = 3, max = 100)
    @JsonView(View.Public.class)
    private String first_name;
    
    @Length(min = 0, max = 100)
    @JsonView(View.Public.class)
    private String prefix_last_name;
    
    @Length(min = 3, max = 100)
    @JsonView(View.Public.class)
    private String last_name;
    
    @Length(max = 1)
    @JsonView(View.Public.class)
    private String gender;
    
    @JsonView(View.Public.class)
    private String notes;
    
    @Length(min = 8)
    @JsonView(View.Private.class)
    private String password;

    @JsonView(View.Public.class)
    private int role;
    
    @JsonView(View.Public.class)
    private Order order;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getReferralId() {
        return referralId;
    }

    public void setReferralId(int referralId) {
        this.referralId = referralId;
    }

    public String getEmail() {
        return email;
    }
    
    public void setOrder(Order order) {
        this.order = order;
    }
    
    public Order getOrder() {
        return this.order;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public String getPrefixLastName() {
        return prefix_last_name;
    }

    public void setPrefixLastName(String prefixLastName) {
        this.prefix_last_name = prefixLastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
    
}
