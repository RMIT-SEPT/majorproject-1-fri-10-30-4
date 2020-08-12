package app.model.interfaces.user;

import java.util.List;

public interface Employee {

	/**
	 * @return The user ID associated with this employee
	 */
	int getUserID();
	
	/**
	 * @return The business associated with this employee
	 */
	int getBusinessID();
	
	/**
	 * @return The phone number of this employee as an unformatted string.
	 */
	String getPhoneNumber();
	
	/**
	 * @return An unordered list of service IDs that this employee can do.
	 */
	List<Integer> getServices();
	
}
