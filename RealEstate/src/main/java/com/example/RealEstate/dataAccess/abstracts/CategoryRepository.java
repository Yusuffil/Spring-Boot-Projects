package com.example.RealEstate.dataAccess.abstracts;

import com.example.RealEstate.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    boolean existsByName(String name);
}
