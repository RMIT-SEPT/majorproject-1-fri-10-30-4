package app.service;


import app.entity.user.Customer;
import app.exceptions.EmailAlreadyUsedException;
import app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public Customer save(Customer newUser){
        try{
            newUser.setPasswordHash(bCryptPasswordEncoder.encode(newUser.getPasswordHash()));
            newUser.setUsername(newUser.getUsername());
            newUser.setConfirmPassword("");
            return customerRepository.save(newUser);
        }catch (Exception e){
            throw new EmailAlreadyUsedException("Email '"+ newUser.getEmail() +"' already used.");
        }
    }

    public Iterable<Customer> getAll() {
        return customerRepository.findAll();
    }

}
