package com.examplelab.so4.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.examplelab.so4.enity.Book;
import com.examplelab.so4.services.BookService;
import com.examplelab.so4.services.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String showAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books/list";
    }

    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "books/add";
    }

    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.getAllCategories());
            return "books/add";
        }
        bookService.addBook(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        Book book = bookService.getBookById(id);
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id") Long id, Model model) {
        Book editBook = bookService.getBookById(id);
        if (editBook != null) {
            model.addAttribute("book", editBook);
            model.addAttribute("categories", categoryService.getAllCategories());
            return "book/edit";
        } else {
            return "not-found";
        }
    }

    @PostMapping("/edit")
    public String editBook(@ModelAttribute("book") Book updatedBook) {
        bookService.updateBook(updatedBook);
        return "redirect:/books";
    }
}
//    @PostMapping("/edit")
//    public String editBook(@ModelAttribute("book") Book updatedBook)
//    {
//        bookService.getAllBooks().stream()
//                .filter(book -> book.getId() == updatedBook.getId())
//                .findFirst()
//                .ifPresent(book -> book.setId(book.getId()));
//        return "redirect:/books";
//    }
//}
