package repositories;

import model.user.EmployeeImpl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface EmployeeRepository {

    /**
     * @param userID
     * @return Employee with the userID
     */
    @Query("SELECT employees FROM EmployeeImpl employees WHERE (userID = :userID))")
    EmployeeImpl getEmployeeByID(@Param("userID") int userID);


    @Query("SELECT employees FROM EmployeeImpl employees WHERE (businessID = :businessID)")
    Collection<EmployeeImpl> getEmployeeByBusinessID(@Param("businessID") int businessID);
}
