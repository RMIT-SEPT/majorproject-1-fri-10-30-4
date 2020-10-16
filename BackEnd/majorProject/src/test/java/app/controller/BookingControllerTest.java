package app.controller;

import app.entity.Booking;
import app.entity.Business;
import app.entity.BusinessServiceJob;
import app.entity.user.Customer;
import app.entity.user.Employee;
import app.security.JwtAuthenticationEntryPoint;
import app.security.JwtTokenProvider;
import app.service.BookingService;
import app.service.CustomUserDetailsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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

    private Booking booking;
    private Date dateObj;

    @BeforeEach
    void init() {
        BusinessServiceJob businessServiceJob = new BusinessServiceJob();
        Employee employee = new Employee(1, new Business(), "", "", "", "", "");
        Customer customer = new Customer();
        dateObj = new Date();

        customer.setUserId(1L);
        booking = new Booking(businessServiceJob, employee, customer, dateObj.getTime(), "");
    }

    @Test
    void getBookingsByCustomerId_BookingsAndOk_IfCustomerIdIsValid() throws Exception{
        Long customerID = 1L;
        ArrayList<Booking> bookings = new ArrayList<>();
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
}
