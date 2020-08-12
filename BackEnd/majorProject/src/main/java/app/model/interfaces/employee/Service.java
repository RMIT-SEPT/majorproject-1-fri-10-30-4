package app.model.interfaces.employee;

public interface Service {
	
	/**
	 * @return The ID for this service.
	 */
	int getServiceID();
	
	/**
	 * @return The type of this service.
	 */
	String getServiceType();
	
	/**
	 * @return The long description of this service.
	 */
	String getServiceDescription();
	
	
}
