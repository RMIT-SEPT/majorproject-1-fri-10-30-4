package app.service;



import app.entity.Booking;
import app.entity.BusinessServiceJob;
import app.entity.user.Employee;
import app.model.booking.BookingTimeOptionDTO;
import app.repository.BookingRepository;
import app.repository.BusinessServiceRepository;
import app.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired 
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private BusinessServiceRepository businessServiceRepository;
    
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Iterable<Booking> getAll(){
        return bookingRepository.findAll();
    }

    public boolean removeBooking(Integer bookingId){
        for(Booking booking : getAll()) {
            if (booking.getBookingId() == bookingId) {
                bookingRepository.deleteById(bookingId);
                return true;
            }
        }
        return false;
    }

    public Iterable<Booking> getAllByCustomerId(int customerID) {
        return bookingRepository.getAllByCustomerId(customerID);
    }

    public Iterable<BookingTimeOptionDTO>getAvailableBookings(int businessID, int employeeID, int serviceID, long date) {
    	Employee employee = (Employee) employeeRepository.findById(employeeID).get();
    	int serviceLength = businessServiceRepository.findById(serviceID).get().getServiceLength();
    	Calendar requestDate = Calendar.getInstance();
		requestDate.setTimeInMillis(date);
		String shiftString;
		switch(requestDate.get(Calendar.DAY_OF_WEEK)) {
			case(Calendar.MONDAY):
				shiftString = employee.getMondayTime();
				break;
			case(Calendar.TUESDAY):
				shiftString = employee.getTuesdayTime();
				break;
			case(Calendar.WEDNESDAY):
				shiftString = employee.getWednesdayTime();
				break;
			case(Calendar.THURSDAY):
				shiftString = employee.getThursdayTime();
				break;
			case(Calendar.FRIDAY):
				shiftString = employee.getFridayTime();
				break;
			case(Calendar.SATURDAY):
				shiftString = employee.getSaturdayTime();
				break;
			case(Calendar.SUNDAY):
				shiftString = employee.getSundayTime();
				break;
			default:
				shiftString = "";
				break;
		}
    	String[] shift = shiftString.split("-");
		LocalTime shiftStart = LocalTime.parse(shift[0]);
		LocalTime shiftEnd = LocalTime.parse(shift[1]);
		int appointmentIncrement = 60;
		shiftEnd = shiftEnd.minusMinutes(serviceLength);
		
		ArrayList<BookingTimeOptionDTO> bookingTimeOptions = new ArrayList<BookingTimeOptionDTO>();
		for(LocalTime i = LocalTime.from(shiftStart);!i.isAfter(shiftEnd);i = i.plusMinutes(appointmentIncrement)) {
			Calendar shiftStartCalendar = Calendar.getInstance();
			shiftStartCalendar.setTimeInMillis(date);
			shiftStartCalendar.set(Calendar.HOUR, i.getHour());
			shiftStartCalendar.set(Calendar.MINUTE, i.getMinute());
			shiftStartCalendar.set(Calendar.SECOND, 0);
			Iterable<Booking> overlappingBookings = bookingRepository.getOverlappingBookings(employeeID, shiftStartCalendar.getTimeInMillis());
			if(!overlappingBookings.iterator().hasNext()) {
				bookingTimeOptions.add(new BookingTimeOptionDTO(i, i.plusMinutes(serviceLength)));
			}
		}
    	return bookingTimeOptions;
    }
    
    
    
}
