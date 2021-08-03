package com.example.library.model.mapper;

import com.example.library.model.Author;
import com.example.library.model.dto.AuthorDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = BookMapper.class)
public interface AuthorMapper {
    AuthorMapper AUTHOR_MAPPER = Mappers.getMapper(AuthorMapper.class);
    
    @Mapping(source = "books", target = "booksList")
    AuthorDto fromAuthor(Author author);
}
