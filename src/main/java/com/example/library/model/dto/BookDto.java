package com.example.library.model.dto;

import java.util.List;
import lombok.Data;

@Data
public class BookDto {
    private Long id;
    private String title;
    private Long authorId;
    private List<AuthorDto> authorsList;
}
