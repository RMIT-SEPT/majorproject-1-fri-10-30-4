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
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/allbyid")
    public Iterable<BookingImpl> getBookingsByCustomerId(@RequestParam("customerID") int customerID) {
        return bookingService.getAllByCustomerId(customerID);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createBooking(@Valid @RequestBody BookingImpl newBooking, BindingResult result) {
        if(result.hasErrors()){
            return new ResponseEntity<>("Error: Invalid Booking object.", HttpStatus.BAD_REQUEST);
        }
        BookingImpl booking = bookingService.createBooking(newBooking);
        return new ResponseEntity<BookingImpl>(booking, HttpStatus.OK);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeBooking(@RequestParam("bookingID") Integer bookingID) {
        String message;
        if(bookingID == null) {
            message = "Error: Failed to remove booking. Please enter a booking ID.";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        boolean bookingFoundAndRemoved = bookingService.removeBooking(bookingID);
        if(!bookingFoundAndRemoved){
            message = "Error: Failed to remove booking #" + bookingID.toString() + "\n" +
            "Booking not found.";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        message = "Booking #" + bookingID.toString() + " successfully removed.";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    /************************************For Testing*****************************************/

    @GetMapping("/all")
    public Iterable<BookingImpl> getAllBookings() {
        return this.bookingService.getAll();
    }

    @DeleteMapping("/remove-all")
    public ResponseEntity<String> removeAllBookings() {
       for(BookingImpl booking : bookingService.getAll()){
           bookingService.removeBooking(booking.getBookingID());
       }
       return new ResponseEntity<>("All bookings removed.", HttpStatus.OK);
    }





}
