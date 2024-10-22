package app.service;

import app.entity.Booking;
import app.entity.Business;
import app.entity.BusinessServiceJob;
import app.entity.user.Customer;
import app.entity.user.Employee;
import app.model.booking.BookingTimeOptionDTO;
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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

/**
 * @author Jasper Huang s3423585
 */
@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

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

    private long getPastDateUpperLimit(Date date) {
        // delay in ms
        // max delay for frontend request to reach service
        int excessDelay = 2000;
        return date.getTime() - excessDelay;
    }

    @Nested
    class CreateBooking {

        private Employee employee;
        private Customer customer;
        private BusinessServiceJob service;
        private Date date;

        @BeforeEach
        void init() {
            employee = new Employee();
            customer = new Customer();
            service = new BusinessServiceJob();
            date = new Date();

            Mockito.lenient().when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));
            Mockito.lenient().when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
            Mockito.lenient().when(businessServiceRepository.findById(1)).thenReturn(Optional.of(service));
        }

        @Captor
        ArgumentCaptor<Booking> bookingCaptor;

        @Test
        void createBooking_Booking_IfAllArgsValid() {
            bookingService.createBooking(1, 1, 1, 1, date.getTime());
            Mockito.verify(bookingRepository).save(bookingCaptor.capture());
            Booking bookingCaptorValue = bookingCaptor.getValue();

            long pastDateUpperLimit = getPastDateUpperLimit(date);

            assertNotNull(bookingCaptorValue.getService());
            assertNotNull(bookingCaptorValue.getEmployee());
            assertNotNull(bookingCaptorValue.getCustomer());
            assertTrue(bookingCaptorValue.getBookingStart() > pastDateUpperLimit);
            assertNotNull(bookingCaptorValue.getBookingDescription());
        }

        @Test
        void createBooking_Exception_IfEmployeeIdDoesNotExist() {
            when(employeeRepository.findById(2)).thenReturn(Optional.empty());

            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                bookingService.createBooking(1, 2, 1, 1, date.getTime());
            });

            String expectedMessage = "employee id not found";
            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));
        }

        @Test
        void createBooking_Exception_IfCustomerIdDoesNotExist() {
            when(customerRepository.findById(2L)).thenReturn(Optional.empty());

            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                bookingService.createBooking(1, 1, 2, 1, date.getTime());
            });

            String expectedMessage = "customer id not found";
            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));
        }

        @Test
        void createBooking_Exception_IfServiceIdDoesNotExist() {
            when(businessServiceRepository.findById(2)).thenReturn(Optional.empty());

            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                bookingService.createBooking(1, 1, 1, 2, date.getTime());
            });

            String expectedMessage = "service id not found";
            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));
        }

        @Test
        void createBooking_Exception_IfDateIsPast() {
            Booking booking = new Booking();
            Mockito.lenient().when(bookingRepository.save(any(Booking.class))).thenReturn(booking);

            long pastDateUpperLimit = getPastDateUpperLimit(date);

            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                bookingService.createBooking(1, 1, 1, 1, pastDateUpperLimit);
            });

            String expectedMessage = "date cannot be in the past";
            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));
        }
    }

    @Nested
    class RemoveBooking_And_CancelBooking {

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

        @Test
        void cancelBooking_True_IfBookingIdExists() {
            assertTrue(bookingService.cancelBooking(1));
        }

        @Test
        void cancelBooking_False_IfBookingIdSoesNotExist() {
            assertFalse(bookingService.cancelBooking(2));
        }
    }

    @Nested
    class GetAvailableBookings {

        private Employee employee;
        private BusinessServiceJob service;
        private Iterable<Booking> overlappingBookings;
        private Date date;

        @BeforeEach
        void init() {
            employee = new Employee(1, new Business(), "", "", "", "", "");
            service = new BusinessServiceJob(10, "");
            overlappingBookings = new ArrayList<>();
            date = new Date();

            Mockito.lenient().when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));
            Mockito.lenient().when(businessServiceRepository.findById(1)).thenReturn(Optional.of(service));
            Mockito.lenient().when(
                    bookingRepository.getOverlappingBookings(eq(1), any(Long.class), any(Long.class)))
                    .thenReturn(overlappingBookings);
        }

        @Test
        void getAvailableBookings_Bookings_IfAllArgsValid() {
            Iterable<BookingTimeOptionDTO> availableBookings =
                    bookingService.getAvailableBookings(1, 1, 1, date.getTime());
            assertNotNull(availableBookings);
        }

        @Test
        void getAvailableBookings_Exception_IfEmployeeIdDoesNotExist() {
            when(employeeRepository.findById(2)).thenReturn(Optional.empty());

            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                bookingService.getAvailableBookings(1, 2, 1, date.getTime());
            });

            String expectedMessage = "employee id not found";
            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));
        }

        @Test
        void getAvailableBookings_Exception_IfServiceIdDoesNotExist() {
            when(businessServiceRepository.findById(2)).thenReturn(Optional.empty());

            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                bookingService.getAvailableBookings(1, 1, 2, date.getTime());
            });

            String expectedMessage = "service id not found";
            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));
        }

        @Test
        void getAvailableBookings_Exception_IfDateIsPast() {
            long pastDateUpperLimit = getPastDateUpperLimit(date);

            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                bookingService.getAvailableBookings(1, 1, 1, pastDateUpperLimit);
            });

            String expectedMessage = "date cannot be in the past";
            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));
        }
    }

    @Nested
    class GetAllByCustomerId {

        List<Booking> bookings;
        Customer customer;

        @BeforeEach
        void init() {
            Booking booking = new Booking();
            customer = new Customer();
            customer.setUserId(1L);
            booking.setCustomer(customer);
            bookings = new ArrayList<>();
            bookings.add(booking);
        }

        @Test
        void getAllByCustomerId_Bookings_IfCustomerIdExists() {
            when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
            when(bookingRepository.findAll()).thenReturn(bookings);

            for (Booking b : bookingService.getAllByCustomerId(1L))
                assertEquals(1L, b.getCustomer().getUserId());
        }

        @Test
        void getAllByCustomerId_Exception_IfCustomerIdDoesNotExist() {
            when(customerRepository.findById(2L)).thenReturn(Optional.empty());

            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                bookingService.getAllByCustomerId(2L);
            });

            String expectedMessage = "customer id not found";
            String actualMessage = exception.getMessage();

            assertTrue(actualMessage.contains(expectedMessage));
        }
    }

    // Tests for cancelBooking() in above inner class RemoveBooking_CancelBooking
}
