package app.entity;

import app.entity.user.Employee;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="SERVICE")
public class BusinessService {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="SERVICE_ID")
	private int serviceID;
	
	@ManyToOne
	@JoinColumn(name="BUSINESS_ID")
	private Business business;
	
	@ManyToMany(mappedBy="assignedServices")
	private Set<Employee> assignedEmployees = new HashSet<Employee>();
	
	//Length of the service in hours.
	@Column(name="SERVICE_LENGTH")
	private int serviceLength;
	
	@Column(name="SERVICE_DESCRIPTION")
	private String serviceDescription;
	
	BusinessService(){};
	
	BusinessService(int length, String description){
		this.serviceLength = length;
		this.serviceDescription = description;
	}
	
	public int getServiceID() {
		return this.serviceID;
	}
	
	public Business getBusiness() {
		return this.business;
	}
	
	/**
	 * @param business Business that will now own this service.
	 * This method should not be called outside of the entity.Business class.
	 */
	public void setBusiness(Business business) {
		this.business = business;
	}
	
	public int getServiceLength() {
		return this.serviceLength;
	}
	
	public String getServiceDescription() {
		return this.serviceDescription;
	}
	
	public Set<Employee> getAssignedEmployees(){
		return this.assignedEmployees;
	}
	
}
