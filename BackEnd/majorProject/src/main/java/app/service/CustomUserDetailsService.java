package app.service;


import app.entity.user.User;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null) throw new UsernameNotFoundException("User not found");
        return user;
    }


    @Transactional
    public User loadCustomerById(Long id){
        User user = userRepository.getByUserId(id);
        if(user == null) throw new UsernameNotFoundException("User not found");
        return user;
    }
}
