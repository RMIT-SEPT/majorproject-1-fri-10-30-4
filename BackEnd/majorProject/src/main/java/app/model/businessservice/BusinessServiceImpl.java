package app.model.businessservice;

import app.model.interfaces.employee.BusinessService;
import javax.persistence.*;

@Entity
@Table(name="BUSINESS_SERVICE")
public class BusinessServiceImpl implements BusinessService {
    @Id
    @Column(name="SERVICE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int serviceID;

    @Column(name="SERVICE_TYPE")
    private String serviceType;

    @Column(name="SERVICE_DESC")
    private String serviceDescription;

    @Override
    public int getServiceID() {
        return serviceID;
    }

    @Override
    public String getServiceType() {
        return serviceType;
    }

    @Override
    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceType(String serviceType) {

        this.serviceType = serviceType;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }
}