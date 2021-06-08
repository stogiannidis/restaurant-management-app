package softeng.aueb.restaurant.register.OwnerRegister;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import softeng.aueb.restaurant.dao.daoInf.EmployeeDAO;
import softeng.aueb.restaurant.dao.daoInf.OwnerDAO;
import softeng.aueb.restaurant.dao.daoInf.TableDAO;
import softeng.aueb.restaurant.dao.memorydao.EmployeeDAOMemory;
import softeng.aueb.restaurant.dao.memorydao.OwnerDAOMemory;
import softeng.aueb.restaurant.dao.memorydao.TableDAOMemory;
import softeng.aueb.restaurant.register.EmployeeRegister.EmployeeRegActivity;
import softeng.aueb.restaurant.register.EmployeeRegister.EmployeeRegPresenter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class OwnerRegPresenterTest {
    OwnerDAO ownerDAO;
    OwnerRegPresenter presenter;
    TableDAO tableDAO;

    @Mock
    OwnerRegActivity activity;

    @Test
    public void test_onRegister(){

        activity = Mockito.mock(OwnerRegActivity.class);
        assertNotNull(activity);
        when(activity.getEmail()).thenReturn("test@aueb.gr");
        when(activity.getUsername()).thenReturn("test");
        when(activity.getPassword()).thenReturn("123");
        when(activity.getTables()).thenReturn("44");
        ownerDAO = new OwnerDAOMemory();
        tableDAO = new TableDAOMemory();
        presenter = new OwnerRegPresenter(activity,ownerDAO,tableDAO);

        presenter.onRegister();
        assertFalse(ownerDAO.findAll().isEmpty());

    }
}