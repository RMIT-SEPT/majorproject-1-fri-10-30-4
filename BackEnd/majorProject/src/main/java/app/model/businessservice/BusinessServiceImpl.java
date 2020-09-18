//package app.model.businessservice;
//
//import app.model.interfaces.employee.BusinessService;
//import javax.persistence.*;
//
//@Entity
//@Table(name="BUSINESS_SERVICE")
//public class BusinessServiceImpl implements BusinessService {
//    @Id
//    @Column(name = "SERVICE_ID", nullable = false)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Integer serviceID;
//
//    @Column(name = "BUSINESS_ID", nullable = false)
//    private Integer businessID;
//
//    @Column(name = "SERVICE_DURATION", nullable = false)
//    private Integer serviceDuration;
//
//    // This is optional for now (25/08/2020)
//    @Column(name = "SERVICE_DESC")
//    private String serviceDescription;
//
//
//    @Override
//    public Integer getServiceID() {
//        return serviceID;
//    }
//
//    @Override
//    public Integer getBusinessID() {
//        return businessID;
//    }
//
//    @Override
//    public Integer getServiceDuration() {
//        return serviceDuration;
//    }
//
//    @Override
//    public String getServiceDescription() {
//        return serviceDescription;
//    }
//
//    public void setServiceID(int serviceID) {
//        this.serviceID = serviceID;
//    }
//
//    public void setBusinessID(int businessID) {
//        this.businessID = businessID;
//    }
//
//    public void setServiceDuration(int serviceDuration) {
//        this.serviceDuration = serviceDuration;
//    }
//
//    public void setServiceDescription(String serviceDescription) {
//        this.serviceDescription = serviceDescription;
//    }
//}
//
//
