package app.repository;


import app.entity.user.BusinessAdmin;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BusinessAdminRepository extends UserBaseRepository<BusinessAdmin> {

}
