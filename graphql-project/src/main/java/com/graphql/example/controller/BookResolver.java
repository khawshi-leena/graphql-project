package com.graphql.example.controller;

import com.graphql.example.model.Author;
import com.graphql.example.model.Book;
import com.graphql.example.service.AuthorService;
import com.graphql.example.service.BookService;
import com.netflix.graphql.dgs.*;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@DgsComponent
public class BookResolver {
	
	
	private BookService bookService;
   
	private AuthorService authorService;
		
	public BookResolver(BookService bookService, AuthorService authorService) {
		this.bookService = bookService;
		this.authorService = authorService;
	}
    

	
	/*@DgsData(parentType = "Book", field = "authors")
	public List<Author> authors(DgsDataFetchingEnvironment dfe) {
		Book book = dfe.getSource();
		List<Author> authors = new ArrayList<Author>();
	   	authors = authorService.getAuthors(book.getId());
	   	return authors;
	}*/
	  
	@DgsQuery 
	 public Book getBook(@InputArgument int id) {
		return bookService.get(id);
	 }

	@DgsQuery
	public List<Book> getBooks(@InputArgument List<Integer> ids) {
		return bookService.getBooks(ids);
	}

	@DgsData(parentType = "Author", field = "books")
	public CompletableFuture<List<Book>> books(DgsDataFetchingEnvironment dfe) {
		DataLoader<Integer, List<Book>> bookDataLoader = dfe.getDataLoader("books");
		Author author = dfe.getSource();

		return bookDataLoader.load(author.getId());
	}
}
