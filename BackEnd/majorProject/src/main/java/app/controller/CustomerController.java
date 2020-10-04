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

    @PostMapping("/register")
    public ResponseEntity<?>  registerCustomer(@RequestBody Customer customer, BindingResult result) {

        customerService.save(customer);
        return new  ResponseEntity<Customer>(customer, HttpStatus.OK);
    }



    @GetMapping("/all")
    public Iterable<Customer> getAll() {
        return customerService.getAll();
    }

}
