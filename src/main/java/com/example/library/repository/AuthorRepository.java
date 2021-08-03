package com.example.library.repository;

import com.example.library.model.Author;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author a JOIN FETCH a.books b WHERE b.title LIKE %:title%")
    List<Author> findAuthorsByBookTitle(@Param("title") String title);
}
