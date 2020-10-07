package app.service;


import app.entity.user.Customer;
import app.entity.user.User;
import app.exceptions.EmailAlreadyUsedException;
import app.repository.CustomerRepository;
import app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User save(User newUser){
        try{
            newUser.setPasswordHash(bCryptPasswordEncoder.encode(newUser.getPasswordHash()));
            newUser.setUsername(newUser.getUsername());
            newUser.setConfirmPassword("");
            return userRepository.save(newUser);
        }catch (Exception e){
            throw new EmailAlreadyUsedException("Email '"+ newUser.getEmail() +"' already used.");
        }
    }

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }
}
