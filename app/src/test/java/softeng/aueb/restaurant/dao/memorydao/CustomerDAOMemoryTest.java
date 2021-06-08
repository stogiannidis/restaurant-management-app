package softeng.aueb.restaurant.dao.memorydao;

import org.junit.jupiter.api.Test;

import java.util.List;

import softeng.aueb.restaurant.dao.daoInf.CustomerDAO;
import softeng.aueb.restaurant.domain.Customer;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDAOMemoryTest {

    private CustomerDAO customerDAO = new CustomerDAOMemory();


    @Test
    public void save(){
        Customer customer = new Customer("test","test@aueb.gr","123");
        customerDAO.save(customer);
        List<Customer> all = customerDAO.findAll();
        assertTrue(all.contains(customer));
    }

    @Test
    public void test_delete(){
        Customer customer = new Customer("testDAO","test@aueb.gr","123");
        customerDAO.save(customer);
        customerDAO.delete(customer);
        assertNull(customerDAO.find("testDAO"));
    }

    @Test
    public void find(){
        Customer customer = new Customer("test","test@aueb.gr","123");
        customerDAO.save(customer);
        assertNotNull(customerDAO.find("test"));
    }

    @Test
    public void findAll(){
        Customer customer = new Customer("test","test@aueb.gr","123");
        Customer customer2 = new Customer("test2","test2@aueb.gr","123");
        customerDAO.save(customer);
        customerDAO.save(customer2);
        List<Customer> all = customerDAO.findAll();
        assertTrue(all.contains(customer));
        assertTrue(all.contains(customer2));
    }
}