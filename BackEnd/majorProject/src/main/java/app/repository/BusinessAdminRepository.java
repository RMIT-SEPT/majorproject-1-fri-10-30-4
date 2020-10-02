package app.repository;


import app.entity.user.BusinessAdmin;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface BusinessAdminRepository extends UserBaseRepository<BusinessAdmin> {

}
