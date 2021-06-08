package softeng.aueb.restaurant.dao.daoInf;
import java.util.List;


import softeng.aueb.restaurant.domain.Order;

/**
 * @author team23
 */


public interface OrderDAO {
    /**
     * Saves an employee to memory
     * @param order the order of a customer
     */
    void save(Order order);

    /**
     * Deletes an order from memory
     * @param order the order of a customer
     */
    void delete (Order order);

    /**
     *  Finds a employee by their number
     * @param orderNumber order's number
     * @return the order with that number or {@code null} if not found
     */
    Order find (int orderNumber);

    /**
     *
     * @return All confirmed orders
     */
    List<Order> findAll();

    List<Order> findUnverified();

    List<Order> findUnpaid();
}
