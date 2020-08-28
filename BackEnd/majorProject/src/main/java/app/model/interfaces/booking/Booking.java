package app.model.interfaces.booking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public interface Booking {

	/**
	 * @return The ID of this booking.
	 */
	Integer getBookingID();
	
	/**
	 * @return True if the booking is still continuing, false if the booking is cancelled/or completed.
	 */
	Boolean getIsActive();
	/**
	 * @return The service ID that this booking is for.
	 */
	int getServiceID();
	/**
	 * @return The ID of the customer associated with this booking.
	 */
	int getCustomerUserID();
	
	/**
	 * @return The ID of the employee associated with this booking.
	 */
	int getEmployeeUserID();

	/**
	 * @return The date this booking is for.
	 */
	//LocalDate getBookingDate();
	
	/**
	 * @return The time this booking starts (to the nearest minute).
	 */
	//LocalDateTime getBookingStartTime();
	
	/**
	 * @return The time this booking ends (to the nearest minute).
	 */
	//LocalTime getBookingEndTime();


	
	String getBookingDescription();
	
	
}
