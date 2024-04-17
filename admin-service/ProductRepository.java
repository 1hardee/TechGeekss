package com.hardishastri.ecommercemicroservices.adminservice.repository;

import com.hardishastri.ecommercemicroservices.adminservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
