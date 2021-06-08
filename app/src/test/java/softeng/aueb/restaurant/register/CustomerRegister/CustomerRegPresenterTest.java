package softeng.aueb.restaurant.register.CustomerRegister;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import softeng.aueb.restaurant.dao.daoInf.CustomerDAO;
import softeng.aueb.restaurant.dao.memorydao.CustomerDAOMemory;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

class CustomerRegPresenterTest {

    CustomerDAO customerDAO;
    CustomerRegPresenter presenter;

    @Mock
    CustomerRegActivity activity;

    @Test
    public void onRegister(){

        activity = Mockito.mock(CustomerRegActivity.class);
        assertNotNull(activity);
        when(activity.getEmail()).thenReturn("test@aueb.gr");
        when(activity.getUsername()).thenReturn("test");
        when(activity.getPassword()).thenReturn("123");
        customerDAO = new CustomerDAOMemory();
        presenter = new CustomerRegPresenter(activity,customerDAO);

        presenter.onRegister();
        assertFalse(customerDAO.findAll().isEmpty());

    }
}