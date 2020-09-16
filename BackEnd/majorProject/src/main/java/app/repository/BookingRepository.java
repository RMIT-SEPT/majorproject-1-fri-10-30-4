package app.repository;


import app.entity.Booking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer> {

    /**
     * @param customerId
     * @return an Iterable list of bookings filtered by customer id.
     */
    @Query("SELECT booking FROM Booking booking WHERE (booking.customerId = ?1)")
    Iterable<Booking> getAllByCustomerId(int customerId);
}
