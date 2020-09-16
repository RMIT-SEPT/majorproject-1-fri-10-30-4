/*
    Author: Nikita
 */

package app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import app.entity.user.Employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="BOOKING")
public class Booking {
    @Id
    @Column(name="BOOKING_ID", unique=true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer bookingId;

    @ManyToOne
    @JoinColumn(name="SERVICE_ID")
    private BusinessService service;

    @Column(name="CUSTOMER_ID")
    @NotEmpty(message ="Error: Customer ID required")
    private int customerId;

    @ManyToOne
    @JoinColumn(name="EMPLOYEE_ID")
    private Employee employee;

    @Column(name="DATE")
    @JsonFormat(pattern="yyyy-MM-dd")
    @NotBlank(message = "Error: Date required for booking.")
    private LocalDate bookingDate;

    @Column(name="START_TIME")
    @JsonFormat(pattern="HH:mm")
    @NotBlank(message = "Error: Time required for booking.")
    private LocalTime bookingStartTime;

    @Column(name="BOOKING_DESC")
    private String bookingDescription;

    @Column(name="IS_ACTIVE")
    @NotNull(message = "Error: Booking must be either active or inactive (true or false).")
    private Boolean isActive;

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public BusinessService getService() {
        return this.service;
    }

    public void setService(BusinessService service) {
        this.service = service;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalTime getBookingStartTime() {
        return bookingStartTime;
    }

    public void setBookingStartTime(LocalTime bookingStartTime) {
        this.bookingStartTime = bookingStartTime;
    }

    public String getBookingDescription() {
        return bookingDescription;
    }

    public void setBookingDescription(String bookingDescription) {
        this.bookingDescription = bookingDescription;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
