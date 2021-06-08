package softeng.aueb.restaurant.dao.memorydao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;


import softeng.aueb.restaurant.dao.daoInf.EmployeeDAO;
import softeng.aueb.restaurant.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDAOMemoryTest {
    private EmployeeDAO employeeDAO = new EmployeeDAOMemory();


    @Test
    public void save(){
        Employee employee = new Employee("test@aueb.gr","123","test","chef");
        employeeDAO.save(employee);
        List<Employee> all = employeeDAO.findAll();
        assertTrue(all.contains(employee));
    }

    @Test
    public void delete(){
        Employee employee = new Employee("test@aueb.gr","123","test666","chef");
        employeeDAO.save(employee);
        employeeDAO.delete(employee);
        assertNull(employeeDAO.find("test666"));
    }

    @Test
    public void find(){
        Employee employee = new Employee("test@aueb.gr","123","test","chef");
        employeeDAO.save(employee);
        assertNotNull(employeeDAO.find("test"));
    }

    @Test
    public void findAll(){
        Employee employee = new Employee("test@aueb.gr","123","test","chef");
        Employee employee2 = new Employee("test2@aueb.gr","123","test2","chef");
        employeeDAO.save(employee);
        employeeDAO.save(employee2);
        List<Employee> all = employeeDAO.findAll();
        assertTrue(all.contains(employee));
        assertTrue(all.contains(employee2));
    }

}