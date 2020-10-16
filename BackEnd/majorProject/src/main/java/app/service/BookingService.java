package app.service;

import app.entity.Booking;
import app.entity.Business;
import app.entity.BusinessServiceJob;
import app.entity.user.Customer;
import app.entity.user.Employee;
import app.model.booking.BookingTimeOptionDTO;
import app.repository.BookingRepository;
import app.repository.BusinessRepository;
import app.repository.BusinessServiceRepository;
import app.repository.EmployeeRepository;
import app.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired 
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private BusinessRepository businessRepository;
    
    @Autowired
    private BusinessServiceRepository businessServiceRepository;
    
    @Autowired
    private CustomerRepository customerRepository;


    
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }
    
    public Booking createBooking(
    	int businessID, 
    	int employeeID, 
    	int customerID, 
    	int serviceID, 
    	long date
    	) {
    	Business business = businessRepository.findById(businessID).get();
    	Employee employee = employeeRepository.findById(employeeID).get();
      
    	Customer customer  = customerRepository.findById(Long.valueOf(customerID)).get();

    	BusinessServiceJob service = businessServiceRepository.findById(serviceID).get();
    	//TODO:validate
    	Booking booking =  new Booking(service, employee, customer, date, "");
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

//    public Iterable<Booking> getAllByCustomerId(int customerID) {
//        return bookingRepository.getAllByCustomerId(customerID);
//    }

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
		LocalTime shiftStart;
		LocalTime shiftEnd;
		try {
			String[] shift = shiftString.split("-");
			shiftStart = LocalTime.parse(shift[0], DateTimeFormatter.ofPattern("HH:mm"));
			shiftEnd = LocalTime.parse(shift[1], DateTimeFormatter.ofPattern("HH:mm"));
		} catch (DateTimeParseException e) {
			ArrayList<BookingTimeOptionDTO> bookingTimeOptions = new ArrayList<BookingTimeOptionDTO>();
			return bookingTimeOptions;
		}
		int appointmentIncrement = 60;
		shiftEnd = shiftEnd.minusMinutes(serviceLength);
		
		ArrayList<BookingTimeOptionDTO> bookingTimeOptions = new ArrayList<BookingTimeOptionDTO>();
		for(LocalTime i = LocalTime.from(shiftStart);!i.isAfter(shiftEnd);i = i.plusMinutes(appointmentIncrement)) {
			Calendar shiftStartCalendar = Calendar.getInstance();
			shiftStartCalendar.setTimeInMillis(date);
			shiftStartCalendar.set(Calendar.HOUR_OF_DAY, i.getHour());
			shiftStartCalendar.set(Calendar.MINUTE, i.getMinute());
			shiftStartCalendar.set(Calendar.SECOND, 0);
			Iterable<Booking> overlappingBookings = bookingRepository.getOverlappingBookings(employeeID, shiftStartCalendar.getTimeInMillis(), shiftStartCalendar.getTimeInMillis() + (serviceLength * 60 * 1000));
			System.out.println(shiftStartCalendar.getTimeInMillis());
			System.out.println(shiftStartCalendar.getTimeInMillis() + (serviceLength * 60 * 1000));
			if(!overlappingBookings.iterator().hasNext()) {
				bookingTimeOptions.add(new BookingTimeOptionDTO(i, i.plusMinutes(serviceLength)));
			}
		}
    	return bookingTimeOptions;
    }    
    
    public Optional<Booking> findByID(int bookingID){
    	return bookingRepository.findById(bookingID);
    }

    public Iterable<Booking> getAllByCustomerId(Long customerID){
    	List<Booking> bookings = new ArrayList<>();
    	for(Booking booking : bookingRepository.findAll()){
    		if(booking.getCustomer().getUserId().equals(customerID)) {
    			bookings.add(booking);
			}
		}
    	return bookings;
	}

	public boolean cancelBooking(Integer bookingId){
		for(Booking booking : bookingRepository.findAll()) {
			if (booking.getBookingId() == bookingId) {
				booking.setActive(Boolean.valueOf(false));
				bookingRepository.save(booking);
				return true;
			}
		}
		return false;
	}
    
}
