package app.model.booking;

import java.time.LocalTime;

public class BookingTimeOptionDTO {
	public LocalTime shiftStart;
	public LocalTime shiftEnd;
	
	public BookingTimeOptionDTO(LocalTime shiftStart, LocalTime shiftEnd) {
		this.shiftStart = shiftStart;
		this.shiftEnd = shiftEnd;
	}
	
}
