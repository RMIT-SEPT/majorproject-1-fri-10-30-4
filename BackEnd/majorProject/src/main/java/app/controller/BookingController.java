package app.controller;

import app.entity.Booking;
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
    public Iterable<Booking> getBookingsByCustomerId(@RequestParam("customerID") int customerID) {
        return bookingService.getAllByCustomerId(customerID);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createBooking(@Valid @RequestBody Booking booking, BindingResult result) {
        if(result.hasErrors()){
            return new ResponseEntity<>("Error: Invalid Booking object.", HttpStatus.BAD_REQUEST);
        }
        Booking bookingResponseEntity = bookingService.createBooking(booking);
        return new ResponseEntity<Booking>(bookingResponseEntity, HttpStatus.OK);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeBooking(@RequestParam("bookingId") Integer bookingId) {
        String message;
        if(bookingId == null) {
            message = "Error: Failed to remove booking. Please enter a booking ID.";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        boolean bookingFoundAndRemoved = bookingService.removeBooking(bookingId);
        if(!bookingFoundAndRemoved){
            message = "Error: Failed to remove booking #" + bookingId.toString() + "\n" +
            "Booking not found.";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        message = "Booking #" + bookingId.toString() + " successfully removed.";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    /************************************For Testing*****************************************/

    @GetMapping("/all")
    public Iterable<Booking> getAllBookings() {
        return this.bookingService.getAll();
    }

    @DeleteMapping("/remove-all")
    public ResponseEntity<String> removeAllBookings() {
       for(Booking booking : bookingService.getAll()){
           bookingService.removeBooking(booking.getBookingId());
       }
       return new ResponseEntity<>("All bookings removed.", HttpStatus.OK);
    }





}
