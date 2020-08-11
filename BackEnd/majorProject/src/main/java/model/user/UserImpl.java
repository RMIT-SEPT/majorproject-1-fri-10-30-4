package model.user;
import model.interfaces.user.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class UserImpl implements User{
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private int userID;
	private UserRole userRole;
	private String email;
	private String hashedPassword;
	private String firstName;
	private String lastName;
	private String fullName;

	/**
	 * Create a new User object from scratch.
	 */
	public UserImpl(){

	}
	
	/**
	 * @param userID ID for the user account you want to access.
	 * Creates a user object from 
	 */
	public UserImpl(int userID) {

	}

	public UserImpl(int userID, UserRole userRole, String email,
					String hashedPassword, String firstName, String lastName) {
		this.userID = userID;
		this.userRole = userRole;
		this.email = email;
		this.hashedPassword = hashedPassword;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getUserID() {
		return userID;
	}


	public UserRole getUserRole() {
		return userRole;
	}


	public String getUserEmail(){

		return email;
	}


	public String getUserPasswordHash() {
		return hashedPassword;
	}


	public String getUserFirstName() {

		return firstName;
	}


	public String getUserLastName() {

		return lastName;
	}


	public String getUserFullName() {
		fullName = firstName + " " + lastName;
		return fullName;
	}
	
	

}
