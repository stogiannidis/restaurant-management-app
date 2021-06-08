package softeng.aueb.restaurant.dao.memorydao;
import org.junit.jupiter.api.Test;
import java.util.List;

import softeng.aueb.restaurant.dao.daoInf.OwnerDAO;
import softeng.aueb.restaurant.domain.Owner;

import static org.junit.jupiter.api.Assertions.*;

class OwnerDAOMemoryTest {
    private OwnerDAO ownerDAO = new OwnerDAOMemory();


    @Test
    public void save(){
        Owner owner = new Owner("test","test@aueb.gr","123",30);
        ownerDAO.save(owner);
        List<Owner> all = ownerDAO.findAll();
        assertTrue(all.contains(owner));
    }

    @Test
    public void delete(){
        Owner owner = new Owner("test666","test@aueb.gr","123",30);
        ownerDAO.save(owner);
        ownerDAO.delete(owner);
        assertNull(ownerDAO.find("test666"));
    }

    @Test
    public void find(){
        Owner owner = new Owner("test","test@aueb.gr","123",30);
        ownerDAO.save(owner);
        assertNotNull(ownerDAO.find("test"));
    }

    @Test
    public void findAll(){
        Owner owner = new Owner("test","test@aueb.gr","123",30);
        Owner owner1 = new Owner("test","test@aueb.gr","123",35);
        ownerDAO.save(owner);
        ownerDAO.save(owner1);
        List<Owner> all = ownerDAO.findAll();
        assertTrue(all.contains(owner));
        assertTrue(all.contains(owner1));
    }

    @Test
    public void IsEmailTaken(){
        Owner owner = new Owner("test","test@aueb.gr","123",30);
        ownerDAO.save(owner);
        assertTrue(ownerDAO.isEmailTaken("test@aueb.gr"));
        assertFalse(ownerDAO.isEmailTaken("test2@aueb.gr"));
    }
}