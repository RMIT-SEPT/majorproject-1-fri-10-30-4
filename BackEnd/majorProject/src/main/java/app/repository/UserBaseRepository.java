package app.repository;


import app.entity.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UserBaseRepository<T extends User> extends CrudRepository<T, Long> {
   T findByEmail(String email);
   T getByUserId(Long id);
}
