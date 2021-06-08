package softeng.aueb.restaurant.dao.daoInf;

import java.util.List;

import softeng.aueb.restaurant.domain.MenuItem;
/**
 * @author team23
 */

public interface MenuItemDAO {
    /**
     * Saves a MenuItem to memory
     * @param item the order of a customer
     */
    void save(MenuItem item);

    /**
     * Deletes a MenuItem from memory
     * @param item the order of a customer
     */
    void delete (MenuItem item);

    /**
     *  Finds a MenuItem by their name
     * @param name MenuItem's name
     * @return the MenuItem with that name or {@code null} if not found
     */
    MenuItem find (String name);

    /**
     *
     * @return All confirmed MenuItems
     */
    List<MenuItem> findAll();
}
