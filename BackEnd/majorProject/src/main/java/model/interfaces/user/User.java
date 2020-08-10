package model.interfaces.user;

import model.user.UserRole;

public interface User {
	
	/**
	 * @return The user's ID as an integer.
	 */
	int getUserID();
	
	/**
	 * @return The user's email address.
	 */
	String getUserEmail();
	
	/**
	 * @return The user's password hash.
	 */
	String getUserPasswordHash();
	
	/**
	 * @return The user's first name only.
	 */
	String getUserFirstName();
	
	/**
	 * @return The user's last name only.
	 */
	String getUserLastName();
	
	/**
	 * @return The user's full name. 
	 */
	String getUserFullName();
	
	/**
	 * @return The user's role.
	 */
	UserRole getUserRole();
}
