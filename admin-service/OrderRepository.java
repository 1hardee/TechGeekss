package com.hardishastri.ecommercemicroservices.adminservice.repository;

import com.hardishastri.ecommercemicroservices.adminservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
