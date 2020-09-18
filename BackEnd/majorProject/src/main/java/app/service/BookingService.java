package app.service;



import app.entity.Booking;
import app.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

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

    public Iterable<Date> getAvailableDates(int businessID, int serviceID, int employeeID){
		return null;
    }
    
}
