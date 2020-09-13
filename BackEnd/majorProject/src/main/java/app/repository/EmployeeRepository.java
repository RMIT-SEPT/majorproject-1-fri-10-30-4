package app.repository;

import app.model.user.CustomerImpl;
import app.model.user.EmployeeImpl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Repository
public interface EmployeeRepository extends UserRepository<EmployeeImpl> {

    @Query("SELECT employees FROM EmployeeImpl employees WHERE BUSINESS_ID = :businessID")
    Collection<EmployeeImpl> getEmployeeByBusiness(@Param("businessID") int businessID);
}
