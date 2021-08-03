package com.example.library.service.impl;

import com.example.library.model.Author;
import com.example.library.model.dto.AuthorDto;
import com.example.library.model.mapper.AuthorMapper;
import com.example.library.repository.AuthorRepository;
import com.example.library.service.AuthorService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    
    @Override
    public Author create(Author author) {
        return authorRepository.save(author);
    }
    
    @Override
    public ResponseEntity<Object> update(Author author, Long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (!authorOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        author.setId(id);
        authorRepository.save(author);
        return ResponseEntity.noContent().build();
    }
    
    @Override
    public List<AuthorDto> getAll() {
        List<AuthorDto> authorDtoList = new ArrayList<>();
        List<Author> authorList = authorRepository.findAll();
        for (Author author : authorList) {
            authorDtoList.add(AuthorMapper.AUTHOR_MAPPER.fromAuthor(author));
        }
        return authorDtoList;
    }
    
    @Override
    public AuthorDto getById(Long id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (!optionalAuthor.isPresent()) {
            return null;
        }
        Author author = optionalAuthor.get();
        AuthorDto authorDto = AuthorMapper.AUTHOR_MAPPER.fromAuthor(author);
        return authorDto;
    }
    
    @Override
    public List<AuthorDto> getByBookTitle(String title) {
        List<AuthorDto> authorDtoList = new ArrayList<>();
        List<Author> authorList = authorRepository.findAuthorsByBookTitle(title);
        for (Author author : authorList) {
            authorDtoList.add(AuthorMapper.AUTHOR_MAPPER.fromAuthor(author));
        }
        return authorDtoList;
    }
}
