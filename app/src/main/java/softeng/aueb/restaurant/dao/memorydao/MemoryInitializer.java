package softeng.aueb.restaurant.dao.memorydao;

import softeng.aueb.restaurant.dao.daoInf.CustomerDAO;
import softeng.aueb.restaurant.dao.daoInf.EmployeeDAO;
import softeng.aueb.restaurant.dao.daoInf.MenuItemDAO;
import softeng.aueb.restaurant.dao.daoInf.OrderDAO;
import softeng.aueb.restaurant.dao.daoInf.OwnerDAO;
import softeng.aueb.restaurant.dao.daoInf.ProductItemDAO;
import softeng.aueb.restaurant.dao.daoInf.TableDAO;

/**
 * A class that initialized Data Access Objects
 * @author team23
 */
public class MemoryInitializer{

    /**\
     * @return a customerDAOMemory Object
     */
    public CustomerDAO getCustomerDAO() {
        return new CustomerDAOMemory();
    }

    /**\
     * @return a OwnerDAOMemory Object
     */    public OwnerDAO getOwnerDAO() {
        return new OwnerDAOMemory();
    }
    /**\
     * @return a EmployeeDAOMemory Object
     */
    public EmployeeDAO getEmployeeDAO() {
        return new EmployeeDAOMemory();
    }
    /**\
     * @return a OrderDAOMemory Object
     */
    public OrderDAO getOrderDAO() {
        return new OrderDAOMemory();
    }
    /**\
     * @return a ProductItemDAOMemory Object
     */
    public ProductItemDAO getProductItemDAO(){
        return new ProductItemDAOMemory();
    }
    /**\
     * @return a getTableDAO Object
     */
    public TableDAO getTableDAO(){
        return new TableDAOMemory();
    }
    /**\
     * @return a getMenuItemDAO Object
     */
    public MenuItemDAO getMenuItemDAO(){ return new MenuItemDAOMemory();}


    /**
     * Initializes all DAOs
     */
    public void prepareData() {
        getMenuItemDAO();
        getCustomerDAO();
        getEmployeeDAO();
        getOrderDAO();
        getOwnerDAO();
        getProductItemDAO();
        getTableDAO();
    }
}

