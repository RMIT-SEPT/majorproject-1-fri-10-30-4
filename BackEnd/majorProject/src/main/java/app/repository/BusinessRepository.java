package app.repository;

import app.entity.Business;
import app.entity.user.Employee;

import java.util.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BusinessRepository extends CrudRepository<Business, Integer> {
	
	@Modifying
	@Query("UPDATE Business set BUSINESS_ID=:newID WHERE BUSINESS_ID=:oldID")
	@Transactional
	void forceBusinessIDChanges(@Param("oldID") int oldID, @Param("newID") int newID);
}
