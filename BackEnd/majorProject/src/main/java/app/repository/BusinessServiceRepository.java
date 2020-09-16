package app.repository;

import app.entity.BusinessService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessServiceRepository extends CrudRepository<BusinessService, Integer> {
}
