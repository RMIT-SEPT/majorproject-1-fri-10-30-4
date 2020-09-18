package app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @OneToMany(mappedBy = "business", cascade=CascadeType.ALL)
    @JsonIgnore
    private List<BusinessServiceJob> availableServices = new ArrayList<BusinessServiceJob>();
    
    @OneToMany(mappedBy = "business", cascade=CascadeType.ALL)
    @JsonIgnore
    private List<Employee> employees = new ArrayList<Employee>();
    
    /**
     * Needed for hibernate.
     * Do not use.
     */
    public Business() {};
    
    public Business(String name, int ID) {
    	this.businessTitle = name;
    	this.businessId = ID;
    }
    
    public int getBusinessID() { return businessId; }

    public void setBusinessID(int newID) {
    	this.businessId = newID;
    }
    
    public String getBusinessTitle() { return businessTitle; }

    public void setBusinessTitle(String businessTitle) { this.businessTitle = businessTitle; }

    @JsonIgnore
    public List<BusinessServiceJob> getAllServices(){
    	return this.availableServices;
    }
    
    public void addService(BusinessServiceJob service) {
    	this.availableServices.add(service);
    	service.setBusiness(this);
    }
    
    public void removeService(BusinessServiceJob service) {
    	this.availableServices.remove(service);
    	service.setBusiness(null);
    }
    
    
}
