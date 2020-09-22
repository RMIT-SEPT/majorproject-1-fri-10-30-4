package app.service;

import app.entity.Booking;
import app.repository.BookingRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;

/**
 * @author Jasper Huang s3423585
 */
@RunWith(MockitoJUnitRunner.class)
public class BookingServiceTest {

    private AutoCloseable closeable;
    private List<Booking> bookings;

    @BeforeEach
    void init() {
        closeable = MockitoAnnotations.openMocks(this);

        Booking booking1 = new Booking();
        Booking booking2 = new Booking();
        booking1.setBookingId(1);
        booking2.setBookingId(2);

        bookings = new ArrayList<>();
        bookings.add(booking1);
        bookings.add(booking2);
    }

    @AfterEach
    void finalise() throws Exception {
        closeable.close();
    }

    @Mock
    private BookingRepository mockedBookingRepository;

    @InjectMocks
    private BookingService bookingService;

    @Test
    public void removeBooking_True_IfBookingIdExists() {
        doReturn(bookings).when(mockedBookingRepository).findAll();
        assertTrue(bookingService.removeBooking(2));
    }

    @Test
    public void removeBooking_False_IfBookingIdDoesNotExist() {
        doReturn(bookings).when(mockedBookingRepository).findAll();
        assertFalse(bookingService.removeBooking(3));
    }
}
