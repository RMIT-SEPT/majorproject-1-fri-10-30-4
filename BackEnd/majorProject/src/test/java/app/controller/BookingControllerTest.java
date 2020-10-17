package app.controller;

import app.entity.Booking;
import app.entity.Business;
import app.entity.BusinessServiceJob;
import app.entity.user.Customer;
import app.entity.user.Employee;
import app.model.booking.BookingTimeOptionDTO;
import app.security.JwtAuthenticationEntryPoint;
import app.security.JwtTokenProvider;
import app.service.BookingService;
import app.service.CustomUserDetailsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookingController.class)
public class BookingControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @MockBean
    private CustomUserDetailsService customUserDetailsService;
    @MockBean
    private JwtTokenProvider jwtTokenProvider;

    @MockBean
    BookingService bookingService;

    private Booking getTestBooking() {
        BusinessServiceJob businessServiceJob = new BusinessServiceJob();
        Employee employee = new Employee(1, new Business(), "", "", "", "", "");
        Customer customer = new Customer();

        customer.setUserId(1L);
        return new Booking(businessServiceJob, employee, customer, 1, "");
    }

    @Test
    void getBookingsByCustomerId_BookingsAndOk_IfCustomerIdIsValid() throws Exception{
        Long customerID = 1L;
        ArrayList<Booking> bookings = new ArrayList<>();
        Booking booking = getTestBooking();

        bookings.add(booking);
        when(bookingService.getAllByCustomerId(customerID)).thenReturn(bookings);

        mvc.perform(get("/booking/allbyid")
                .param("customerID", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].customer.userId").value(customerID));
    }

    @Test
    void getBookingsByCustomerId_MessageAndBadRequest_IfCustomerIdNotValid() throws Exception{
        Long customerID = 2L;
        String message = "Error: customer id not found";

        //when(bookingService.getAllByCustomerId(customerID)).thenThrow(new IllegalArgumentException(message));
        when(bookingService.getAllByCustomerId(customerID)).thenReturn(null);

        mvc.perform(get("/booking/allbyid")
                .param("customerID", "2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(message));
    }

    @Test
    void createBooking_BookingAndOk_IfValidRequest() throws Exception {
        int customerID = 1;
        Booking booking = getTestBooking();
        when(bookingService.createBooking(1, 1, customerID, 1, 1)).thenReturn(booking);

        mvc.perform(post("/booking/create")
                .param("businessID", "1")
                .param("customerID", "1")
                .param("employeeID", "1")
                .param("serviceID", "1")
                .param("date", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.customer.userId").value(customerID));
    }

    @Test
    void createBooking_MessageAndBadRequest_IfBusinessIdNotValid() throws Exception {
        int businessID = 2;
        String message = "Error: invalid request parameter(s)";

        when(bookingService.createBooking(businessID, 1, 1, 1, 1)).thenReturn(null);

        mvc.perform(post("/booking/create")
                .param("businessID", "2")
                .param("customerID", "1")
                .param("employeeID", "1")
                .param("serviceID", "1")
                .param("date", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(message));
    }

    @Test
    void createBooking_MessageAndBadRequest_IfEmployeeIdNotValid() throws Exception {
        int employeeID = 2;
        String message = "Error: invalid request parameter(s)";

        when(bookingService.createBooking(1, employeeID, 1, 1, 1)).thenReturn(null);

        mvc.perform(post("/booking/create")
                .param("businessID", "1")
                .param("customerID", "1")
                .param("employeeID", "2")
                .param("serviceID", "1")
                .param("date", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(message));
    }

    @Test
    void createBooking_MessageAndBadRequest_IfCustomerIdNotValid() throws Exception {
        int customerID = 2;
        String message = "Error: invalid request parameter(s)";

        when(bookingService.createBooking(1, 1, customerID, 1, 1)).thenReturn(null);

        mvc.perform(post("/booking/create")
                .param("businessID", "1")
                .param("customerID", "2")
                .param("employeeID", "1")
                .param("serviceID", "1")
                .param("date", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(message));
    }

    @Test
    void createBooking_MessageAndBadRequest_IfServiceIdNotValid() throws Exception {
        int serviceID = 2;
        String message = "Error: invalid request parameter(s)";

        when(bookingService.createBooking(1, 1, 1, serviceID, 1)).thenReturn(null);

        mvc.perform(post("/booking/create")
                .param("businessID", "1")
                .param("customerID", "1")
                .param("employeeID", "1")
                .param("serviceID", "2")
                .param("date", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(message));
    }

    @Test
    void createBooking_MessageAndBadRequest_IfDateNotValid() throws Exception {
        int pastDate = 2;
        String message = "Error: invalid request parameter(s)";

        when(bookingService.createBooking(1, 1, 1, 1, pastDate)).thenReturn(null);

        mvc.perform(post("/booking/create")
                .param("businessID", "1")
                .param("customerID", "1")
                .param("employeeID", "1")
                .param("serviceID", "2")
                .param("date", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(message));
    }

    @Test
    void cancelBooking_MessageAndOk_IfBookingIdIsValid() throws Exception {
        Integer bookingId = 1;
        String message = "Booking #" + bookingId.toString() + " successfully cancelled.";

        when(bookingService.cancelBooking(bookingId)).thenReturn(true);

        mvc.perform(put("/booking/cancel")
                .param("bookingId", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(message));
    }

    @Test
    void cancelBooking_MessageAndBadRequest_IfBookingIdIsNull() throws Exception {
        String message = "Error: Failed to cancel booking. Please enter a booking ID.";
        mvc.perform(put("/booking/cancel")
                .param("bookingId", "")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(message));
    }

    @Test
    void cancelBooking_MessageAndBadRequest_IfBookingIdDoesNotExist() throws Exception {
        Integer bookingId = 2;
        String message = "Error: Failed to cancel booking #" + bookingId.toString() + "\n" +
                "Booking not found.";

        when(bookingService.cancelBooking(bookingId)).thenReturn(false);

        mvc.perform(put("/booking/cancel")
                .param("bookingId", "2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(message));
    }

    @Test
    void removeBooking_MessageAndOk_IfBookingIdIsValid() throws Exception {
        Integer bookingId = 1;
        String message = "Booking #" + bookingId.toString() + " successfully removed.";

        when(bookingService.removeBooking(bookingId)).thenReturn(true);

        mvc.perform(delete("/booking/remove")
                .param("bookingId", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(message));
    }

    @Test
    void removeBooking_MessageAndBadRequest_IfBookingIdIsNull() throws Exception {
        String message = "Error: Failed to remove booking. Please enter a booking ID.";
        mvc.perform(delete("/booking/remove")
                .param("bookingId", "")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(message));
    }

    @Test
    void removeBooking_MessageAndBadRequest_IfBookingIdDoesNotExist() throws Exception {
        Integer bookingId = 2;
        String message = "Error: Failed to remove booking #" + bookingId.toString() + "\n" +
                "Booking not found.";

        when(bookingService.removeBooking(bookingId)).thenReturn(false);

        mvc.perform(delete("/booking/remove")
                .param("bookingId", "2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(message));
    }

    @Test
    void findAvailableBookings_AvailableTimesAndOk_IfValidRequest() throws Exception {
        ArrayList<BookingTimeOptionDTO> availableTimes = new ArrayList<>();
        BookingTimeOptionDTO bookingTimeOption = new BookingTimeOptionDTO(LocalTime.of(8,0), LocalTime.of(12,0));

        availableTimes.add(bookingTimeOption);
        when(bookingService.getAvailableBookings(1, 1, 1, 1)).thenReturn(availableTimes);

        mvc.perform(get("/booking/getAvailbleTimes")
                .param("businessID", "1")
                .param("employeeID", "1")
                .param("serviceID", "1")
                .param("date", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].shiftStart").value("08:00:00"))
                .andExpect(jsonPath("$[0].shiftEnd").value("12:00:00"));
    }

    @Test
    void findAvailableBookings_MessageAndBadRequest_IfBusinessIdIsNull() throws Exception {
        String message = "Error: Please enter a business ID.";
        mvc.perform(get("/booking/getAvailbleTimes")
                .param("businessID", "")
                .param("employeeID", "1")
                .param("serviceID", "1")
                .param("date", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(message));
    }

    @Test
    void findAvailableBookings_MessageAndBadRequest_IfBusinessIdDoesNotExist() throws Exception {
        Integer businessId = 2;
        String message = "Error: invalid request parameter(s)";

        when(bookingService.getAvailableBookings(businessId, 1, 1, 1)).thenReturn(null);

        mvc.perform(get("/booking/getAvailbleTimes")
                .param("businessID", "2")
                .param("employeeID", "1")
                .param("serviceID", "1")
                .param("date", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(message));
    }

    @Test
    void findAvailableBookings_MessageAndBadRequest_IfEmployeeIdIsNull() throws Exception {
        String message = "Error: Please enter an employee ID.";
        mvc.perform(get("/booking/getAvailbleTimes")
                .param("businessID", "1")
                .param("employeeID", "")
                .param("serviceID", "1")
                .param("date", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(message));
    }

    @Test
    void findAvailableBookings_MessageAndBadRequest_IfEmployeeIdDoesNotExist() throws Exception {
        Integer employeeId = 2;
        String message = "Error: invalid request parameter(s)";

        when(bookingService.getAvailableBookings(1, employeeId, 1, 1)).thenReturn(null);

        mvc.perform(get("/booking/getAvailbleTimes")
                .param("businessID", "1")
                .param("employeeID", "2")
                .param("serviceID", "1")
                .param("date", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(message));
    }

    @Test
    void findAvailableBookings_MessageAndBadRequest_IfServiceIdIsNull() throws Exception {
        String message = "Error: Please enter a service ID.";
        mvc.perform(get("/booking/getAvailbleTimes")
                .param("businessID", "1")
                .param("employeeID", "1")
                .param("serviceID", "")
                .param("date", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(message));
    }

    @Test
    void findAvailableBookings_MessageAndBadRequest_IfServiceIdDoesNotExist() throws Exception {
        Integer serviceID = 2;
        String message = "Error: invalid request parameter(s)";

        when(bookingService.getAvailableBookings(1, 1, serviceID, 1)).thenReturn(null);

        mvc.perform(get("/booking/getAvailbleTimes")
                .param("businessID", "1")
                .param("employeeID", "1")
                .param("serviceID", "2")
                .param("date", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(message));
    }

    @Test
    void findAvailableBookings_MessageAndBadRequest_IfDateIsNull() throws Exception {
        String message = "Error: Please enter a date.";
        mvc.perform(get("/booking/getAvailbleTimes")
                .param("businessID", "1")
                .param("employeeID", "1")
                .param("serviceID", "1")
                .param("date", "")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(message));
    }

    @Test
    void findAvailableBookings_MessageAndBadRequest_IfDateNotValid() throws Exception {
        Long date = 2L;
        String message = "Error: invalid request parameter(s)";

        when(bookingService.getAvailableBookings(1, 1, 1, date)).thenReturn(null);

        mvc.perform(get("/booking/getAvailbleTimes")
                .param("businessID", "1")
                .param("employeeID", "1")
                .param("serviceID", "1")
                .param("date", "2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(message));
    }

    @Test
    void getBookingById_BookingAndOk_IfBookingIdIsValid() throws Exception {
        Integer bookingID = 1;
        ArrayList<Booking> bookings = new ArrayList<>();
        Booking booking = getTestBooking();

        bookings.add(booking);
        when(bookingService.findByID(bookingID)).thenReturn(Optional.of(booking));

        mvc.perform(get("/booking/{bookingID}", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.customer.userId").value(bookingID));
    }

    @Test
    void getBookingById_BookingAndNotFound_IfBookingIdNotFound() throws Exception {
        Integer bookingID = 2;
        String message = "Error: booking id " + bookingID + " not found";

        when(bookingService.findByID(bookingID)).thenThrow(NoSuchElementException.class);

        mvc.perform(get("/booking/{bookingID}", "2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(message));
    }
}
