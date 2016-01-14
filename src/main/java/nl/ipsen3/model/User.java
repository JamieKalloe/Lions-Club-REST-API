<<<<<<< HEAD
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
=======
package nl.ipsen3.model;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.Date;
import nl.ipsen3.View;
import nl.IPSEN3.model.Address;
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
    @Length(min = 3, max = 100)
    @JsonView(View.Public.class)
    private String fullName;
    
    @Email
    @JsonView(View.Public.class)
    private String email;
    
    @Length(min = 8)
    @JsonView(View.Private.class)
    private String password;
    
    @JsonView(View.Public.class)
    private Address address;
    
    @JsonView(View.Public.class)
    private String firstName, lastName, gender, notes, insertion, username;
    
    @JsonView(View.Public.class)
    private int profile;
    
    @JsonView(View.Public.class)
    private Date dateOfBirth;
    
    public User(String username, String password, String email, int profile) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.profile = profile;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Address getAddress() {
        return address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getNotes() {
        return notes;
    }

    public String getInsertion() {
        return insertion;
    }

    public String getUsername() {
        return username;
    }

    public int getProfile() {
        return profile;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setInsertion(String insertion) {
        this.insertion = insertion;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
>>>>>>> models
