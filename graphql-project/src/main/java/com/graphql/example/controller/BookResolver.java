package com.graphql.example.controller;

import java.util.ArrayList;
import java.util.List;

import com.graphql.example.model.Author;
import com.graphql.example.model.Book;
import com.graphql.example.service.AuthorService;
import com.graphql.example.service.BookService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

@DgsComponent
public class BookResolver {
	
	
	private BookService bookService;
   
	private AuthorService authorService;
		
	public BookResolver(BookService bookService, AuthorService authorService) {
		this.bookService = bookService;
		this.authorService = authorService;
	}
    
    @DgsQuery
	public List<Book> allBooks() { 
    	return bookService.getAll(); 
	}
	
	@DgsData(parentType = "Book", field = "authors")
	public List<Author> authors(DgsDataFetchingEnvironment dfe) {
		Book book = dfe.getSource();
		List<Author> authors = new ArrayList<Author>();
	   	authors = authorService.getAuthors(book.getId());
	   	return authors;
	}
	  
	@DgsQuery 
	 public Book getBook(@InputArgument int bookId) { 
		return bookService.get(bookId); 
	 }
}
