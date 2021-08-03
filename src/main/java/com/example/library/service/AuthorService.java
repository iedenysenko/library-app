package com.example.library.service;

import com.example.library.model.Author;
import com.example.library.model.dto.AuthorDto;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface AuthorService {
    Author create(Author author);
    
    ResponseEntity<Object> update(Author author, Long id);
    
    List<AuthorDto> getAll();
    
    AuthorDto getById(Long id);
    
    List<AuthorDto> getByBookTitle(String title);
}
