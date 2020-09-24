package app.controller;

import app.entity.user.Customer;
import app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/registration")
    public void registerCustomer(@RequestBody Customer customer) {
        customer.setPasswordHash(bCryptPasswordEncoder.encode(customer.getPasswordHash()));
        customerService.save(customer);
    }

}
