package softeng.aueb.restaurant.dao.memorydao;

import java.util.ArrayList;
import java.util.List;

import softeng.aueb.restaurant.dao.daoInf.MenuItemDAO;
import softeng.aueb.restaurant.domain.MenuItem;

public class MenuItemDAOMemory implements MenuItemDAO {
    ArrayList<MenuItem> items = new ArrayList<>();
    /**
     * Saves a MenuItem to memory
     *
     * @param item the order of a customer
     */
    @Override
    public void save(MenuItem item) {
        items.add(item);
    }

    /**
     * Deletes a MenuItem from memory
     *
     * @param item the order of a customer
     */
    @Override
    public void delete(MenuItem item) {
        items.remove(item);
    }

    /**
     * Finds a MenuItem by their name
     *
     * @param name MenuItem's name
     * @return the MenuItem with that name or {@code null} if not found
     */
    @Override
    public MenuItem find(String name) {
        for(MenuItem item: items){
            if(name.equals(item.getName())){
                return item;
            }
        }
        return null;
    }

    /**
     * @return All confirmed MenuItems
     */
    @Override
    public List<MenuItem> findAll() {
        return new ArrayList<>(items);
    }
}
