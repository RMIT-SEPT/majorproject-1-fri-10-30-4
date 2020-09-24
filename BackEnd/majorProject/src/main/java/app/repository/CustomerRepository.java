package app.repository;

import app.entity.user.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    Customer findByEmail(String email);
    Customer getById(Long id);

//    /**
//     * @param userID
//     * @return The customer with the userID.
//     */
//    @Query("SELECT customer FROM Customer customer WHERE (customerID = :userID)")
//    Customer getCustomerByID(@Param("userID") int userID);
//
//    /**
//     * @param address
//     * @return Get a collection of customers with the same address.
//     */
//    @Query("SELECT customers FROM Customer customers WHERE address = :address")
//    Collection<Customer> getCustomerByAddress(@Param("address") String address);
//
//    /**
//     * @param phoneNumber
//     * @return A collection of customers with the same phone number.
//     */
//    @Query("SELECT customers FROM CustomerImpl customers WHERE phoneNumber = :phoneNumber")
//    Collection<Customer> getCustomerByPhoneNumber(@Param("phoneNumber") String phoneNumber);
}
