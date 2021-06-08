package softeng.aueb.restaurant.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {

    @Test
    void addOrder() {
        Table t = new Table(1);
        Customer c1 = new Customer("c1","c1@","123");
        ArrayList<MenuItem> p = new ArrayList<>();
        MenuItem x = new MenuItem("pasta",1);
        p.add(x);
        c1.createOrder(p);
        t.addOrder(c1.getCurrentOrder());
        assertTrue(t.dailyOrders.contains(c1.getCurrentOrder()));
    }


    @Test
    void getTableNumber() {
        Table t = new Table(1);
        assertEquals(1,t.getTableNumber());
    }

    @Test
    void setTableNumber() {
        Table t = new Table(1);
        t.setTableNumber(2);
        assertEquals(2,t.getTableNumber());
    }

    @Test
    void getTotalCost() {
        Table t = new Table(1);
        Customer c1 = new Customer("c1","c1@","123");
        ArrayList<MenuItem> p = new ArrayList<>();
        MenuItem x = new MenuItem("pasta",1);
        p.add(x);
        c1.createOrder(p);
        t.addOrder(c1.getCurrentOrder());
        assertEquals(0,t.getTotalCost());
    }


}