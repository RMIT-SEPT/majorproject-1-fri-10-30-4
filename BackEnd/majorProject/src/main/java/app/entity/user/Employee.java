package app.entity.user;

import app.entity.Business;
import app.entity.BusinessServiceJob;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="EMPLOYEE")
public class Employee {
    static String NO_SCHEDULE = "NO_SCHEDULE";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="EMPLOYEE_ID", unique=true)
    private int employeeId;

    @ManyToOne
    @JoinColumn(name = "BUSINESS_ID", nullable = true)
    private Business business = null;

    @NotBlank(message="Error: First name required")
    @Column(name="FIRST_NAME")
    private String firstName;

    @NotBlank(message="Error: Last name required")
    @Column(name="LAST_NAME")
    private String lastName;

    @NotBlank(message="Error: Email required")
    @Column(name="EMAIL")
    private String email;

    @NotBlank(message="Error: Password required")
    @Column(name="PASSWORD_HASH")
    private String passwordHash;

    @NotBlank(message="Error: Phone Number required")
    @Column(name="PHONE_NUMBER")
    private String phoneNumber;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name="EMPLOYEE_SERVICE",
    	joinColumns = {@JoinColumn(name="EMPLOYEE_ID")}, 
    	inverseJoinColumns = {@JoinColumn(name="SERVICE_ID")}
    )
    private Set<BusinessServiceJob> assignedServices = new HashSet<BusinessServiceJob>();
    
    // For employee working times
    //TODO: Implement "shift" style system to replace this in future.
    @Column(name="MONDAY_TIME")
    private String mondayTime;

    @Column(name="TUESDAY_TIME")
    private String tuesdayTime;

    @Column(name="WEDNESDAY_TIME")
    private String wednesdayTime;

    @Column(name="THURSDAY_TIME")
    private String thursdayTime;

    @Column(name="FRIDAY_TIME")
    private String fridayTime;

    @Column(name="SATURDAY_TIME")
    private String saturdayTime;

    @Column(name="SUNDAY_TIME")
    private String sundayTime;

    
    /**
     * Needed for Hibernate.
     * Do not use.
     */
    public Employee() {};
    
    public Employee(int employeeID, Business business, String firstName, String lastName, 
    	String email, String passwordHash, String phoneNumber)
    {
    	this.employeeId = employeeID;
    	this.business = business;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.email = email;
    	this.passwordHash = passwordHash;
    	this.phoneNumber = phoneNumber;
    	this.mondayTime = "";
    	this.tuesdayTime = "";
    	this.wednesdayTime = "";
    	this.thursdayTime = "";
    	this.fridayTime = "";
    	this.saturdayTime = "";
    	this.sundayTime = "";
    }
    
    public Set<BusinessServiceJob> getServices() {
        return this.assignedServices;
    }

    public void addService(BusinessServiceJob service) {
        this.assignedServices.add(service);
        service.getAssignedEmployees().add(this);
    }
    
    public void removeService(BusinessServiceJob service) {
    	this.assignedServices.remove(service);
    	service.getAssignedEmployees().remove(this);
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Business getBusiness() {
        return this.business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMondayTime() {
        if(mondayTime.equals(NO_SCHEDULE)){
            return "";
        }
        return mondayTime;
    }

    public void setMondayTime(String mondayTime) {
        if(mondayTime.isBlank()) {
            this.mondayTime = NO_SCHEDULE;
        }
        this.mondayTime = mondayTime;
    }

    public String getTuesdayTime() {
        if(tuesdayTime.equals(NO_SCHEDULE)){
            return "";
        }
        return tuesdayTime;
    }

    public void setTuesdayTime(String tuesdayTime) {
        if(tuesdayTime.isBlank()){
            this.tuesdayTime = NO_SCHEDULE;
        }
        this.tuesdayTime = tuesdayTime;
    }


    public String getWednesdayTime() {
        if(wednesdayTime.equals(NO_SCHEDULE)){
            return "";
        }
        return wednesdayTime;
    }

    public void setWednesdayTime(String wednesdayTime) {
        if(wednesdayTime.isBlank()){
            this.wednesdayTime = NO_SCHEDULE;
        }
        this.wednesdayTime = wednesdayTime;
    }



    public String getThursdayTime() {
        if(thursdayTime.equals(NO_SCHEDULE)){
            return "";
        }
        return thursdayTime;
    }

    public void setThursdayTime(String thursdayTime) {
        if(thursdayTime.isBlank()){
            this.mondayTime = NO_SCHEDULE;
        }
        this.thursdayTime = thursdayTime;
    }



    public String getFridayTime() {
        if(fridayTime.equals(NO_SCHEDULE)){
            return "";
        }
        return fridayTime;
    }

    public void setFridayTime(String fridayTime) {
        if(fridayTime.isBlank()){
            this.fridayTime = NO_SCHEDULE;
        }
        this.fridayTime = fridayTime;
    }

    public String getSaturdayTime() {
        if(saturdayTime.equals(NO_SCHEDULE)){
            return "";
        }
        return saturdayTime;
    }

    public void setSaturdayTime(String saturdayTime) {
        if(saturdayTime.isBlank()){
            this.saturdayTime = NO_SCHEDULE;
        }
        this.saturdayTime = saturdayTime;
    }



    public String getSundayTime() {
        if(sundayTime.equals(NO_SCHEDULE)){
            return "";
        }
        return sundayTime;
    }

    public void setSundayTime(String sundayTime) {
        if(sundayTime.isBlank()){
            this.sundayTime = NO_SCHEDULE;
        }
        this.sundayTime = sundayTime;
    }

}
