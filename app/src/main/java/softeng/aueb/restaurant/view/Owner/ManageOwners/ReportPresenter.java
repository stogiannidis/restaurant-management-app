package softeng.aueb.restaurant.view.Owner.ManageOwners;

import java.util.ArrayList;

import softeng.aueb.restaurant.dao.daoInf.OrderDAO;
import softeng.aueb.restaurant.dao.daoInf.ProductItemDAO;
import softeng.aueb.restaurant.dao.daoInf.TableDAO;
import softeng.aueb.restaurant.domain.MenuItem;
import softeng.aueb.restaurant.domain.Order;
import softeng.aueb.restaurant.domain.Table;

/**
 * Class that connects the view with domain
 */

public class ReportPresenter {

    TableDAO tableDAO;
    ProductItemDAO productItemDAO;
    ReportView view;

    public ReportPresenter(TableDAO tableDAO, ProductItemDAO productItemDAO, ReportView view) {
        this.tableDAO = tableDAO;
        this.productItemDAO = productItemDAO;
        this.view = view;
    }

    /**
     * Calculates restaurant total revenue by contacting domain classes
     */
    public double calculateRevenue(){
        double revenue = 0;
        ArrayList<Table> tables = (ArrayList<Table>) tableDAO.findAll();
        for(Table table : tables){
            if (!table.dailyOrders.isEmpty()){
                for (Order order : table.dailyOrders){
                    for (MenuItem item: order.getBasket()){
                        revenue += productItemDAO.find(item.getName()).getCost() * item.getQuantity();
                    }
                }
            }
        }
        view.onRevenueCalculation(revenue);
        return revenue;
    }
}
