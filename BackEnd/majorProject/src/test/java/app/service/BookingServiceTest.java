package app.service;

import app.entity.Booking;
import app.repository.BookingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

/**
 * @author Jasper Huang s3423585
 */
@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

    private List<Booking> bookings;

    @BeforeEach
    void init() {
        Booking booking1 = new Booking();
        booking1.setBookingId(1);
        bookings = new ArrayList<>();
        bookings.add(booking1);
    }

    @Mock
    private BookingRepository mockBookingRepository;

    @InjectMocks
    private BookingService bookingService;

    @Test
    void removeBooking_True_IfBookingIdExists() {
        when(mockBookingRepository.findAll()).thenReturn(bookings);
        assertTrue(bookingService.removeBooking(1));
    }

    @Test
    public void removeBooking_False_IfBookingIdDoesNotExist() {
        when(mockBookingRepository.findAll()).thenReturn(bookings);
        assertFalse(bookingService.removeBooking(2));
    }
}
