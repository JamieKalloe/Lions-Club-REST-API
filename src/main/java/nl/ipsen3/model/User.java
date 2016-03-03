package nl.ipsen3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import java.security.Principal;
import nl.ipsen3.View;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

/**
 * Meer informatie over validatie:
 *  http://hibernate.org/validator/
 * 
 * @author Groep1
 */
public class User implements Principal
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
    
    @JsonView(View.Public.class)
    private int mailOpt;
    
    @Length(min = 3, max = 100)
    @JsonView(View.Public.class)
    private String firstName;
    
    @Length(min = 0, max = 100)
    @JsonView(View.Public.class)
    private String prefixLastName;
    
    @Length(min = 3, max = 100)
    @JsonView(View.Public.class)
    private String lastName;
    
    @Length(max = 1)
    @JsonView(View.Public.class)
    private String gender;
    
    @JsonView(View.Public.class)
    private String notes;
    
    @Length(min = 8)
    @JsonView(View.Protected.class)
    private String password;

    @JsonView(View.Public.class)
    private String role;

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
    
    public int getMailOpt() {
        return mailOpt;
    }

    public void setMailOpt(int mailOpt) {
        this.mailOpt = mailOpt;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean hasRole(String roleName)
    {
        return roleName.equals(role);
    }
    
    
    @Override
    @JsonIgnore
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public boolean equals(User user)
    {
        return email.equals(user.getEmail());
    }
    
    
}
