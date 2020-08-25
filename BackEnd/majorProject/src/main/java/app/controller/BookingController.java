package app.controller;

import app.model.booking.BookingImpl;
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

    @GetMapping("/all")
    public Iterable<BookingImpl> getAllBookings() {
        return this.bookingService.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<BookingImpl> createBooking(@Valid @RequestBody BookingImpl newBooking, BindingResult result) {
        BookingImpl booking = bookingService.createBooking(newBooking);
        return new ResponseEntity<BookingImpl>(booking, HttpStatus.OK);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeBooking(@RequestParam("bookingID") Integer bookingID) {
        String message;
        if(bookingID == null) {
            message = "Failed to remove booking. Please enter a booking ID.";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        boolean bookingFoundAndRemoved = bookingService.removeBooking(bookingID);
        if(!bookingFoundAndRemoved){
            message = "Failed to remove booking #" + bookingID.toString() + "\n" +
            "Booking not found.";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        message = "Booking #" + bookingID.toString() + " successfully removed.";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

/************************************************************************************/
    // For testing purposes
    @DeleteMapping("/remove-all")
    public ResponseEntity<String> removeAllBookings() {
       for(BookingImpl booking : bookingService.getAll()){
           bookingService.removeBooking(booking.getBookingID());
       }
       return new ResponseEntity<>("All bookings removed.", HttpStatus.OK);
    }


}
