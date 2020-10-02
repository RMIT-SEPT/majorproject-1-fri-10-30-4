package app.repository;


import app.entity.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UserBaseRepository<T extends User> extends CrudRepository<T, Long> {
    User findByEmail(String email);
    User getByUserId(Long id);
}
