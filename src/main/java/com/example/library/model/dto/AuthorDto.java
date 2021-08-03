package com.example.library.model.dto;

import java.util.List;
import lombok.Data;

@Data
public class AuthorDto {
    private Long id;
    private String name;
    private String lastName;
    private List<BookDto> booksList;
}
