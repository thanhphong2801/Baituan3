package com.examplelab.so4.enity;

import com.examplelab.so4.Validator.annotation.ValidUserId;
import jakarta.persistence.*;
import lombok.Data;

@Data
    @Entity
    @Table(name = "book")
    public class Book{
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }

        public Book(Long id, String title, String author, Double price, Category category) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.price = price;
            this.category = category;
        }

        public Book() {
        }

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private  Long id;
        @Column(name = "title")
        private String title;
        @Column(name = "author")
        private String author;
        @Column(name = "price")
        private Double price;
        @ManyToOne
        @JoinColumn(name = "category_id")
        private Category category;

        @ManyToOne
        @JoinColumn(name = "user_id", referencedColumnName = "id")
        @ValidUserId
        private User user;
    }
