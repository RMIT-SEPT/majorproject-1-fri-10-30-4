package app.model.interfaces.employee;

public interface BusinessService {
	
	/**
	 * @return The ID for this service.
	 */
	Integer getServiceID();

	/**
	 *
	 * @return the ID for the business associated with the service.
	 */
	Integer getBusinessID();

	/**
	 *
	 * @return the duration of the service.
	 */

	Integer getServiceDuration();
	
//	/**
//	 * @return The type of this service.
//	 */
//	String getServiceType();
//
	/**
	 * @return The long description of this service.
	 */
	String getServiceDescription();
	
	
}
