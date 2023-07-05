package com.graphql.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graphql.example.model.Book;

public interface BookRepository  extends JpaRepository<Book, Integer> {

}
