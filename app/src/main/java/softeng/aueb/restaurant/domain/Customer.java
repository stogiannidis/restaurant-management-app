package softeng.aueb.restaurant.domain;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


/**
 * A class that implement a customer in our system
 * @author team23
 */
public class Customer  {
    private String username;
    private String email;
    private String password;
    private Order currentOrder=null;
    private int orderId=0;


    public HashMap<Integer,Order> orders = new HashMap<>(); //orders per customer

    /**
     * Constructor of the class
     * @param username customer's username
     * @param email customer's email
     * @param password customer's password
     */
    public Customer(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;

    }


    /**
     * A function that creates the customer's order
     * @param p an arraylist of Items listed in the menu
     */
    public void createOrder(ArrayList<MenuItem> p){
        Random r = new Random();
        orderId = r.nextInt(1000);
        currentOrder = new Order(orderId);
        for(MenuItem t: p){
            currentOrder.addItem(t);
        }
        if (orders!=null)
            orders.put(orderId,currentOrder);
        else
            System.out.println("There was an error. ");
    }

    /**
     * Getter
     * @return Customer's username
     */
    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter
     * @return Customer's username
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter
     * @param email sets new email for customer
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter
     * @return Customer's username
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter
     * @param password sets new password for customer
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter
     * @return all customer orders
     */
    public HashMap<Integer, Order> getOrders() {
        return orders;
    }
    /**
     * Getter
     * @return Customer's orderID
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Getter
     * @return Customer's current order
     */
    public Order getCurrentOrder() {
        return currentOrder;
    }
}
