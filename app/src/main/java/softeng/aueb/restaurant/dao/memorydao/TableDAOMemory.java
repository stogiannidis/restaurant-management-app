package softeng.aueb.restaurant.dao.memorydao;

import java.util.ArrayList;
import java.util.List;

import softeng.aueb.restaurant.dao.daoInf.TableDAO;
import softeng.aueb.restaurant.domain.ProductItem;
import softeng.aueb.restaurant.domain.Table;

public class TableDAOMemory implements TableDAO {
    static ArrayList<Table> tables = new ArrayList<>();
    /**
     * Saves a Table to memory
     *
     * @param table the table of the restaurant
     */
    @Override
    public void save(Table table) {
        tables.add(table);
    }

    /**
     * Deletes a Table from memory
     *
     * @param table the table of the restaurant
     */
    @Override
    public void delete(Table table) {
        tables.remove(table);
    }

    /**
     * Finds a Table by their tableNumber
     *
     * @param number Table's tableNumber
     * @return the Table with that tableNumber or {@code null} if not found
     */
    @Override
    public Table find(int number) {
        for (Table table: tables) {
            if (table.getTableNumber() == number)
                return table;
        }
        return null;
    }

    /**
     * @return All Tables
     */
    @Override
    public List<Table> findAll() {
        return new ArrayList<>(tables);
    }

    @Override
    public int getAvailableTables(){
        return tables.size();
    }
}
