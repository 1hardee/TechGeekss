package com.hardishastri.ecommercemicroservices.orderservice.controller;

import com.hardishastri.ecommercemicroservices.orderservice.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();

    Order saveOrder(Order order);
}
