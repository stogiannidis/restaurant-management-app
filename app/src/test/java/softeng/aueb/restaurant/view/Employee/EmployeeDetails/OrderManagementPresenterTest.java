package softeng.aueb.restaurant.view.Employee.EmployeeDetails;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import softeng.aueb.restaurant.dao.daoInf.OrderDAO;
import softeng.aueb.restaurant.dao.memorydao.OrderDAOMemory;
import softeng.aueb.restaurant.domain.Order;

import static org.junit.jupiter.api.Assertions.*;

class OrderManagementPresenterTest {

    Order order;
    OrderDAO orderDAO;
    @Mock
    OrderManagementActivity activity;
    OrderManagementPresenter presenter;

    @BeforeEach
    void setUP(){
        order = new Order(4);
        orderDAO = new OrderDAOMemory();
        orderDAO.save(order);
        activity = Mockito.mock(OrderManagementActivity.class);
        presenter = new OrderManagementPresenter(orderDAO,activity);
    }
    @Test
    void getOrder() {
        assertFalse(orderDAO.findAll().isEmpty());
    }

    @Test
    void verify() {
        Mockito.when(activity.getOrderID()).thenReturn("4");
        Mockito.when(activity.getPrepationTime()).thenReturn("30");
        presenter.verify();
        assertTrue(order.getVerification());
        assertEquals(30,order.getPreparationTime());
    }
}