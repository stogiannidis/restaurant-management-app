package softeng.aueb.restaurant.dao.memorydao;

import java.util.ArrayList;
import java.util.List;

import softeng.aueb.restaurant.dao.daoInf.OrderDAO;
import softeng.aueb.restaurant.domain.Order;

public class OrderDAOMemory implements OrderDAO {
    protected static ArrayList<Order> orders = new ArrayList<>();
    /**
     * Saves an employee to memory
     *
     * @param order the order of a customer
     */
    @Override
    public void save(Order order) {
        orders.add(order);
    }

    /**
     * Deletes an order from memory
     *
     * @param order the order of a customer
     */
    @Override
    public void delete(Order order) {
        orders.remove(order);
    }

    /**
     * Finds a employee by their number
     *
     * @param orderNumber order's number
     * @return the order with that number or {@code null} if not found
     */
    @Override
    public Order find(int orderNumber) {
        for (Order o: orders) {
            if (o.getOrderNumber() == orderNumber)
                return o;
        }
        return null;
    }

    /**
     * @return All confirmed orders
     */
    @Override
    public List<Order> findAll() {
        return new ArrayList<>(orders);
    }

    @Override
    public List<Order> findUnverified() {
        ArrayList<Order> unverified = new ArrayList<>();
        for(Order o : orders){
            if(!o.getVerification())
                unverified.add(o);
        }
        return unverified;
    }

    @Override
    public List<Order> findUnpaid() {
        ArrayList<Order> unpaid = new ArrayList<>();
        for (Order o:
             orders) {
            if((!o.isPaid()) && o.getVerification()){
                unpaid.add(o);
            }
        }
        return  unpaid;
    }
}
