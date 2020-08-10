package model.user;
import model.interfaces.user.User;;

public class UserImpl implements User{
	int userID;
	UserRole userRole;
	String email;
	String hashedPassword;
	String firstName;
	String lastName;
	String fullName;

	/**
	 * Create a new User object from scratch.
	 */
	UserImpl(){

	}
	
	/**
	 * @param userID ID for the user account you want to access.
	 * Creates a user object from 
	 */
	UserImpl(int userID) {

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
