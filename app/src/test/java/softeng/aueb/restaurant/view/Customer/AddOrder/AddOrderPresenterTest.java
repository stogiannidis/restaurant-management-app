package softeng.aueb.restaurant.view.Customer.AddOrder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;

import softeng.aueb.restaurant.MainActivity;
import softeng.aueb.restaurant.dao.daoInf.OrderDAO;
import softeng.aueb.restaurant.dao.daoInf.ProductItemDAO;
import softeng.aueb.restaurant.dao.daoInf.TableDAO;
import softeng.aueb.restaurant.dao.memorydao.MemoryInitializer;
import softeng.aueb.restaurant.dao.memorydao.OrderDAOMemory;
import softeng.aueb.restaurant.dao.memorydao.ProductItemDAOMemory;
import softeng.aueb.restaurant.dao.memorydao.TableDAOMemory;
import softeng.aueb.restaurant.domain.Customer;
import softeng.aueb.restaurant.domain.MenuItem;
import softeng.aueb.restaurant.domain.ProductItem;
import softeng.aueb.restaurant.domain.Table;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AddOrderPresenterTest {

    String customer = "test";
    OrderDAO orderDAO;
    ProductItemDAO itemDAO;
    @Mock
    AddOrderActivity activity;
    TableDAO tableDAO;
    AddOrderPresenter presenter;

    @BeforeEach
    void setUp(){
        orderDAO = new OrderDAOMemory();
        itemDAO = new ProductItemDAOMemory();
        tableDAO = new TableDAOMemory();
        activity = Mockito.mock(AddOrderActivity.class);
        assertNotNull(activity);
        itemDAO.save(new ProductItem("pizza",5,5));
        tableDAO.save(new Table(1));
        presenter = new AddOrderPresenter(customer,itemDAO,orderDAO,tableDAO,activity);
    }

    @Test
    void setMenuInfo(){
        presenter.setMenuInfo();
    }

    @Test
    void testOnOrderCreation() {
        when(activity.getName()).thenReturn("pizza");
        when(activity.getQuantity()).thenReturn("4");
        when(activity.getTable()).thenReturn("1");

        presenter.onOrderCreation();
        assertFalse(presenter.order.isEmpty());
    }

    @Test
    void testClearBasket(){
        when(activity.getName()).thenReturn("pizza");
        when(activity.getQuantity()).thenReturn("4");
        when(activity.getTable()).thenReturn("1");

        presenter.onOrderCreation();
        presenter.clearBasket();
        assertTrue(presenter.order.isEmpty());
    }

    @Test
    void  testOnOrderConfirmation(){

        MainActivity.memoryInitializer = new MemoryInitializer();
        MainActivity.memoryInitializer.getCustomerDAO().save(new Customer("test","test@aueb.gr","123"));
        when(activity.getName()).thenReturn("pizza");
        when(activity.getQuantity()).thenReturn("4");
        when(activity.getTable()).thenReturn("1");
        presenter.onOrderConfirmation();
        assertFalse(tableDAO.find(1).dailyOrders.isEmpty());
    }

}