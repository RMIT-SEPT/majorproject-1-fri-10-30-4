package app.controller;

import app.model.booking.BookingImpl;
import app.model.interfaces.booking.Booking;
import app.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public Iterable<BookingImpl> getAllBookings() {
        return this.bookingService.getAll();
    }

    @PostMapping
    public ResponseEntity<BookingImpl> createBooking(@Valid @RequestBody BookingImpl newBooking, BindingResult result) {
        BookingImpl booking = bookingService.createBooking(newBooking);
        return new ResponseEntity<BookingImpl>(booking, HttpStatus.CREATED);
    }

}
