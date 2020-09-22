//package app.model.user;
//
//import app.model.interfaces.user.BusinessAdmin;
//import javax.persistence.*;
//
//@Entity
//@Table(name="BUSINESS_ADMIN")
//public class BusinessAdminImpl implements BusinessAdmin {
//    @Id
//    @Column(name="USER_ID")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private int userID;
//    @Column(name="BUSINESS_ID", nullable = false, length=100, unique=true)
//    private int businessID;
//
//
//    /**
//     * Default constructor needed for Hibernate.
//     * Do not use.
//     */
//    public BusinessAdminImpl() {}
//
//    public BusinessAdminImpl(int userID, int businessID){
//        this.userID = userID;
//        this.businessID = businessID;
//    }
//
//
//    @Override
//    public int getUserID() {
//        return userID;
//    }
//
//    @Override
//    public int getBusinessID() {
//        return businessID;
//    }
//
//    public void setUserID(int userID) {
//        this.userID = userID;
//    }
//
//    public void setBusinessID(int businessID) {
//        this.businessID = businessID;
//    }
//}
