package softeng.aueb.restaurant.dao.daoInf;


import java.util.List;
import softeng.aueb.restaurant.domain.Employee;

/**
 * @author team23
 */

public interface EmployeeDAO {

    /**
     * Saves an employee to memory
     * @param employee the employee of the restaurant
     */
    void save(Employee employee);

    /**
     * Deletes an employee from memory
     * @param employee the employee of the restaurant
     */
    void delete (Employee employee);

    /**
     *  Finds a employee by their id
     * @param username employee's username
     * @return the employee with that username or {@code null} if not found
     */
    Employee find (String username);

    /**
     *
     * @return All registered employees
     */
    List<Employee> findAll();

    boolean IsEmailTaken(String email);
}
