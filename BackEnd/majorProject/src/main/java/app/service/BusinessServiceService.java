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
}
