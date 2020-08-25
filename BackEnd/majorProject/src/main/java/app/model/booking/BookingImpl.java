package app.model.booking;

import app.model.interfaces.booking.Booking;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="BOOKING")
public class BookingImpl implements Booking {
    @Id
    @Column(name="BOOKING_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer bookingID;

    @Column(name="SERVICE_ID", nullable = false)
    @NotEmpty(message ="Error: Please provide a service ID.")
    private int serviceID;

    @Column(name="CUSTOMER_ID", nullable = false)
    @NotEmpty(message ="Error: Please provide a customer ID.")
    private int customerID;

    @Column(name="EMPLOYEE_ID", nullable = false)
    @NotEmpty(message ="Error: Please provide a employee ID.")
    private int employeeID;

    @Column(name="DATE", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    @NotBlank(message = "Error: Date required for booking.")
    private LocalDate bookingDate;

    @Column(name="START_TIME", nullable = false)
    @JsonFormat(pattern="HH:mm")
    @NotBlank(message = "Error: Time required for booking.")
    private LocalTime bookingStartTime;

    @Column(name="BOOKING_DESC")
    private String bookingDescription;

    @Column(name="IS_ACTIVE", nullable = false)
    @NotNull(message = "Error: Booking must be either active or inactive (true or false).")
    private Boolean isActive;


    public BookingImpl() {

    }

    @Override
    public Integer getBookingID() {
        return bookingID;
    }

    @Override
    public int getCustomerUserID() {
        return customerID;
    }

    @Override
    public int getEmployeeUserID() {
        return employeeID;
    }

    @Override
    public int getServiceID() {
        return serviceID;
    }

    @Override
    public String getBookingDescription() {
        return bookingDescription;
    }

    @Override
    public Boolean getIsActive() {
        return isActive;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }


    public LocalTime getBookingStartTime() {

        return bookingStartTime;
    }

    public void setBookingID(Integer bookingID) {

        this.bookingID = bookingID;
    }

    public void setCustomerID(int customerID) {

        this.customerID = customerID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }


    public void setServiceID(int serviceID) {

        this.serviceID = serviceID;
    }

    public void setBookingDescription(String bookingDescription) {

        this.bookingDescription = bookingDescription;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    public void setBookingDate(LocalDate bookingDate){
        this.bookingDate = bookingDate;
    }


    public void setBookingStartTime(LocalTime bookingStartTime) {
        this.bookingStartTime = bookingStartTime;
    }
}
