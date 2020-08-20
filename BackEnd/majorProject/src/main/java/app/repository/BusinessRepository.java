package app.repository;

import app.model.business.BusinessImpl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends CrudRepository<BusinessImpl, Integer> {

}
