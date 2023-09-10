package ru.aston.intensive.intensive34;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.aston.druzhinin_ri.task4.model.Order;
import ru.aston.druzhinin_ri.task4.repository.RepositoryImplOrder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderTest {
    static RepositoryImplOrder orderImpl;

    @BeforeAll
    static void init() {
        UserTest.repositoryData.scriptRun();
        orderImpl = new RepositoryImplOrder();
    }

    @Test
    void findAll() {
        List<Order> list = orderImpl.findAll();
        System.out.println(list);
        assertEquals(list.get(0).getNumberOfOrder(), 111);
    }

    @Test
    void findEntityById() {
        Order order = new Order(1,111);
        assertEquals(orderImpl.findEntityById(order.getId()).getNumberOfOrder(), 111);
    }


    @Test
    void delete() {
        assertTrue(orderImpl.delete(3));
    }

    @Test
    void create() {
        Order order = new Order(3,333);
        assertTrue(orderImpl.create(order));
    }

    @Test
    void update() {
        Order order = new Order(2,232);
        assertEquals(orderImpl.update(order).getNumberOfOrder(), 232);
    }

}
