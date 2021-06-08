package softeng.aueb.restaurant.view.Employee.AddEditEmployee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import softeng.aueb.restaurant.dao.daoInf.OrderDAO;
import softeng.aueb.restaurant.dao.daoInf.TableDAO;
import softeng.aueb.restaurant.dao.memorydao.OrderDAOMemory;
import softeng.aueb.restaurant.dao.memorydao.TableDAOMemory;
import softeng.aueb.restaurant.domain.Order;
import softeng.aueb.restaurant.domain.Table;

import static org.junit.jupiter.api.Assertions.*;

class WaiterPresenterTest {

    OrderDAO orderDAO;
    TableDAO tableDAO;
    @Mock
    WaiterActivity waiterActivity;
    WaiterPresenter presenter;


    @BeforeEach
    void setUp(){
        orderDAO = new OrderDAOMemory();
        tableDAO = new TableDAOMemory();
        waiterActivity = Mockito.mock(WaiterActivity.class);
        presenter = new WaiterPresenter(orderDAO,tableDAO,waiterActivity);
        orderDAO.save(new Order(4));
    }

    @Test
    void getOrders() {
        assertFalse(orderDAO.findAll().isEmpty());
    }

    @Test
    void verify() {
        Mockito.when(waiterActivity.getOrderID()).thenReturn("4");
        presenter.verify();
        assertTrue(orderDAO.find(4).isPaid());
    }
}