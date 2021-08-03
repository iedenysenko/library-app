package com.example.library.service.impl;

import com.example.library.model.Book;
import com.example.library.model.dto.BookDto;
import com.example.library.model.mapper.BookMapper;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }
    
    @Override
    public ResponseEntity<Object> update(Book book, Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (!bookOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        book.setId(id);
        bookRepository.save(book);
        return ResponseEntity.noContent().build();
    }
    
    @Override
    public BookDto getById(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (!bookOptional.isPresent()) {
            return null;
        }
        Book book = bookOptional.get();
        BookDto bookDto = BookMapper.BOOK_MAPPER.fromBook(book);
        return bookDto;
    }
    
    @Override
    public List<BookDto> getAll() {
        List<BookDto> bookDtos = new ArrayList<>();
        List<Book> bookList = bookRepository.findAll();
        for (Book book : bookList) {
            bookDtos.add(BookMapper.BOOK_MAPPER.fromBook(book));
        }
        return bookDtos;
    }
}
