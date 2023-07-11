package com.graphql.example.service;

import com.graphql.example.model.Book;
import com.graphql.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookService {
	
	 private BookRepository bookRep;

	  @Autowired
	  public BookService(BookRepository bookRep) {
	       this.bookRep = bookRep;
	  }

	public Book get(int id) {
		return bookRep.findById(id).orElse(null);
	}

	public List<Book> getBooks(List<Integer> ids) {
		  return bookRep.findAllById(ids);
	}

	public Map<Integer,List<Book>> getByAuthorIds(List<Integer> authorIds) {
		return bookRep.findByAuthors_IdIn(authorIds)
				.stream()
				.collect(Collectors.groupingBy(a->a.getId()));
	}

	public Book create(Book book) {
		return this.bookRep.save(book);
	}
}
