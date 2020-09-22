/*
    Author: Nikita
 */

package app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import app.entity.user.Customer;
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
    private BusinessServiceJob service;

    @ManyToOne
    @JoinColumn(name="CUSTOMER_ID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="EMPLOYEE_ID")
    private Employee employee;

    @Column(name="BOOKING_START")
    private Long startTime;
    
    @Column(name="BOOKING_END")
    private Long endTime;
    
    
    @Column(name="BOOKING_DESC")
    private String bookingDescription;

    @Column(name="IS_ACTIVE")
    @NotNull(message = "Error: Booking must be either active or inactive (true or false).")
    private Boolean isActive;

    public Booking() {};
    
    public Booking(BusinessServiceJob service, Employee employee, Customer customer, long date, String description) {
    	this.service = service;
    	this.employee = employee;
    	this.customer = customer;
    	this.startTime = date;
    	this.endTime = date + service.getServiceLength() * 60 * 1000;
    	this.bookingDescription = description;
    	this.isActive = true;
    }
    
    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public long getBookingStart() {
    	return this.startTime;
    }
    
    public void setBookingStart(long date) {
    	this.startTime = date;
    }
    
    public long getBookingEnd() {
    	return this.endTime;
    }
    
    public void setBookingEnd(long date) {
    	this.endTime = date;
    }
    
    
    public BusinessServiceJob getService() {
        return this.service;
    }

    public void setService(BusinessServiceJob service) {
        this.service = service;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

//    public LocalDate getBookingDate() {
//        return bookingDate;
//    }
//
//    public void setBookingDate(LocalDate bookingDate) {
//        this.bookingDate = bookingDate;
//    }

//    public LocalTime getBookingStartTime() {
//        return bookingStartTime;
//    }
//
//    public void setBookingStartTime(LocalTime bookingStartTime) {
//        this.bookingStartTime = bookingStartTime;
//    }

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
