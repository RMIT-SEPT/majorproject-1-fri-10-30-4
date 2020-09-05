package app.repository;

import app.model.user.EmployeeImpl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Repository
public interface EmployeeRepository extends UserRepository<EmployeeImpl> {

    /**
     * @param userID
     * @return Employee with the userID
     */
    @Query("SELECT employees FROM EmployeeImpl employees WHERE (userID = :userID)")
    EmployeeImpl getEmployeeByID(@Param("userID") int userID);

    /**
     *
     * @param businessID
     * @return A collection of Employees with the same businessIDs
     */
    @Query("SELECT employees FROM EmployeeImpl employees WHERE (businessID = :businessID)")
    Collection<EmployeeImpl> getEmployeeByBusinessID(@Param("businessID") int businessID);
}
