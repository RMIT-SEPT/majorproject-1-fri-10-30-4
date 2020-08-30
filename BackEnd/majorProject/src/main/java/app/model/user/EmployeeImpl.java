package app.model.user;

import app.model.interfaces.user.Employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="EMPLOYEE")
public class EmployeeImpl extends UserImpl implements Employee {

    @Column(name="BUSINESS_ID", nullable = false, length=100, unique=true)
    private int businessID;
    @Column(name="PHONE_NUMBER", nullable = false, length=20)
    private String phoneNumber;
    @ElementCollection
    private List<Integer> services;

    /**
     * Default constructor for Hibernate.
     * Do not use.
     */
    public EmployeeImpl() {}
    
//    public EmployeeImpl(int userID, int businessID, String phoneNumber, List<Integer> services){
//        this.userID = userID;
//        this.businessID = businessID;
//        this.phoneNumber = phoneNumber;
//        this.services = services;
//    }

    @Override
    public int getBusinessID() {
        return businessID;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public List<Integer> getServices() {
        return services;
    }


    public void setBusinessID(int businessID) {
        this.businessID = businessID;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
