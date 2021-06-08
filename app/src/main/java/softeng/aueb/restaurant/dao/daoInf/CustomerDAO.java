package softeng.aueb.restaurant.dao.daoInf;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import softeng.aueb.restaurant.domain.Customer;

/**
 * @author team23
 */


public interface CustomerDAO {

    /**
     * Saves a customer to memory
     * @param customer the Customer of the restaurant
     */
    void save(Customer customer);

    /**
     * Deletes a customer from memory
     * @param customer the Customer of the restaurant
     */
    void delete (Customer customer);

    /**
     * checks if the given email already exists
     * @param email the customer's email
     * @return {@code true} if the email exists {@code false} else}
     */
    boolean isEmailTaken(String email);

    /**
     *  Finds a customer by their id
     * @param username Customer's id
     * @return the customer with that id or {@code null} if not found
     */
    Customer find (String username);

    /**
     *
     * @return All registered customers
     */
    List<Customer> findAll();

}
