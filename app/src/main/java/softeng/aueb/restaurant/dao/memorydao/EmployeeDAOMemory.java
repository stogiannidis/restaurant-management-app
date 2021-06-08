package softeng.aueb.restaurant.dao.memorydao;

import java.util.ArrayList;
import java.util.List;

import softeng.aueb.restaurant.dao.daoInf.EmployeeDAO;
import softeng.aueb.restaurant.domain.Employee;

public class EmployeeDAOMemory implements EmployeeDAO {
    protected static ArrayList<Employee> employees = new ArrayList<>();
    /**
     * Saves an employee to memory
     *
     * @param employee the employee of the restaurant
     */
    @Override
    public void save(Employee employee) {
        employees.add(employee);
    }

    /**
     * Deletes an employee from memory
     *
     * @param employee the employee of the restaurant
     */
    @Override
    public void delete(Employee employee) {
        employees.remove(employee);
    }

    /**
     * Finds a employee by their id
     *
     * @param username employee's username
     * @return the employee with that username or {@code null} if not found
     */
    @Override
    public Employee find(String username) {
        for (Employee e: employees) {
            if (e.getUsername().equals(username))
                return e;
        }
        return null;
    }

    /**
     * @return All registered employees
     */
    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employees);
    }

    @Override
    public boolean IsEmailTaken(String email) {
        for (Employee e: employees) {
            if (e.getEmail().equals(email))
                return true;
        }
        return false;
    }
}
