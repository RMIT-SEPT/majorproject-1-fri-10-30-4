package app.repository;


import app.model.booking.BookingImpl;
import app.model.interfaces.booking.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<BookingImpl, Integer> {

}
