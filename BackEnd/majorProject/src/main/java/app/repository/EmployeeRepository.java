package app.repository;
import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import app.entity.user.Employee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    @Query("SELECT employees FROM Employee employees WHERE BUSINESS_ID = :businessID")
    Collection<Employee> getEmployeeByBusiness(@Param("businessID") int businessID);
}
