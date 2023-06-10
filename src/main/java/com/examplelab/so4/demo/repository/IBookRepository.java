package com.examplelab.so4.demo.repository;

import com.examplelab.so4.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {
}
