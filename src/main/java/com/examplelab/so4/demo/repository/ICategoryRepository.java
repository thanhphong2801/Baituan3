package com.examplelab.so4.demo.repository;

import com.examplelab.so4.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}

