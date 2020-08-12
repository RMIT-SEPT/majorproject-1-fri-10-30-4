package repositories;

import model.user.CustomerImpl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface CustomerRepository {

    /**
     * @param userID
     * @return The customer with the userID.
     */
    @Query("SELECT customer FROM CustomerImpl customer WHERE (userID = :userID")
    CustomerImpl getCustomerByID(@Param("userID") int userID);

    /**
     * @param address
     * @return Get a collection of customers with the same address.
     */
    @Query("SELECT customers FROM CustomerImpl customers WHERE address = :address")
    Collection<CustomerImpl> getCustomerByAddress(@Param("address") String address);

    /**
     * @param phoneNumber
     * @return A collection of customers with the same phone number.
     */
    @Query("SELECT customers FROM CustomerImpl customers WHERE phoneNumber = :phoneNumber")
    Collection<CustomerImpl> getCustomerByPhoneNumber(@Param("phoneNumber") String phoneNumber);
}
