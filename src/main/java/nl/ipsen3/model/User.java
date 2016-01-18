package nl.ipsen3.model;

import com.fasterxml.jackson.annotation.JsonView;
import nl.ipsen3.View;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

/**
 * Meer informatie over validatie:
 *  http://hibernate.org/validator/
 * 
 * @author Peter van Vliet
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
    private String firstName;
    
    @Length(min = 3, max = 100)
    @JsonView(View.Public.class)
    private String lastName;
    
    @Length(min = 3, max = 100)
    @JsonView(View.Public.class)
    private String prefixLastName;
    
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
    
    public User() {}
    
    public User(int id) {
        this.id = id;
        this.gender = null;
        this.lastName = null;
        this.prefixLastName = null;
        this.addressId = 0;
        this.email = null;
        this.referralId = 0;
        this.notes = null;
        
    }

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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPrefixLastName() {
        return prefixLastName;
    }

    public void setPrefixLastName(String prefixLastName) {
        this.prefixLastName = prefixLastName;
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
