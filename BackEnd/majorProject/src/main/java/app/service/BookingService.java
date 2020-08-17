package app.service;

import app.model.interfaces.booking.Booking;
import app.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Booking createBooking(Booking booking){
       return bookingRepository.save(booking);
    }

    public Iterable<Booking> getAll(){
       return bookingRepository.findAll();
    }


}
