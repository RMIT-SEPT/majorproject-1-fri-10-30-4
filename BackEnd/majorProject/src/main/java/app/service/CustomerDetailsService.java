package app.service;

import app.entity.user.Customer;
import app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer user = customerRepository.findByEmail(email);
        if(user==null) new UsernameNotFoundException("User not found");
        return user;
    }


    @Transactional
    public Customer loadUserById(Long id){
        Customer user = customerRepository.getByCustomerId(id);
        if(user==null) new UsernameNotFoundException("User not found");
        return user;

    }
}
