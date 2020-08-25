package app.service;

import app.model.booking.BookingImpl;
import app.model.businessservice.BusinessServiceImpl;
import app.model.interfaces.booking.Booking;
import app.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public BookingImpl createBooking(BookingImpl booking) {
        return bookingRepository.save(booking);
    }

    public Iterable<BookingImpl> getAll(){
        return bookingRepository.findAll();
    }

    public boolean removeBooking(Integer bookingID){
        for(BookingImpl booking : getAll()){
            if(booking.getBookingID() == bookingID) {
                bookingRepository.deleteById(bookingID);
                return true;
            }
    public Iterable<BookingImpl> getAllByCustomerId(int customerID) {
        return bookingRepository.getAllByCustomerId(customerID);
    }

    public boolean deleteBooking(Integer bookingID){
        Optional<BookingImpl> optionalEntity = bookingRepository.findById(bookingID);
        if (optionalEntity == null) {
            return false;
        }
        return false;
    }


}
