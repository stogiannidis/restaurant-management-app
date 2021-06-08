package softeng.aueb.restaurant.register.EmployeeRegister;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import softeng.aueb.restaurant.dao.daoInf.EmployeeDAO;
import softeng.aueb.restaurant.dao.memorydao.EmployeeDAOMemory;
import softeng.aueb.restaurant.register.CustomerRegister.CustomerRegPresenter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EmployeeRegPresenterTest {

    EmployeeDAO employeeDAO;
    EmployeeRegPresenter presenter;

    @Mock
    EmployeeRegActivity activity;

    @Test
    public void onRegister(){

        activity = Mockito.mock(EmployeeRegActivity.class);
        assertNotNull(activity);
        when(activity.getEmail()).thenReturn("test@aueb.gr");
        when(activity.getUsername()).thenReturn("test");
        when(activity.getPassword()).thenReturn("123");
        employeeDAO = new EmployeeDAOMemory();
        presenter = new EmployeeRegPresenter(activity,employeeDAO);

        presenter.onRegister();
        assertFalse(employeeDAO.findAll().isEmpty());

    }
}