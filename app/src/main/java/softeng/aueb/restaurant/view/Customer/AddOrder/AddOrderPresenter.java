package softeng.aueb.restaurant.view.Customer.AddOrder;

import java.util.ArrayList;
import java.util.List;

import softeng.aueb.restaurant.MainActivity;
import softeng.aueb.restaurant.dao.daoInf.CustomerDAO;
import softeng.aueb.restaurant.dao.daoInf.OrderDAO;
import softeng.aueb.restaurant.dao.daoInf.ProductItemDAO;
import softeng.aueb.restaurant.dao.daoInf.TableDAO;
import softeng.aueb.restaurant.domain.Customer;
import softeng.aueb.restaurant.domain.MenuItem;
import softeng.aueb.restaurant.domain.Order;
import softeng.aueb.restaurant.domain.ProductItem;

/**
 * Class that connects the view with domain
 */
public class AddOrderPresenter {

    String customer;
    OrderDAO orderDAO;
    ProductItemDAO itemDAO;
    AddOrderView view;
    TableDAO tableDAO;
    public ArrayList<MenuItem> order = new ArrayList<>();

    /**
     * Class constructor
     * @param username customer's username
     * @param itemDAO item Data Access Object
     * @param orderDAO order Data Access Object
     * @param tableDAO table Data Access Object
     * @param view App view
     */
    public AddOrderPresenter(String username, ProductItemDAO itemDAO, OrderDAO orderDAO, TableDAO tableDAO , AddOrderView view) {
        this.itemDAO = itemDAO;
        this.view = view;
        this.orderDAO = orderDAO;
        customer = username;
        this.tableDAO = tableDAO;
    }

    /**
     * Return the available menu
     * @return menu
     */
    List<ProductItem> setMenuInfo(){
        return itemDAO.findAll();
    }

    /**
     * Checks if the info given is correct and adds the
     * product to customer's basket
     */
    public void onOrderCreation(){
        int quantity = 0;
        if(view.getName().isEmpty()|| view.getQuantity().isEmpty()){
            view.showEmptyFieldsDetected();
            return;
        }

        if(itemDAO.find(view.getName()) == null){
            view.showInvalidProduct();
            return;
        }
        try {
            quantity = Integer.parseInt(view.getQuantity());
        }catch (Exception e){
            view.showInvalidQuantity();
            return;
        }
        if (quantity <= itemDAO.find(view.getName()).getQuantityMade()){
            itemDAO.find(view.getName()).modifyQuantity(-quantity);
        }
        else {
            view.showInvalidQuantity();
            return;
        }
        MenuItem orderItem = new MenuItem(view.getName(),quantity);
        order.add(orderItem);
        view.onSuccessfulAddition();
    }

    /**
     * Clears customer's basket
     */
    public void clearBasket(){
        order.clear();
        view.onBasketClear();
    }

    /**
     * Checks if info given is valid and
     * created and order
     */
    public void onOrderConfirmation(){
        int tableNO = 0;
        try {
            tableNO = Integer.parseInt(view.getTable());
        }catch (Exception e){
            view.showInvalidTable();
            return;
        }
        if (tableNO > tableDAO.getAvailableTables()){
            view.showInvalidTable();
        }
        MainActivity.memoryInitializer.getCustomerDAO().find(customer).createOrder(order);
        Order _order = new Order(MainActivity.memoryInitializer.getCustomerDAO().find(customer).getOrderId());
        for (MenuItem item : order)
            _order.addItem(item);
        tableDAO.find(tableNO).addOrder(_order);
        orderDAO.save(_order);
        view.onExit(_order.getOrderNumber());
    }
}
