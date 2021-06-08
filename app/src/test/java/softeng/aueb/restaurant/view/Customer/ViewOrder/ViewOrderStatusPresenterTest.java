package softeng.aueb.restaurant.view.Customer.ViewOrder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import softeng.aueb.restaurant.dao.daoInf.CustomerDAO;
import softeng.aueb.restaurant.dao.daoInf.OrderDAO;
import softeng.aueb.restaurant.dao.memorydao.CustomerDAOMemory;
import softeng.aueb.restaurant.dao.memorydao.OrderDAOMemory;
import softeng.aueb.restaurant.domain.Customer;
import softeng.aueb.restaurant.domain.MenuItem;
import softeng.aueb.restaurant.domain.Order;

import static org.junit.jupiter.api.Assertions.*;

class ViewOrderStatusPresenterTest {


    @Test
    void projectOrderStatus() {
        // No reason to test a projection :D
    }

    @Test
    void payOrder() {
        // Helper function for visualisation
        //Also no reason to test that :D
    }
}