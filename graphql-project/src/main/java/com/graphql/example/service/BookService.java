package com.graphql.example.service;

import java.util.List;

import com.graphql.example.model.Book;


public interface BookService {
	
	 //create
    Book create(Book book);

    //get all
    List<Book> getAll();

    //get single book
    Book get(int bookId);
    
    List<Book> createAll(List<Book> books);
    
    Book update(Book book);
    
    String deleteById(int id);

}
