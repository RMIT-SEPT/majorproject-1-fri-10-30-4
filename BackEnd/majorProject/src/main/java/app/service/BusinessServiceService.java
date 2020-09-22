package app.service;

import app.entity.BusinessServiceJob;
import app.entity.user.Employee;
import app.repository.BusinessServiceRepository;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceService {

    @Autowired
    private BusinessServiceRepository businessServiceRepository;

    public Iterable<BusinessServiceJob> getAll() {
        return businessServiceRepository.findAll();
    }
    
    public BusinessServiceJob getById(int serviceID) {
    	try {
    		return businessServiceRepository.findById(serviceID).get();
    	} catch (NoSuchElementException e) {
    		return null;
    	}
    }

    public BusinessServiceJob createService(BusinessServiceJob businessService){
        return businessServiceRepository.save(businessService);
    }
    
    public BusinessServiceJob saveService(BusinessServiceJob businessService){
        return businessServiceRepository.save(businessService);
    }

    public boolean removeService(Integer serviceID){
        for(BusinessServiceJob service : getAll()){
            if(service.getServiceID() == serviceID) {
                businessServiceRepository.deleteById(serviceID);
                return true;
            }
        }
        return false;
    }
    
    public void removeAll() {
		for(BusinessServiceJob service : getAll()) {
			for(Employee employee : service.getAssignedEmployees()) {
				employee.removeService(service);
			}
		}
    	businessServiceRepository.deleteAll();
    }
}
