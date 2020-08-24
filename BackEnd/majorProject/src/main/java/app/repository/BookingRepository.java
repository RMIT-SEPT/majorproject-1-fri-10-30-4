package app.repository;


import app.model.booking.BookingImpl;
import app.model.interfaces.booking.Booking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<BookingImpl, Integer> {

    /**
     * @param customerId
     * @return an Iterable list of bookings filtered by customer id.
     */
    @Query("SELECT booking FROM BookingImpl booking WHERE (booking.customerID = ?1)")
    Iterable<BookingImpl> getAllByCustomerId(int customerId);
}
