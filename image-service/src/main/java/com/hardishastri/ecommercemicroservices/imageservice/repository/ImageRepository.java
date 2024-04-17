package com.hardishastri.ecommercemicroservices.imageservice.repository;

import com.hardishastri.ecommercemicroservices.imageservice.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

}
