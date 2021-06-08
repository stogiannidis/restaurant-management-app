package softeng.aueb.restaurant.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {



    @Test
    void createOrder() {
        Customer c = new Customer("ody","odycaptain@gmail.com","123");
        ArrayList<MenuItem> p = new ArrayList<>();
        p.add(new MenuItem("pasta",1));
        p.add(new MenuItem("margarita",1));
        c.createOrder(p);
        assertTrue(c.orders.containsKey(c.getOrderId()));
    }

    @Test
    void getUsername() {
        Customer c = new Customer("ody","odycaptain@gmail.com","123");
        assertEquals("ody",c.getUsername());
    }

    @Test
    void setUsername() {
        Customer c = new Customer("ody","odycaptain@gmail.com","123");
        c.setUsername("kke");
        assertEquals("kke",c.getUsername());

    }

    @Test
    void getEmail() {
        Customer c = new Customer("ody","odycaptain@gmail.com","123");
        assertEquals("odycaptain@gmail.com",c.getEmail());
    }

    @Test
    void setEmail() {
        Customer c = new Customer("ody","odycaptain@gmail.com","123");
        c.setEmail("kke");
        assertEquals("kke",c.getEmail());
    }

    @Test
    void getPassword() {
        Customer c = new Customer("ody","odycaptain@gmail.com","123");
        assertEquals("123",c.getPassword());
    }

    @Test
    void setPassword() {
        Customer c = new Customer("ody","odycaptain@gmail.com","123");
        c.setPassword("kke");
        assertEquals("kke",c.getPassword());
    }

    @Test
    void getOrders() {
        Customer c = new Customer("ody","odycaptain@gmail.com","123");

    }

    @Test
    void getOrderId() {
        Customer c = new Customer("ody","odycaptain@gmail.com","123");
        ArrayList<MenuItem> p = new ArrayList<>();
        p.add(new MenuItem("pasta",1));
        p.add(new MenuItem("margarita",1));
        c.createOrder(p);
        assertTrue(c.getOrderId()>0);
    }

    @Test
    void getCurrentOrder() {
        Customer c = new Customer("ody","odycaptain@gmail.com","123");
        assertEquals(c.getOrders().get(c.getOrderId()), c.getCurrentOrder());
    }
}