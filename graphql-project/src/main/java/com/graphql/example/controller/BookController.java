package com.graphql.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
//import org.springframework.graphql.data.method.annotation.Argument;
//import org.springframework.graphql.data.method.annotation.Arguments;
//import org.springframework.graphql.data.method.annotation.MutationMapping;
//import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graphql.example.model.Book;
import com.graphql.example.service.BookService;

import lombok.Getter;
import lombok.Setter;


@RestController
@RequestMapping("/book")
public class BookController {
	
	
    private BookService bookService;
	
    @Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
    
   @GetMapping("/")
    public List<Book> getAll() {
    	return bookService.getAll();
    }
    
    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable int bookId) {
    	return bookService.get(bookId);
    }
   
    @PostMapping("/create")
	public Book addEmployee(@RequestBody Book book) {
		return bookService.create(book);
	}
	
	@PostMapping("/createAll")
	public List<Book> addEmployee(@RequestBody List<Book> book) {
		return bookService.createAll(book);
}
    

	
//	 @MutationMapping("createBook") 
//	 public Book create(@Arguments BookInput book) { 
//		  Book b=new Book(); 
//		  b.setTitle(book.getTitle()); 
//		  b.setDescription(book.getDescription());
//		  b.setPrice(book.getPrice()); 
//		  b.setAuthor(book.getAuthor());
//		  b.setPages(book.getPages()); 
//		  return bookService.create(b); 
//	  }
//	 
//	  @MutationMapping("updateBook")
//	  public Book update(@Argument BookInput book) {
//		  
//		  Book b=new Book(); 
//		  b.setId(book.getId());
//		  b.setTitle(book.getTitle()); 
//		  b.setDescription(book.getDescription());
//		  b.setPrice(book.getPrice()); 
//		  b.setAuthor(book.getAuthor());
//		  b.setPages(book.getPages()); 
//		  return bookService.update(b);
//	  }
//	  
//	  @MutationMapping("deleteBook")
//	  public String deleteBookById(@Argument int id) {
//		  bookService.deleteById(id);
//		  return "Book deleted with Id"+ id;
//	  }
//	  
//	  @QueryMapping("allBooks") 
//	  public List<Book> getAll() { 
//		  return bookService.getAll(); }
//	  
//	  @QueryMapping("getBook") 
//	  public Book get(@Argument int bookId) { 
//		  return bookService.get(bookId); 
//	  }
}

@Getter
@Setter
class BookInput{
	private int id;
    private String title;
    private String description;
    private String author;
    private double price;
    private int pages;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
    
}
