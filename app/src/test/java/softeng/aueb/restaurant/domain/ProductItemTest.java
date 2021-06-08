package softeng.aueb.restaurant.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductItemTest {

    @Test
    void modifyQuantity() {
        ProductItem p = new ProductItem("margarita",10,2);
        p.modifyQuantity(1);
        assertEquals(p.getQuantityMade(),3);
    }

    @Test
    void getQuantityMade() {
        ProductItem p = new ProductItem("margarita",10,2);
        assertEquals(2,p.getQuantityMade());
    }

    @Test
    void setQuantityMade() {
        ProductItem p = new ProductItem("margarita",10,2);
        p.setQuantityMade(3);
        assertEquals(3,p.getQuantityMade());
    }

    @Test
    void getName() {
        ProductItem p = new ProductItem("margarita",10,2);
        assertEquals("margarita",p.getName());

    }

    @Test
    void setName() {
        ProductItem p = new ProductItem("margarita",10,2);
        p.setName("o");
        assertEquals("o",p.getName());
    }

    @Test
    void getCost() {
        ProductItem p = new ProductItem("margarita",10,2);
        assertEquals(10,p.getCost());
    }

    @Test
    void setCost() {
        ProductItem p = new ProductItem("margarita",10,2);
        p.setCost(12);
        assertEquals(12,p.getCost());

    }
}