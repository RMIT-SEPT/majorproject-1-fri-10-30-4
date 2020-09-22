//package app.model.user;
//
//import app.model.interfaces.user.Customer;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="CUSTOMER")
//public class CustomerImpl implements Customer {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private int userID;
//    @Column(name="PHONE_NUMBER", nullable = false, length=255, unique=true)
//    private String phoneNumber;
//    @Column(name="ADDRESS", nullable = false, length=255, unique=true)
//    private String address;
//
//
//    /**
//     * Default constructor needed for Hibernate.
//     * Do not use.
//     */
//    public CustomerImpl() {}
//
//    public CustomerImpl(int userID, String phoneNumber, String address){
//        this.userID = userID;
//        this.phoneNumber = phoneNumber;
//        this.address = address;
//    }
//
//    @Override
//    public int getUserID() {
//        return userID;
//    }
//
//    @Override
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    @Override
//    public String getAddress() {
//        return address;
//    }
//
//    public void setUserID(int userID) {
//        this.userID = userID;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//}
