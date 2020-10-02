package app.security;

import app.entity.user.BusinessAdmin;
import app.entity.user.Customer;
import app.repository.BusinessAdminRepository;
import app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(email);
        if(customer == null) new UsernameNotFoundException("User not found");
        return customer;

    }


    @Transactional
    public Customer loadCustomerById(Long id){
        Customer customer = customerRepository.getByCustomerId(id);
        if(customer == null) throw new UsernameNotFoundException("User not found");
        return customer;
    }


}
