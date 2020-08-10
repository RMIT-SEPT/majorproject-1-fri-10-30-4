package model.interfaces.user;

public interface Customer{

	/**
	 * @return The ID for the customer's user account.
	 */
	int getUserID();
	
	/**
	 * @return The customer's phone number as a string.
	 */
	String getPhoneNumber();
	
	/**
	 * @return The customer's full address as a string.
	 */
	String getAddress();
		
}
