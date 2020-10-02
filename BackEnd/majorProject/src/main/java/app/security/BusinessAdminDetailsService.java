package app.security;


import app.entity.user.BusinessAdmin;
import app.repository.BusinessAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BusinessAdminDetailsService  implements UserDetailsService {

    @Autowired
    private BusinessAdminRepository businessAdminRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        BusinessAdmin admin = businessAdminRepository.findByEmail(email);
        if(admin == null) throw new UsernameNotFoundException("User not found");
        return admin;
    }

    @Transactional
    public BusinessAdmin loadAdminById(Long id){
        BusinessAdmin admin = businessAdminRepository.getByBusinessAdminId(id);
        if(admin == null) throw new UsernameNotFoundException("User not found");
        return admin;
    }


}
