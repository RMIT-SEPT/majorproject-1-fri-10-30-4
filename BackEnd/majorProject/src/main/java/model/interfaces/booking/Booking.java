package model.interfaces.booking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public interface Booking {

	/**
	 * @return The ID of this booking.
	 */
	int getBookingID();
	
	/**
	 * @return True if the booking is still continuing, false if the booking is cancelled.
	 */
	boolean getIsCancelled();
	
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
	LocalDate getBookingDate();
	
	/**
	 * @return The time this booking starts (to the nearest minute).
	 */
	 LocalTime getBookingStartTime();
	
	/**
	 * @return The time this booking ends (to the nearest minute).
	 */
	LocalTime getBookingEndTime();
	
	/**
	 * @return The booking's duration in minutes, rounded to nearest minute if needed.
	 */
	int getBookingDuration();
	
	/**
	 * @return The service that this booking is for.
	 */
	int getServiceID();
	
	String getBookingDescription();
	
	
}
