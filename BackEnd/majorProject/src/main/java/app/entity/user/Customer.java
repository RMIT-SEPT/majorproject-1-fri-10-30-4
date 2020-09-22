package app.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import app.entity.Business;

@Entity
@Table(name="CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="CUSTOMER_ID", unique=true)
    private int customerID;

    @NotBlank(message="Error: First name required")
    @Column(name="FIRST_NAME")
    private String firstName;

    @NotBlank(message="Error: Last name required")
    @Column(name="LAST_NAME")
    private String lastName;

    @NotBlank(message="Error: Email required")
    @Column(name="EMAIL")
    private String email;

    @NotBlank(message="Error: Password required")
    @Column(name="PASSWORD_HASH")
    private String passwordHash;

    @NotBlank(message="Error: Phone Number required")
    @Column(name="PHONE_NUMBER")
    private String phoneNumber;
	
}
