package dao.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.user.UserImpl;

@Repository
public interface UserRepository extends CrudRepository<UserImpl, Integer> {}
