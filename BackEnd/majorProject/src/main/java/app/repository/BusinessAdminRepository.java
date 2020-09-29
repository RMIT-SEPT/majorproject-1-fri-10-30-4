package app.repository;


import app.entity.user.BusinessAdmin;
import app.entity.user.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessAdminRepository extends CrudRepository<BusinessAdmin, Long > {
    BusinessAdmin findByEmail(String email);
    BusinessAdmin getByBusinessAdminId(Long id);
}
