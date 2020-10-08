package app.controller;

import app.entity.Booking;
import app.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.NoSuchElementException;

import javax.validation.Valid;

@RestController
//TODO:fix
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/allbyid")
    public Iterable<Booking> getBookingsByCustomerId(@RequestParam("customerID") Long customerID) {
        return bookingService.getAllByCustomerId(customerID);
    }

//    @PostMapping("/create")
//    public ResponseEntity<?> createBooking(@Valid @RequestBody Booking booking, BindingResult result) {
//        if(result.hasErrors()){
//            return new ResponseEntity<>("Error: Invalid Booking object.", HttpStatus.BAD_REQUEST);
//        }
//        Booking bookingResponseEntity = bookingService.createBooking(booking);
//        return new ResponseEntity<Booking>(bookingResponseEntity, HttpStatus.OK);
//    }    
    
    @PostMapping("/create")
    public ResponseEntity<?> createBooking(
    		@RequestParam("businessID") int businessID, 
    		@RequestParam("customerID") int customerID, 
    		@RequestParam("employeeID") int employeeID, 
    		@RequestParam("serviceID") int serviceID, 
    		@RequestParam("date") long date
    		)
    {
    	return new ResponseEntity<Booking>(bookingService.createBooking(businessID, employeeID, customerID, serviceID, date), HttpStatus.OK);
    }

    @PutMapping("/cancel")
    public ResponseEntity<String> cancelBooking(@RequestParam("bookingId") Integer bookingId) {
        String message;
        if(bookingId == null) {
            message = "Error: Failed to cancel booking. Please enter a booking ID.";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }

        boolean bookingFoundAndCancelled = bookingService.cancelBooking(bookingId);
        if(!bookingFoundAndCancelled){
            message = "Error: Failed to cancel booking #" + bookingId.toString() + "\n" +
                    "Booking not found.";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }
        message = "Booking #" + bookingId.toString() + " successfully cancelled.";
        return new ResponseEntity<>(message, HttpStatus.OK);
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

    @GetMapping("/getAvailbleTimes")
    public ResponseEntity<?> findAvailableBookings(
    		@RequestParam("businessID") int businessID, 
    		@RequestParam("employeeID") int employeeID, 
    		@RequestParam("serviceID") int serviceID, 
    		@RequestParam("date") long date)
    {
    	return new ResponseEntity<>(bookingService.getAvailableBookings(businessID, employeeID, serviceID, date), HttpStatus.OK);
    }
    
    @GetMapping("{bookingID}")
    public ResponseEntity<?> getBookingByID(@PathVariable(value="bookingID") int bookingID){
    	try {
    		Booking booking = bookingService.findByID(bookingID).get();
    		return new ResponseEntity<>(booking, HttpStatus.OK);
    	} catch(NoSuchElementException e) {
    		return new ResponseEntity<>("No booking under that ID", HttpStatus.NOT_FOUND);
    	}
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
