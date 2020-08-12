package app.model.interfaces.user;

public interface BusinessAdmin {

	/**
	 * @return Get this ID of this business admin's associated user account.
	 */
	int getUserID();
	
	/**
	 * @return Get the ID of this business admin's associated business.
	 */
	int getBusinessID();
	
}
