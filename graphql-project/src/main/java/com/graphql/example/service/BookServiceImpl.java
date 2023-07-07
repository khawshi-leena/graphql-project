package com.graphql.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphql.example.model.Book;
import com.graphql.example.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	 private BookRepository bookRep;

	  @Autowired
	  public BookServiceImpl(BookRepository bookRep) {
	       this.bookRep = bookRep;
	  }


	@Override
	public Book create(Book book) {
		return this.bookRep.save(book);
	}
	

	@Override
	public List<Book> getAll() {
		return this.bookRep.findAll();	
	}

	@Override
	public Book get(int bookId) {
		 return this.bookRep.findById(bookId).orElseThrow(() -> new RuntimeException("Book you are looking for not found on server !!"));
	}


	@Override
	public List<Book> createAll(List<Book> books) {
		
		return bookRep.saveAll(books);
	}


	@Override
	public Book update(Book book) {
		Book existingBook = bookRep.findById(book.getId()).orElse(null);
		
		existingBook.setId(book.getId());
		existingBook.setTitle(book.getTitle());
		existingBook.setAuthors(book.getAuthors());
		existingBook.setDescription(book.getDescription());
		existingBook.setPages(book.getPages());
		existingBook.setPrice(book.getPrice());
		
		return bookRep.save(existingBook);
		
	}


	@Override
	public String deleteById(int id) {
		Book existingBook = bookRep.findById(id).orElse(null);
		bookRep.delete(existingBook);
		return "Book entry removed with id: " + id;
	}

}
