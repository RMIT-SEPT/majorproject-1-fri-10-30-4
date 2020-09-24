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
        System.out.println("register");
        customerValidator.validate(customer,result);
        System.out.println("validated");
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        System.out.println("error");
        if(errorMap != null)return errorMap;
    ;
        customerService.save(customer);
        System.out.println("created");
        return new  ResponseEntity<Customer>(customer, HttpStatus.OK);
    }


    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, BindingResult result){
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;


        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = TOKEN_PREFIX +  tokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JwtLoginSuccessResponse(true, jwt));
    }

    @GetMapping("/all")
    public Iterable<Customer> getAll() {
        return customerService.getAll();
    }

}
