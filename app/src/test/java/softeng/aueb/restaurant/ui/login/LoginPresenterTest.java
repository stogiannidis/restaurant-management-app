package softeng.aueb.restaurant.ui.login;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import softeng.aueb.restaurant.dao.daoInf.CustomerDAO;
import softeng.aueb.restaurant.dao.daoInf.EmployeeDAO;
import softeng.aueb.restaurant.dao.daoInf.OwnerDAO;
import softeng.aueb.restaurant.dao.memorydao.CustomerDAOMemory;
import softeng.aueb.restaurant.dao.memorydao.EmployeeDAOMemory;
import softeng.aueb.restaurant.dao.memorydao.OwnerDAOMemory;
import softeng.aueb.restaurant.domain.Customer;
import softeng.aueb.restaurant.domain.Employee;
import softeng.aueb.restaurant.domain.Owner;
import softeng.aueb.restaurant.register.CustomerRegister.CustomerRegActivity;
import softeng.aueb.restaurant.register.CustomerRegister.CustomerRegPresenter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class LoginPresenterTest {

    CustomerDAO customerDAO;
    OwnerDAO ownerDAO;
    EmployeeDAO employeeDAO;
    @Mock
    LoginActivity loginActivity;
    LoginPresenter presenter;

    @Test
    void onLogin() {
        loginActivity = Mockito.mock(LoginActivity.class);
        assertNotNull(loginActivity);
        when(loginActivity.getUsername()).thenReturn("test");
        when(loginActivity.getPassword()).thenReturn("123");
        customerDAO = new CustomerDAOMemory();
        ownerDAO = new OwnerDAOMemory();
        employeeDAO = new EmployeeDAOMemory();
        customerDAO.save(new Customer("test","test@aueb.gr","123"));
        employeeDAO.save(new Employee("chef@aueb.gr","123","chef","chef"));
        ownerDAO.save(new Owner("owner","owner@aueb.gr","123",44));


        presenter = new LoginPresenter(loginActivity,customerDAO,ownerDAO,employeeDAO);
        presenter.onLogin();
        assertEquals("test", customerDAO.find(loginActivity.getUsername()).getUsername());
        when(loginActivity.getUsername()).thenReturn("chef");
        when(loginActivity.getPassword()).thenReturn("123");
        assertEquals("chef", employeeDAO.find(loginActivity.getUsername()).getUsername());
        when(loginActivity.getUsername()).thenReturn("owner");
        when(loginActivity.getPassword()).thenReturn("123");
        assertEquals("owner", ownerDAO.find(loginActivity.getUsername()).getUsername());
    }
}