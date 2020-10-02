package app.controller;

import app.entity.user.Customer;
import app.service.CustomerService;
import app.service.MapValidationErrorService;
import app.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserValidator customerValidator;


    @PostMapping("/register")
    public ResponseEntity<?>  registerCustomer(@RequestBody Customer customer, BindingResult result) {

        customerValidator.validate(customer,result);
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null)return errorMap;
        customerService.save(customer);
        return new  ResponseEntity<Customer>(customer, HttpStatus.OK);
    }



    @GetMapping("/all")
    public Iterable<Customer> getAll() {
        return customerService.getAll();
    }

}
