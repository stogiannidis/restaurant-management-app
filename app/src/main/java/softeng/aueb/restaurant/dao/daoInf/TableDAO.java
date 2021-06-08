package softeng.aueb.restaurant.dao.daoInf;
import java.util.List;


import softeng.aueb.restaurant.domain.Table;

/**
 * @author team23
 */

public interface TableDAO {
    /**
     * Saves a Table to memory
     * @param table the table of the restaurant
     */
    void save(Table table);

    /**
     * Deletes a Table from memory
     * @param table the table of the restaurant
     */
    void delete (Table table);

    /**
     *  Finds a Table by their tableNumber
     * @param number Table's tableNumber
     * @return the Table with that tableNumber or {@code null} if not found
     */
    Table find (int number);

    /**
     *
     * @return All Tables
     */
    List<Table> findAll();

    int getAvailableTables();
}
