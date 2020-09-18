package app.repository;

import app.entity.BusinessServiceJob;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessServiceRepository extends CrudRepository<BusinessServiceJob, Integer> {
}
