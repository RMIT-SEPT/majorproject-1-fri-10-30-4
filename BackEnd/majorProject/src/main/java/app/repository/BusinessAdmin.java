//package app.repository;
//
//import app.model.user.BusinessAdminImpl;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//
//import java.util.Collection;
//
//public interface BusinessAdmin extends CrudRepository<BusinessAdminImpl, Integer> {
//
//    /**
//     * @param userID
//     * @return The business admin with the equivalent user ID
//     */
//    @Query("SELECT businessAdmin FROM BusinessAdminImpl businessAdmin WHERE userID = :userID")
//    BusinessAdminImpl getBusinessAdminByUserID(@Param("userID") int userID);
//
//    /**
//     * @param businessID
//     * @return A collection of business admins with the same business ID.
//     */
//    @Query("SELECT businessAdmin FROM BusinessAdminImpl businessAdmin WHERE businessID = :businessID")
//    Collection<BusinessAdminImpl> getBusinessAdminByBusinessID(@Param("businessID") int businessID);
//
//}
