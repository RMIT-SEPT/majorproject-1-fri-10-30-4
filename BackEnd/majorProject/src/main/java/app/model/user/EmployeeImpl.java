//package app.model.user;
//
//import app.model.interfaces.user.Employee;
//
//import javax.persistence.*;
//import java.util.List;
//
////@Entity
////@Table(name="EMPLOYEE")
//public class EmployeeImpl extends UserImpl implements Employee {
//
//    @Column(name="BUSINESS_ID")
//    private int businessId;
//    @Column(name="PHONE_NUMBER")
//    private String phoneNumber;
//    @ElementCollection
//    private List<Integer> services;
//    private String availabilityTime;
//    private String availabilityDay;
//
//    public void setAvailabilityTime(String availabilityTime) {
//        this.availabilityTime = availabilityTime;
//    }
//
//    public void setAvailabilityDay(String availabilityDay) {
//        this.availabilityDay = availabilityDay;
//    }
//
//    public String getAvailabilityTime() {
//        return availabilityTime;
//    }
//
//    public String getAvailabilityDay() {
//        return availabilityDay;
//    }
//
//    /**
//     * Default constructor for Hibernate.
//     * Do not use.
//     */
////    public EmployeeImpl() {
////    }
//
////    public EmployeeImpl(int userID, int businessID, String phoneNumber, List<Integer> services){
////        this.userID = userID;
////        this.businessID = businessID;
////        this.phoneNumber = phoneNumber;
////        this.services = services;
////    }
//
//    @Override
//    public int getBusinessId() {
//        return businessId;
//    }
//
//    @Override
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    @Override
//    public List<Integer> getServices() {
//        return services;
//    }
//
//
//    public void setBusinessID(int businessID) {
//        this.businessId = businessId;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//}
