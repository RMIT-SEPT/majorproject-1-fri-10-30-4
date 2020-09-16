package app.entity.user;

import java.util.List;

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

    @NotNull(message="Error: Business ID required")
    @Column(name="BUSINESS_ID")
    private int businessId;

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

    @ElementCollection
    private List<Integer> services;
    
    // For employee working times

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

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
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

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMondayTime() {
        if(mondayTime.equals(NO_SCHEDULE)){
            return null;
        }
        return mondayTime;
    }

    public void setMondayTime(String mondayTime) {
        if(mondayTime == null) {
            this.mondayTime = NO_SCHEDULE;
        }
    }

    public String getTuesdayTime() {
        if(tuesdayTime.equals(NO_SCHEDULE)){
            return null;
        }
        return tuesdayTime;
    }

    public void setTuesdayTime(String tuesdayTime) {
        if(tuesdayTime == null){
            this.mondayTime = NO_SCHEDULE;
        }
    }


    public String getWednesdayTime() {
        if(wednesdayTime.equals(NO_SCHEDULE)){
            return null;
        }
        return wednesdayTime;
    }

    public void setWednesdayTime(String wednesdayTime) {
        if(wednesdayTime == null){
            this.mondayTime = NO_SCHEDULE;
        }
    }



    public String getThursdayTime() {
        if(thursdayTime.equals(NO_SCHEDULE)){
            return null;
        }
        return thursdayTime;
    }

    public void setThursdayTime(String thursdayTime) {
        if(thursdayTime == null){
            this.mondayTime = NO_SCHEDULE;
        }
    }



    public String getFridayTime() {
        if(fridayTime.equals(NO_SCHEDULE)){
            return null;
        }
        return fridayTime;
    }

    public void setFridayTime(String fridayTime) {
        if(fridayTime == null){
            this.mondayTime = NO_SCHEDULE;
        }
    }



    public String getSaturdayTime() {
        if(saturdayTime.equals(NO_SCHEDULE)){
            return null;
        }
        return saturdayTime;
    }

    public void setSaturdayTime(String saturdayTime) {
        if(saturdayTime == null){
            this.mondayTime = NO_SCHEDULE;
        }
    }



    public String getSundayTime() {
        if(sundayTime.equals(NO_SCHEDULE)){
            return null;
        }
        return sundayTime;
    }

    public void setSundayTime(String sundayTime) {
        this.sundayTime = sundayTime;
    }

}
