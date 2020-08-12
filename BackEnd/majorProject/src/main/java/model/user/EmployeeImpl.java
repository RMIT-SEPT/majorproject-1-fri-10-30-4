package model.user;

import model.interfaces.user.Employee;
import model.user.UserRole;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="employee")
public class EmployeeImpl implements Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int userID;
    private int businessID;
    private String phoneNumber;
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
