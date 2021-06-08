package softeng.aueb.restaurant.dao.memorydao;

import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import softeng.aueb.restaurant.dao.daoInf.CustomerDAO;
import softeng.aueb.restaurant.domain.Customer;

public class CustomerDAOMemory implements CustomerDAO {
    public static ArrayList<Customer> customers = new ArrayList<Customer>();
    /**
     * Saves a customer to memory
     *
     * @param customer the Customer of the restaurant
     */
    @Override
    public void save(Customer customer) {
        customers.add(customer);
    }

    /**
     * Deletes a customer from memory
     *
     * @param customer the Customer of the restaurant
     */
    @Override
    public void delete(Customer customer) {
        customers.remove(customer);
    }

    /**
     * checks if the given email already exists
     *
     * @param email the customer's email
     * @return {@code true} if the email exists {@code false} else}
     */
    @Override
    public boolean isEmailTaken(String email) {
        for (Customer customer: customers) {
            if(customer.getEmail().equals(email))
                return true;
        }
        return false;
    }

    /**
     * Finds a customer by their id
     *
     * @param username Customer's id
     * @return the customer with that id or {@code null} if not found
     */
    @Override
    public Customer find(String username) {
        for(Customer customer :customers){
            if (customer.getUsername().equals(username))
                return customer;
        }
        return null;
    }

    /**
     * @return All registered customers
     */
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers);
    }

}
