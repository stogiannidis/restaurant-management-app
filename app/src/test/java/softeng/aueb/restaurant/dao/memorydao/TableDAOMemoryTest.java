package softeng.aueb.restaurant.dao.memorydao;

import org.junit.jupiter.api.Test;

import java.util.List;

import softeng.aueb.restaurant.dao.daoInf.TableDAO;
import softeng.aueb.restaurant.domain.Table;

import static org.junit.jupiter.api.Assertions.*;

class TableDAOMemoryTest {
    private TableDAO tableDAO = new TableDAOMemory();


    @Test
    public void save(){
        Table table = new Table(3);
        tableDAO.save(table);
        List<Table> all = tableDAO.findAll();
        assertTrue(all.contains(table));
    }

    @Test
    public void delete(){
        Table table = new Table(666);
        tableDAO.save(table);
        tableDAO.delete(table);
        assertNull(tableDAO.find(666));
    }

    @Test
    public void find(){
        Table table = new Table(3);
        tableDAO.save(table);
        assertNotNull(tableDAO.find(3));
    }

    @Test
    public void findAll(){
        Table table = new Table(3);
        Table table2 = new Table(4);
        tableDAO.save(table);
        tableDAO.save(table2);
        List<Table> all = tableDAO.findAll();
        assertTrue(all.contains(table));
        assertTrue(all.contains(table2));
    }}