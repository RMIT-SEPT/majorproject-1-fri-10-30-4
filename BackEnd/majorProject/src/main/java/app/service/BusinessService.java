package app.service;

import app.entity.Business;
import app.repository.BusinessRepository;
import app.repository.BusinessServiceRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    public Business saveBusiness(Business business) {
    	return businessRepository.save(business);
    }
    
    public Optional<Business> getById(int businessID){
    	return businessRepository.findById(businessID);
    }
    
    public Iterable<Business> getAll() {
        return businessRepository.findAll();
    }
}
