package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.model.dto.BookDto;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface BookService {
    
    Book create(Book book);
    
    ResponseEntity<Object> update(Book book, Long id);
    
    BookDto getById(Long id);
    
    List<BookDto> getAll();
}
