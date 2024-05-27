package com.example.RealEstate.dataAccess.abstracts;

import com.example.RealEstate.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
