package softeng.aueb.restaurant.view.Customer.ViewOrder;

import softeng.aueb.restaurant.MainActivity;
import softeng.aueb.restaurant.dao.daoInf.CustomerDAO;
import softeng.aueb.restaurant.dao.daoInf.OrderDAO;
import softeng.aueb.restaurant.dao.daoInf.ProductItemDAO;
import softeng.aueb.restaurant.domain.Customer;
import softeng.aueb.restaurant.domain.MenuItem;
import softeng.aueb.restaurant.domain.Order;

/**
 * Class that connects the view with domain
 */
public class ViewOrderStatusPresenter {

    Customer customer;
    CustomerDAO customerDAO;
    OrderDAO orderDAO;
    ViewOrderStatusView view;

    /**
     * Class constructor
     * @param username customer's username
     * @param customerDAO customer Data Access Object
     * @param orderDAO order Data Access Object
     * @param view app view
     */
    public ViewOrderStatusPresenter(String username, CustomerDAO customerDAO, OrderDAO orderDAO, ViewOrderStatusView view) {
        this.customer = customerDAO.find(username);
        this.customerDAO = customerDAO;
        this.orderDAO = orderDAO;
        this.view = view;
    }

    /**
     * Projects order's status to app view by
     * contacting the domain classes and DAOs
     */
    public void projectOrderStatus(){
        Order order = customer.getCurrentOrder();
        int time = orderDAO.find(order.getOrderNumber()).getPreparationTime();
        view.setTime(Integer.toString(time));
        view.setOrderID(Integer.toString(order.getOrderNumber()));
        ProductItemDAO productItemDAO = MainActivity.memoryInitializer.getProductItemDAO();
        double price=0;
        for(MenuItem item :order.getBasket()){
            price += productItemDAO.find(item.getName()).getCost()* item.getQuantity();
        }
        view.setPrice(Double.toString(price));
    }

    /**
     * Sets order as paid
     */
    public void payOrder(){
        view.OnPayment();
    }
}
