package app.service;


import app.entity.user.Customer;
import app.exceptions.UsernameAlreadyExistsException;
import app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public Customer save(Customer newUser){
        try{
            newUser.setPasswordHash(bCryptPasswordEncoder.encode(newUser.getPasswordHash()));
            newUser.setUsername(newUser.getUsername());
            newUser.setConfirmPassword("");
            return customerRepository.save(newUser);
        }catch (Exception e){
            throw new UsernameAlreadyExistsException("Username '"+ newUser.getUsername() +"' already exists");
        }

    }

}
