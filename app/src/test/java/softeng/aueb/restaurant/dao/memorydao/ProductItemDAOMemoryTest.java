package softeng.aueb.restaurant.dao.memorydao;

import org.junit.jupiter.api.Test;

import java.util.List;

import softeng.aueb.restaurant.dao.daoInf.ProductItemDAO;
import softeng.aueb.restaurant.domain.ProductItem;

import static org.junit.jupiter.api.Assertions.*;

class ProductItemDAOMemoryTest {
    private ProductItemDAO productItemDAO = new ProductItemDAOMemory();


    @Test
    public void save(){
        ProductItem productItem = new ProductItem("pasta",20,20);
        productItemDAO.save(productItem);
        List<ProductItem> all = productItemDAO.findAll();
        assertTrue(all.contains(productItem));
    }

    @Test
    public void delete(){
        ProductItem productItem = new ProductItem("pasta",20,20);
        productItemDAO.save(productItem);
        productItemDAO.delete(productItem);
        List<ProductItem> all = productItemDAO.findAll();
        assertNull(productItemDAO.find("pasta"));
    }

    @Test
    public void find(){
        ProductItem productItem = new ProductItem("pasta",20,20);
        productItemDAO.save(productItem);
        assertNotNull(productItemDAO.find("pasta"));
    }

    @Test
    public void findAll(){
        ProductItem productItem = new ProductItem("pasta",20,20);
        ProductItem productItem1 = new ProductItem("pizza",20,20);
        productItemDAO.save(productItem);
        productItemDAO.save(productItem1);
        List<ProductItem> all = productItemDAO.findAll();
        assertTrue(all.contains(productItem));
        assertTrue(all.contains(productItem1));
    }

}