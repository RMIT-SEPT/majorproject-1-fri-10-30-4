package app.service;

import app.entity.Booking;
import app.entity.Business;
import app.entity.BusinessServiceJob;
import app.entity.user.Customer;
import app.entity.user.Employee;
import app.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * @author Jasper Huang s3423585
 */
@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

    @Mock
    private BusinessRepository businessRepository;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private BusinessServiceRepository businessServiceRepository;

    @Mock
    private BookingRepository bookingRepository;

    @InjectMocks
    private BookingService bookingService;

    @Nested
    class createBooking {

        private Business business;
        private Employee employee;
        private Customer customer;
        private BusinessServiceJob service;
        private Date date;
        private long pastDateUpperLimit;

        @BeforeEach
        void init() {
            business = new Business();
            employee = new Employee();
            customer = new Customer();
            service = new BusinessServiceJob();
            date = new Date();

            Mockito.lenient().when(businessRepository.findById(1)).thenReturn(Optional.of(business));
            Mockito.lenient().when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));
            Mockito.lenient().when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
            Mockito.lenient().when(businessServiceRepository.findById(1)).thenReturn(Optional.of(service));

            // delay in ms
            // max delay for frontend request to reach service
            int acceptableDelay = 2000;
            pastDateUpperLimit = date.getTime() - acceptableDelay;
        }

        @Captor
        ArgumentCaptor<Booking> bookingCaptor;

        @Test
        void createBooking_Booking_IfAllArgsValid() {
            bookingService.createBooking(1, 1, 1, 1, date.getTime());
            Mockito.verify(bookingRepository).save(bookingCaptor.capture());
            Booking bookingCaptorValue = bookingCaptor.getValue();

            assertNotNull(bookingCaptorValue.getService());
            assertNotNull(bookingCaptorValue.getEmployee());
            //assertNotNull(bookingCaptorValue.getCustomer());
            assertTrue(bookingCaptorValue.getBookingStart() > pastDateUpperLimit);
            assertNotNull(bookingCaptorValue.getBookingDescription());
        }

        @Test
        void createBooking_Null_IfEmployeeIdDoesNotExist() {
            when(employeeRepository.findById(2)).thenReturn(Optional.empty());

            Booking createdBooking = bookingService.createBooking(1, 2, 1, 1, date.getTime());
            assertNull(createdBooking);
        }

        @Test
        void createBooking_Null_IfCustomerIdDoesNotExist() {
            when(customerRepository.findById(2L)).thenReturn(Optional.empty());

            Booking createdBooking = bookingService.createBooking(1, 1, 2, 1, date.getTime());
            assertNull(createdBooking);
        }

        @Test
        void createBooking_Null_IfServiceIdDoesNotExist() {
            when(businessServiceRepository.findById(2)).thenReturn(Optional.empty());

            Booking createdBooking = bookingService.createBooking(1, 1, 1, 2, date.getTime());
            assertNull(createdBooking);
        }

        @Test
        void createBooking_Null_IfDateIsPast() {
            Booking booking = new Booking();
            Mockito.lenient().when(bookingRepository.save(any(Booking.class))).thenReturn(booking);

            Booking createdBooking = bookingService.createBooking(1, 1, 1, 1, pastDateUpperLimit);
            assertNull(createdBooking);
        }
    }

    @Nested
    class removeBooking {

        @BeforeEach
        void init() {
            Booking booking = new Booking();
            booking.setBookingId(1);
            List<Booking> bookings = new ArrayList<>();
            bookings.add(booking);

            when(bookingRepository.findAll()).thenReturn(bookings);
        }

        @Test
        void removeBooking_True_IfBookingIdExists() {
            assertTrue(bookingService.removeBooking(1));
        }

        @Test
        public void removeBooking_False_IfBookingIdDoesNotExist() {
            assertFalse(bookingService.removeBooking(2));
        }
    }
}
