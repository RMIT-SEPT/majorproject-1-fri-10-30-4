package app.repository;


import app.entity.Booking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer> {

//    /**
//     * @param customerId
//     * @return an Iterable list of bookings filtered by customer id.
//     */
//    @Query("SELECT booking FROM Booking booking WHERE (booking.customer.customerId = ?1)")
//    Iterable<Booking> getAllByCustomerId(Long customerId);

    /**
     * @param employeeID
     * @param startTime as milliseconds from epoc.
     * @param serviceLength in milliseconds.
     * @return
     */
    @Query("SELECT booking FROM Booking booking WHERE (booking.startTime < :finishTime) AND (:startTime < booking.endTime) AND (booking.employee.employeeId = :employeeID)")
    Iterable<Booking> getOverlappingBookings(@Param("employeeID") int employeeID, @Param("startTime") Long startTime, @Param("finishTime") Long finishTime);
}
