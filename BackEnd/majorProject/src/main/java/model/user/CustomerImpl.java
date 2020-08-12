package model.user;

import model.interfaces.user.Customer;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class CustomerImpl implements Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int userID;
    private String phoneNumber;
    private String address;

    public CustomerImpl(int userID, String phoneNumber, String address){
        this.userID = userID;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    @Override
    public int getUserID() {
        return userID;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String getAddress() {
        return address;
    }
}
