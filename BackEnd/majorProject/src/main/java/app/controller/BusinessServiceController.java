package app.controller;


import app.model.businessservice.BusinessServiceImpl;
import app.model.interfaces.employee.BusinessService;
import app.service.BusinessServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
public class BusinessServiceController {

    @Autowired
    private BusinessServiceService businessServiceService;

    @GetMapping
    public Iterable<BusinessServiceImpl> getAllServices() {
        return businessServiceService.getAll();
    }

}
