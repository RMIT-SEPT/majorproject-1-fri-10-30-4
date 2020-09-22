package app.entity;

import app.entity.user.Employee;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="SERVICE")
public class BusinessServiceJob {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="SERVICE_ID")
	private int serviceID;
	
	@ManyToOne
	@JoinColumn(name="BUSINESS_ID")
	private Business business;
	
	@ManyToMany(mappedBy="assignedServices")
	@JsonIgnore
	private Set<Employee> assignedEmployees = new HashSet<Employee>();
	
	//Length of the service in minutes.
	@Column(name="SERVICE_LENGTH")
	private int serviceLength;
	
	@Column(name="SERVICE_DESCRIPTION")
	private String serviceDescription;
		
	/**
	 * Needed for hibernate. 
	 * Do not use.
	 */
	public BusinessServiceJob() {
	}
	
	public BusinessServiceJob(int length, String description){
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
	
	/**
	 * @return Length of the service in minutes.
	 */
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
