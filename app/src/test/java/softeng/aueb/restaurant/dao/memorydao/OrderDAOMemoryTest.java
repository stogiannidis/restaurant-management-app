package softeng.aueb.restaurant.dao.memorydao;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import softeng.aueb.restaurant.dao.daoInf.OrderDAO;
import softeng.aueb.restaurant.domain.Order;

import static org.junit.jupiter.api.Assertions.*;

class OrderDAOMemoryTest {
    private OrderDAO orderDAO = new OrderDAOMemory();

    @Test
    public void delete(){
        Order order = new Order(20);
        orderDAO.save(order);
        orderDAO.delete(order);
        List<Order> all = orderDAO.findAll();
        assertFalse(all.contains(order));
    }

    @Test
    public void save(){
        Order order = new Order(20);
        orderDAO.save(order);
        List<Order> all = orderDAO.findAll();
        assertTrue(all.contains(order));
    }

    @Test
    public void find(){
        Order order = new Order(20);
        orderDAO.save(order);
        assertNotNull(orderDAO.find(20));
    }

    @Test
    public void findAll(){
        Order order = new Order(20);
        Order order1 = new Order(21);
        orderDAO.save(order);
        orderDAO.save(order1);
        List<Order> all = orderDAO.findAll();
        assertTrue(all.contains(order));
        assertTrue(all.contains(order1));
    }

    @Test
    public void findUnverified(){
        Order order = new Order(20);
        Order order1 = new Order(21);
        order.verify();
        orderDAO.save(order);
        orderDAO.save(order1);
        assertTrue(orderDAO.findUnverified().contains(order1));
        assertFalse(orderDAO.findUnverified().contains(order));
    }

    @Test
    public void findUnpaid(){
        Order order = new Order(20);
        Order order1 = new Order(21);
        order.verify();
        order.setPaid(true);
        order1.verify();
        orderDAO.save(order);
        orderDAO.save(order1);
        assertTrue(orderDAO.findUnpaid().contains(order1));
        assertFalse(orderDAO.findUnpaid().contains(order));
    }

}