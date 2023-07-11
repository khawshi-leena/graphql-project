package com.graphql.example.repository;

import com.graphql.example.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import com.graphql.example.model.Book;

import java.util.List;

public interface BookRepository  extends JpaRepository<Book, Integer> {
    // public List<Book> findAllByAuthors(List<Integer> authorIds);

    public List<Book> findByAuthors_IdIn(List<Integer> authorIds);

}
