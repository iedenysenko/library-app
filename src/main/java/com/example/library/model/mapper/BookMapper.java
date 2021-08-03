package com.example.library.model.mapper;

import com.example.library.model.Book;
import com.example.library.model.dto.BookDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper/*(uses = {AuthorMapper.class})*/ public interface BookMapper {
    BookMapper BOOK_MAPPER = Mappers.getMapper(BookMapper.class);
    
    BookDto fromBook(Book book);
    
    @InheritInverseConfiguration
    Book toBook(BookDto bookDto);
}
