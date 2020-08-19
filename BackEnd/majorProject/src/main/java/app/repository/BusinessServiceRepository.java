package app.repository;

import app.model.businessservice.BusinessServiceImpl;
import app.model.interfaces.employee.BusinessService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessServiceRepository extends CrudRepository<BusinessServiceImpl, Integer> {
}
