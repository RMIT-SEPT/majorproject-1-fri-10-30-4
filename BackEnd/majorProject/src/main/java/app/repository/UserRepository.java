package app.repository;

import app.entity.user.Customer;
import app.entity.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserRepository extends UserBaseRepository<User> {

}


