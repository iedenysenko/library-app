package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.model.dto.BookDto;
import com.example.library.service.BookService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        return bookService.getById(id);
    }
    
    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookService.getAll();
    }
    
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.create(book);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateBook(@RequestBody Book book, Long id) {
        return bookService.update(book, id);
    }
}
