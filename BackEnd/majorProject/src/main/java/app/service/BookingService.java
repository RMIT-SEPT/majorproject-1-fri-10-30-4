package app.service;

import app.model.booking.BookingImpl;
import app.model.interfaces.booking.Booking;
import app.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public BookingImpl createBooking(BookingImpl booking){
       return bookingRepository.save(booking);
    }

    public Iterable<BookingImpl> getAll(){
       return bookingRepository.findAll();
    }


}
