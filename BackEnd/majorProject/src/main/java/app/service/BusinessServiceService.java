package app.service;

import app.model.businessservice.BusinessServiceImpl;
import app.model.interfaces.employee.BusinessService;
import app.repository.BusinessServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceService {

    @Autowired
    private BusinessServiceRepository businessServiceRepository;

    public Iterable<BusinessServiceImpl> getAll() {
        return businessServiceRepository.findAll();
    }

    public BusinessServiceImpl createService(BusinessServiceImpl businessService){
        return businessServiceRepository.save(businessService);
    }

    public boolean removeService(Integer serviceID){
        for(BusinessServiceImpl service : getAll()){
            if(service.getServiceID() == serviceID) {
                businessServiceRepository.deleteById(serviceID);
                return true;
            }
        }
        return false;
    }
}
