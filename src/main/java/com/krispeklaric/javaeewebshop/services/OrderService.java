/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.services;

import com.krispeklaric.javaeewebshop.dtos.OrderDTO;
import com.krispeklaric.javaeewebshop.models.Order;
import com.krispeklaric.javaeewebshop.models.User;
import com.krispeklaric.javaeewebshop.repositories.OrderRepository;
import com.krispeklaric.javaeewebshop.services.interfaces.IOrderService;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Kris
 */
public class OrderService implements IOrderService {

    OrderRepository _orderRepository;

    public OrderService() {
        _orderRepository = new OrderRepository();
    }

    @Override
    public Order create(OrderDTO order) {
        Order newOrder = new Order();
        newOrder.setAddress(order.getAddress());
        newOrder.setCreated(LocalDateTime.now());
        newOrder.setPayment_type(order.getPaymentType());
        newOrder.setUser(order.getUser());
        newOrder.setTotal(order.calculateTotalPrice());
        newOrder.setOrderItem(order.getItems());
        Order result = _orderRepository.create(newOrder);

        return result;
    }

    @Override
    public List<Order> getAll(User user) {
        List<Order> resultOrders = _orderRepository.getAll(user);
        return resultOrders;
    }

    @Override
    public List<Order> getAll(LocalDateTime date) {
        List<Order> resultOrders = _orderRepository.getAll(date);
        return resultOrders;
    }

    @Override
    public List<Order> getAll() {
        List<Order> resultOrders = _orderRepository.getAll();
        return resultOrders;
    }

}
