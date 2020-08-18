package app.model.booking;

import app.model.interfaces.booking.Booking;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="BOOKING")
public class BookingImpl implements Booking {
    @Id
    @Column(name="BOOKING_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer bookingID;

    @Column(name="SERVICE_ID")
    private int serviceID;

    @Column(name="CUSTOMER_ID")
    private int customerID;

    @Column(name="EMPLOYEE_ID")
    private int employeeID;

    @Column(name="DATE")
    //@DateTimeFormat(pattern = "yyyy-mm-dd")
    //private LocalDateTime date;
    private String date;

    @Column(name="BOOKING_DURATION")
    private int bookingDuration;

    @Column(name="BOOKING_DESC")
    private String bookingDescription;

    @Column(name="IS_CANCELLED")
    private boolean isCancelled;




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
    public LocalDate getBookingDate() {
        return null;
    }

    @Override
    public LocalTime getBookingStartTime() {
        return null;
    }

    @Override
    public LocalTime getBookingEndTime() {
        return null;
    }

    @Override
    public int getBookingDuration() {
        return bookingDuration;
    }


    @Override
    public String getBookingDescription() {
        return bookingDescription;
    }

    @Override
    public boolean getIsCancelled() {
        return isCancelled;
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

    public void setBookingDuration(int bookingDuration) {
        this.bookingDuration = bookingDuration;
    }

    public void setBookingDescription(String bookingDescription) {
        this.bookingDescription = bookingDescription;
    }

    public void setCancelled(boolean cancelled) {
        isCancelled = cancelled;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getDate(){
        return date;
    }



}
