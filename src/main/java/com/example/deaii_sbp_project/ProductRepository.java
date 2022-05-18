package com.example.deaii_sbp_project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%"
            + " OR p.madein LIKE %?1%"
            + " OR CONCAT(p.price, '') LIKE %?1%")
    public List<Product> search(String keyword);
}
