package softeng.aueb.restaurant.dao.memorydao;

import org.junit.jupiter.api.Test;

import java.util.List;

import softeng.aueb.restaurant.dao.daoInf.MenuItemDAO;
import softeng.aueb.restaurant.domain.MenuItem;

import static org.junit.jupiter.api.Assertions.*;

class MenuItemDAOMemoryTest {
    private MenuItemDAO menuItemDAO = new MenuItemDAOMemory();


    @Test
    public void save(){
        MenuItem menuItem = new MenuItem("pasta",20);
        menuItemDAO.save(menuItem);
        List<MenuItem> all = menuItemDAO.findAll();
        assertTrue(all.contains(menuItem));
    }

    @Test
    public void delete(){
        MenuItem menuItem = new MenuItem("pasta",20);
        menuItemDAO.save(menuItem);
        menuItemDAO.delete(menuItem);
        List<MenuItem> all = menuItemDAO.findAll();
        assertTrue(all.isEmpty());
    }

    @Test
    public void find(){
        MenuItem menuItem = new MenuItem("pasta",20);;
        menuItemDAO.save(menuItem);
        assertNotNull(menuItemDAO.find("pasta"));
    }

    @Test
    public void findAll(){
        MenuItem menuItem = new MenuItem("pasta",20);
        MenuItem menuItem2 = new MenuItem("pizza",20);
        menuItemDAO.save(menuItem);
        menuItemDAO.save(menuItem2);
        List<MenuItem> all = menuItemDAO.findAll();
        assertTrue(all.contains(menuItem));
        assertTrue(all.contains(menuItem2));
    }
}