package app.entity.user;


import app.entity.Business;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

@Entity
@Table(name="BUSINESS_ADMIN")
public class BusinessAdmin implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="BUSINESS_ADMIN_ID", unique=true)
    private Long businessAdminId;

    @Column(name="BUSINESS_NAME")
    private String businessName;

    @Column(name="BUSINESS_DESC")
    private String businessDesc;

    @NotBlank(message="Error: First name required")
    @Column(name="FIRST_NAME")
    private String firstName;

    @NotBlank(message="Error: Last name required")
    @Column(name="LAST_NAME")
    private String lastName;

    @Email(message = "Username needs to be an email")
    @NotBlank(message = "username is required")
    @Column(unique = true)
    private String username;

    @NotBlank(message="Error: Email required")
    @Column(name="EMAIL")
    private String email;

    @NotBlank(message="Error: Address required")
    @Column(name="ADDRESS")
    private String address;

    @NotBlank(message="Error: Phone Number required")
    @Column(name="PHONE_NUMBER")
    private String phoneNumber;

    @NotBlank(message="Error: Password required")
    @Column(name="PASSWORD_HASH")
    private String passwordHash;

    @Transient
    private String confirmPassword;
    public BusinessAdmin(){}
    public BusinessAdmin(Long businessAdminId, String businessName, String businessDesc, String firstName,String lastName,
                         String username, String email,String address,  String phoneNumber, String passwordHash, String confirmPassword) {
        this.businessAdminId = businessAdminId;
        this.businessName = businessName;
        this.businessDesc = businessDesc;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.passwordHash = passwordHash;
        this.confirmPassword = confirmPassword;
    }

    public Long getBusinessAdminId() {
        return businessAdminId;
    }
    public String getFullName() {
        return firstName + " " + lastName;
    }
    public void setBusinessAdminId(Long businessAdminId) {
        this.businessAdminId = businessAdminId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessDesc() {
        return businessDesc;
    }

    public void setBusinessDesc(String businessDesc) {
        this.businessDesc = businessDesc;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    @Override
    public String getUsername() {
        return username;
    }


    public void setPassword(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setUsername(String username) {
        this.username = email;
    }
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
