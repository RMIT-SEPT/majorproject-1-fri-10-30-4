package app.controller;
/*
* Author: Harrison Burr
* */
import app.entity.user.BusinessAdmin;
import app.service.BusinessAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Business;
import app.entity.BusinessServiceJob;
import app.entity.user.Employee;
import app.service.BusinessService;
import app.service.BusinessServiceService;
import app.service.EmployeeService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/debug")
public class DebugController {

    @Autowired
    private BusinessServiceService businessServiceService;

    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private BusinessService businessService;

	@Autowired
	private BusinessAdminService businessAdminService;
    
    @GetMapping("/testData")
    public void refreshDBWithTestData() {
    	businessAdminService.removeAll();
    	employeeService.removeAll();
    	businessService.removeAll();
    	businessServiceService.removeAll();
    	Business eCorp = new Business("E Corp", 10);
    	eCorp = businessService.saveBusiness(eCorp);
    	eCorp = businessService.forceIDChange(eCorp, 10);
    	
    	BusinessServiceJob computerRepair = new BusinessServiceJob(10, "Computer Repair");
    	BusinessServiceJob assetManagement = new BusinessServiceJob(20, "Asset Management");
    	businessServiceService.createService(computerRepair);
    	businessServiceService.createService(assetManagement);
    	
    	eCorp.addService(computerRepair);
    	eCorp.addService(assetManagement);
    	businessService.saveBusiness(eCorp);
    	businessServiceService.saveService(computerRepair);
    	businessServiceService.saveService(assetManagement);
    	
    	Employee philPrice = new Employee(100, eCorp, "Phillip", "Price", "philPrice@email.com", "greatPasswordHash", "0400111222");
    	Employee elliotAlderson = new Employee(101, eCorp, "Elliot", "Alderson", "elliotAlderson@email.com", "greatPasswordHash", "0433444555");
    	Employee angelaMoss = new Employee(102, eCorp, "Angela", "Moss", "angelaMoss@email.com", "greatPasswordHash", "0477888999");
    	elliotAlderson.setMondayTime("09:00-12:00");
    	elliotAlderson.setTuesdayTime("09:00-12:00");
    	philPrice = employeeService.createEmployee(philPrice);
    	elliotAlderson = employeeService.createEmployee(elliotAlderson);
    	angelaMoss = employeeService.createEmployee(angelaMoss);
    	
    	philPrice.addService(assetManagement);
    	elliotAlderson.addService(computerRepair);
    	employeeService.createEmployee(philPrice);
    	employeeService.createEmployee(elliotAlderson);
    	employeeService.createEmployee(angelaMoss);
    	businessServiceService.saveService(computerRepair);
    	businessServiceService.saveService(assetManagement);


		// Create Business Admin
		BusinessAdmin businessAdmin = new BusinessAdmin();
		businessAdmin.setBusinessName("Storm the Castle");
		businessAdmin.setBusinessDesc("Here there be dragons!");
		businessAdmin.setFirstName("Buffy");
		businessAdmin.setLastName("Summers");
		businessAdmin.setEmail("admin@ecorp.com");
		businessAdmin.setUsername("admin@ecorp.com");
		businessAdmin.setPasswordHash("admin123");
		businessAdmin.setConfirmPassword("admin123");
    	businessAdminService.save(businessAdmin);

    	System.out.println("A debug service was called!");
    }	
}
