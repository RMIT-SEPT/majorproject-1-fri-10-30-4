package app.controller;

import app.entity.user.Customer;
import app.payload.JwtLoginSuccessResponse;
import app.payload.LoginRequest;
import app.security.JwtTokenProvider;
import app.service.CustomerService;
import app.service.MapValidationErrorService;
import app.validator.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.transform.sax.SAXSource;

import static app.security.SecurityContants.TOKEN_PREFIX;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerValidator customerValidator;


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
