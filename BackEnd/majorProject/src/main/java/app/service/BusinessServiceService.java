package app.service;

import app.entity.BusinessService;
import app.repository.BusinessServiceRepository;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceService {

    @Autowired
    private BusinessServiceRepository businessServiceRepository;

    public Iterable<BusinessService> getAll() {
        return businessServiceRepository.findAll();
    }
    
    public BusinessService getById(int serviceID) {
    	try {
    		return businessServiceRepository.findById(serviceID).get();
    	} catch (NoSuchElementException e) {
    		return null;
    	}
    }

    public BusinessService createService(BusinessService businessService){
        return businessServiceRepository.save(businessService);
    }

    public boolean removeService(Integer serviceID){
        for(BusinessService service : getAll()){
            if(service.getServiceID() == serviceID) {
                businessServiceRepository.deleteById(serviceID);
                return true;
            }
        }
        return false;
    }
}
