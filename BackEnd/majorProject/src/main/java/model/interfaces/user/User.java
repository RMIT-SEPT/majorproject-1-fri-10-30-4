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
	String getCustomerEmail();
	
	/**
	 * @return The user's password hash.
	 */
	String getCustomerPasswordHash();
	
	/**
	 * @return The user's first name only.
	 */
	String getCustomerFirstName();
	
	/**
	 * @return The user's last name only.
	 */
	String getCustomerLastName();
	
	/**
	 * @return The user's full name. 
	 */
	String getCustomerFullName();
	
	/**
	 * @return The user's address.
	 */
	String getCustomerAddress();
	
	/**
	 * @return The user's role.
	 */
	UserRole getUserRole();
}
