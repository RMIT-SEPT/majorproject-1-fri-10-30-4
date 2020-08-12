package app.model.user;

import app.model.interfaces.user.Employee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="employee")
public class EmployeeImpl implements Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int userID;
    @Column(name="businessID", nullable = false, length=100, unique=true)
    private int businessID;
    @Column(name="phoneNumber", nullable = false, length=20)
    private String phoneNumber;
    @Column(name="services", nullable = false, length=255)
    private List<Integer> services;

    public EmployeeImpl(int userID, int businessID, String phoneNumber, List<Integer> services){
        this.userID = userID;
        this.businessID = businessID;
        this.phoneNumber = phoneNumber;
        this.services = services;
    }

    @Override
    public int getUserID() {
        return userID;
    }

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

}
