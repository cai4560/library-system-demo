package com.thoughtworks.library.service;

import com.thoughtworks.library.mapper.OrderMapper;
import com.thoughtworks.library.model.Order;
import com.thoughtworks.library.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public List<Order> getAllOrders(User user) {
        return orderMapper.listAll(user);
    }

    public Order findOrderById(Integer id) {
        return orderMapper.findById(id);
    }

    public void createOrder(Integer bookId, Integer userId) {
        orderMapper.create(bookId, userId);
    }

    public void deleteOrder(Integer orderId) {
        orderMapper.delete(orderId);
    }
}
