package softeng.aueb.restaurant.view.Owner.ManageOwners;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import softeng.aueb.restaurant.dao.daoInf.ProductItemDAO;
import softeng.aueb.restaurant.dao.daoInf.TableDAO;
import softeng.aueb.restaurant.dao.memorydao.ProductItemDAOMemory;
import softeng.aueb.restaurant.dao.memorydao.TableDAOMemory;
import softeng.aueb.restaurant.domain.MenuItem;
import softeng.aueb.restaurant.domain.Order;
import softeng.aueb.restaurant.domain.ProductItem;
import softeng.aueb.restaurant.domain.Table;

import static org.junit.jupiter.api.Assertions.*;

class ReportPresenterTest {

    TableDAO tableDAO;
    ProductItemDAO productItemDAO;
    @Mock
    ReportActivity activity;
    ReportPresenter presenter;

    @BeforeEach
    void setUp(){
        tableDAO = new TableDAOMemory();
        productItemDAO = new ProductItemDAOMemory();
        activity = Mockito.mock(ReportActivity.class);
        presenter = new ReportPresenter(tableDAO,productItemDAO,activity);
        productItemDAO.save(new ProductItem("pizza",5,50));
        tableDAO.save(new Table(1));
        tableDAO.save(new Table(2));
        Order order = new Order(1);
        order.basket.add(new MenuItem("pizza",2));
        Order order2 = new Order(2);
        order2.basket.add(new MenuItem("pizza",1));
        Order order3 = new Order(3);
        order3.basket.add(new MenuItem("pizza",4));
        tableDAO.find(1).dailyOrders.add(order);
        tableDAO.find(1).dailyOrders.add(order2);
        tableDAO.find(2).dailyOrders.add(order3);
    }

    @Test
    void calculateRevenue() {
        assertEquals(35,presenter.calculateRevenue());
    }
}