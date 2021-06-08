package softeng.aueb.restaurant.view.Employee.AddEditEmployee;

import java.util.ArrayList;

import softeng.aueb.restaurant.dao.daoInf.OrderDAO;
import softeng.aueb.restaurant.dao.daoInf.TableDAO;
import softeng.aueb.restaurant.domain.Order;


/**
 * Class that connects the view with domain
 */
public class WaiterPresenter {

    OrderDAO orderDAO;
    TableDAO tableDAO;
    WaiterView view;

    public WaiterPresenter(OrderDAO orderDAO, TableDAO tableDAO, WaiterView view) {
        this.orderDAO = orderDAO;
        this.tableDAO = tableDAO;
        this.view = view;
    }

    /**
     *
     * @return all unpaid orders
     */
    public ArrayList<Order> getOrders() {
        return (ArrayList<Order>) orderDAO.findUnpaid();
    }

    /**
     * Mark an order as paid given in the App view by contacting domain classes
     */
    public void verify(){
        int ID = 0;
        if(view.getOrderID().isEmpty()){
            view.showEmptyFieldsDetected();
            return;
        }
        try {
            ID = Integer.parseInt(view.getOrderID());
        }catch (Exception e){
            view.showInvalidOrder();
        }
        if(orderDAO.find(ID) == null){
            view.showInvalidOrder();
            return;
        }
        orderDAO.find(ID).setPaid(true);
        view.onSuccessfulVerification();
    }
}
