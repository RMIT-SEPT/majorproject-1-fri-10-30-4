package dao.user;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.interfaces.user.User;



public interface UserDAOTagImpl {
	
	/**
	 * @param email Email address (case insensitive) of the user.
	 * @return Collection of users with that selected email address.
	 */
	@Query(
			"SELECT * FROM user WHERE (user.email = LOWER(:email))"
			)
	Collection<User> getUsersByEmail(@Param("email") String email);
	
	/**
	 * @param email Email address (case insensitive) of the user.
	 * @param passwordHash Password hash of the user.
	 * @return Collection of users with the same email and password provided.
	 */
	@Query(
			"SELECT * FROM user WHERE (user.email = LOWER(:email)) AND (user.password_hash = :password_hash)"
	)
	Collection<User> getUsersByEmailAndPassword(@Param("email") String email, @Param("password_hash") String passwordHash);

}
