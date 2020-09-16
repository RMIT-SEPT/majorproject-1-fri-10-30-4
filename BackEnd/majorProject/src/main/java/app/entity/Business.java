package app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import app.entity.user.Employee;

@Entity
@Table(name="BUSINESS")
public class Business {
    @Id
    @Column(name="BUSINESS_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int businessId;

    @Column(name = "BUSINESS_TITLE")
    private String businessTitle;

    @OneToMany(mappedBy = "business")
    private List<BusinessService> availableServices = new ArrayList<BusinessService>();
    
    @OneToMany(mappedBy = "business")
    private List<Employee> employees = new ArrayList<Employee>();
    
    public int getBusinessID() { return businessId; }

    public String getBusinessTitle() { return businessTitle; }

    public void setBusinessTitle(String businessTitle) { this.businessTitle = businessTitle; }

    public void addService(BusinessService service) {
    	this.availableServices.add(service);
    	service.setBusiness(this);
    }
    
    public void removeService(BusinessService service) {
    	this.availableServices.remove(service);
    	service.setBusiness(null);
    }
    
}
