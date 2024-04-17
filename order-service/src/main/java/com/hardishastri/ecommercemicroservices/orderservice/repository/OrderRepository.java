package com.hardishastri.ecommercemicroservices.orderservice.repository;

import com.hardishastri.ecommercemicroservices.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
