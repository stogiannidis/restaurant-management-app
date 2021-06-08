package softeng.aueb.restaurant.view.Employee.EmployeeDetails;

import java.util.ArrayList;

import softeng.aueb.restaurant.dao.daoInf.OrderDAO;
import softeng.aueb.restaurant.domain.Order;

/**
 * Class that connects the view with domain
 */

public class OrderManagementPresenter {

    OrderDAO orderDAO;
    OrderManagementView view;

    public OrderManagementPresenter(OrderDAO orderDAO, OrderManagementView view) {
        this.orderDAO = orderDAO;
        this.view = view;
    }

    /**
     *
     * @return all unverified orders
     */
    public ArrayList<Order> getOrder() {
        return (ArrayList<Order>) orderDAO.findUnverified();
    }

    /**
     * Verify an order given in the App view by contacting domain classes
     */
    public void verify(){
        int ID = 0;
        int time = 0;
        if(view.getOrderID().isEmpty()){
            view.showEmptyFieldsDetected();
            return;
        }
        try {
            ID = Integer.parseInt(view.getOrderID());
            time = Integer.parseInt(view.getPrepationTime());
        }catch (Exception e){
            view.showInvalidOrder();
        }
        if(orderDAO.find(ID) == null){
            view.showInvalidOrder();
            return;
        }
        orderDAO.find(ID).verify();
        orderDAO.find(ID).setPreparationTime(time);
        view.onSuccessfulVerification();
    }
}
