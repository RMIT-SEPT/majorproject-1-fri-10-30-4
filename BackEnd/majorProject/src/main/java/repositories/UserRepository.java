package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.interfaces.user.User;
import model.user.UserImpl;

@Repository
public interface UserRepository extends CrudRepository<UserImpl, Integer> {
	
	/**
	 * @param email Email address (case insensitive) of the user.
	 * @return Collection of users with that selected email address.
	 */
	@Query(
			"SELECT users FROM UserImpl users WHERE (email = LOWER(:email))"
			)
	Collection<UserImpl> getUsersByEmail(@Param("email") String email);
	
	/**
	 * @param email Email address (case insensitive) of the user.
	 * @param passwordHash Password hash of the user.
	 * @return Collection of users with the same email and password provided.
	 */
	@Query(
			"SELECT users FROM UserImpl users WHERE (email = LOWER(:email)) AND (password_hash = :password_hash)"
	)
	Collection<UserImpl> getUsersByEmailAndPassword(@Param("email") String email, @Param("password_hash") String passwordHash);

	
}
