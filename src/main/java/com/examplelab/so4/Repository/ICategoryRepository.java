package com.examplelab.so4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.examplelab.so4.enity.Category;
@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
