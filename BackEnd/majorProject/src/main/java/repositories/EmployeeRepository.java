package repositories;

import model.user.EmployeeImpl;
import model.user.UserImpl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface EmployeeRepository extends CrudRepository<EmployeeImpl, Integer> {

    /**
     * @param userID
     * @return Employee with the userID
     */
    @Query("SELECT employees FROM EmployeeImpl employees WHERE (userID = :userID))")
    EmployeeImpl getEmployeeByID(@Param("userID") int userID);

    /**
     *
     * @param businessID
     * @return A collection of Employees with the same businessIDs
     */
    @Query("SELECT employees FROM EmployeeImpl employees WHERE (businessID = :businessID)")
    Collection<EmployeeImpl> getEmployeeByBusinessID(@Param("businessID") int businessID);
}
