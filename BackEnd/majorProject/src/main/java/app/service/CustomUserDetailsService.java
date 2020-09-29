package app.service;

import app.entity.user.BusinessAdmin;
import app.entity.user.Customer;
import app.repository.BusinessAdminRepository;
import app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BusinessAdminRepository businessAdminRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(email);
        BusinessAdmin admin = businessAdminRepository.findByEmail(email);
        if(customer ==null && admin == null) new UsernameNotFoundException("User not found");
        if(customer != null){
            return customer;
        } else {
           return admin;
        }
    }


    @Transactional
    public Customer loadCustomerById(Long id){
        Customer customer = customerRepository.getByCustomerId(id);
        return customer;
    }

    @Transactional
    public BusinessAdmin loadAdminById(Long id){
        BusinessAdmin admin = businessAdminRepository.getByBusinessAdminId(id);
        return admin;
    }
}
