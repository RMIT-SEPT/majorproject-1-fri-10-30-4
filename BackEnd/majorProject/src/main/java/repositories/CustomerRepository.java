package repositories;

import model.user.EmployeeImpl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface CustomerRepository {
    /**
     * @param email Email address (case insensitive) of the user.
     * @return Collection of employees with that selected email address.
     */
    @Query("SELECT customers FROM CustomerImpl customers WHERE (email = LOWER(:email))")
    Collection<EmployeeImpl> getEmployeeByEmail(@Param("email") String email);

    /**
     * @param email Email address (case insensitive) of the user.
     * @param passwordHash Password hash of the employee.
     * @return Collection of employees with the same email and password provided.
     */
    @Query("SELECT employees FROM EmployeeImpl employees WHERE (email = LOWER(:email)) AND (password_hash = :password_hash)")
    Collection<EmployeeImpl> getEmployeeByEmailAndPassword(@Param("email") String email, @Param("password_hash") String passwordHash);
}
