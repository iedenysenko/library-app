package com.example.library.controller;

import com.example.library.model.Author;
import com.example.library.model.dto.AuthorDto;
import com.example.library.service.AuthorService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;
    
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    
    @GetMapping
    public List<AuthorDto> getAllAuthors() {
        return authorService.getAll();
    }
    
    @GetMapping("/{id}")
    public AuthorDto getAuthorById(@PathVariable Long id) {
        return authorService.getById(id);
    }
    
    @GetMapping("/getByKeyword")
    public List<AuthorDto> getByBookKeyword(@RequestParam String title) {
        return authorService.getByBookTitle(title);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAuthor(@RequestBody Author author, @PathVariable Long id) {
        return authorService.update(author, id);
    }
    
    @PostMapping
    public Author addAuthor(@RequestBody Author author) {
        return authorService.create(author);
    }
}
