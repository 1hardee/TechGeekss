package com.hardishastri.ecommercemicroservices.orderservice.service;

import com.hardishastri.ecommercemicroservices.orderservice.entity.Order;
import com.hardishastri.ecommercemicroservices.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order saveOrder(Order order) {

        return orderRepository.save(order);
    }


}
