package softeng.aueb.restaurant.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void addItem() {
        Order r = new Order(123);
        MenuItem x = new MenuItem("pasta",1);
        r.addItem(x);
        assertTrue(r.isContained(x));
        MenuItem y = new MenuItem("margarita",3);
        r.addItem(y);
        assertTrue(r.isContained(y));
        r.addItem(x);
        assertTrue(r.isContained(x));

    }

    @Test
    void removeItem() {
        Order r = new Order(123);
        MenuItem x = new MenuItem("pasta",10);
        r.addItem(x);
        r.removeItem(x);
        assertFalse(r.isContained(x));
    }


    @Test
    void getOrderNumber() {
        Order r = new Order(123);
        assertEquals(123,r.getOrderNumber());
    }

    @Test
    void setOrderNumber() {
        Order r = new Order(123);
        r.setOrderNumber(1234);
        assertEquals(1234,r.getOrderNumber());
    }

    @Test
    void isPaid() {
        Order r = new Order(123);
        assertFalse(r.isPaid());
    }

    @Test
    void setPaid() {
        Order r = new Order(123);
        r.setPaid(true);
        assertTrue(r.isPaid());
    }

    @Test
    void getBasket() {
        Order r = new Order(123);
        MenuItem x = new MenuItem("margarita",1);
        r.addItem(x);
        ArrayList<MenuItem> y = new ArrayList<>();
        y.add(x);
        assertEquals(y,r.getBasket());
    }

    @Test
    void isContained() {
        Order r = new Order(123);
        MenuItem x = new MenuItem("margarita",1);
        r.addItem(x);
        assertTrue(r.isContained(x));
    }

    @Test
    void clearBasket() {
        Order r = new Order(123);
        MenuItem x = new MenuItem("margarita",1);
        r.addItem(x);
        r.clearBasket();
        assertTrue(r.getBasket().isEmpty());
    }
}