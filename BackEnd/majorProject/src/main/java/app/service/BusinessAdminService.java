package app.service;

import app.entity.user.BusinessAdmin;
import app.exceptions.EmailAlreadyUsedException;
import app.repository.BusinessAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BusinessAdminService {
    @Autowired
    private BusinessAdminRepository businessAdminRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public BusinessAdmin save(BusinessAdmin admin){
        try {
            admin.setPasswordHash(bCryptPasswordEncoder.encode(admin.getPasswordHash()));
            admin.setUsername(admin.getUsername());
            admin.setConfirmPassword("");
            return businessAdminRepository.save(admin);
        } catch (Exception ex) {
            throw new EmailAlreadyUsedException("Email '"+ admin.getEmail() +"' already used.");
        }
    }

    public Iterable<BusinessAdmin> getAll() {
        return businessAdminRepository.findAll();
    }


    public void removeAll() {
       businessAdminRepository.deleteAll();
    }

    public boolean exists(String username){
        System.out.println("Checking admin exists");
        for(BusinessAdmin admin: businessAdminRepository.findAll()) {
            if(username.equals(admin.getUsername())){
                return true;
            }
        }
        return false;
    }


}
