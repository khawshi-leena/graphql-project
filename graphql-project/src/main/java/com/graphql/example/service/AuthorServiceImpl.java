package com.graphql.example.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphql.example.model.Author;
import com.graphql.example.repository.AuthorRepository;


@Service
public class AuthorServiceImpl implements AuthorService{

	private final static Logger logger = LoggerFactory.getLogger(AuthorServiceImpl.class);

	private final BookService bookService;
	private final Map<Integer, List<Author>> authorMap = new ConcurrentHashMap<>();
	
	 private AuthorRepository authorRepo;

	  @Autowired
	  public AuthorServiceImpl(AuthorRepository authorRepo, BookService bookService) {
	       this.authorRepo = authorRepo;
		   this.bookService = bookService;
	  }
	  
	  public List<Author> getAuthors(int id) {
		  List<Author> authors = authorRepo.findAuthorByBook_Id(id);
		  if(authorMap.containsKey(id)) {
			  authorMap.get(id).addAll(authors);
		  } else {
			  authorMap.put(id, authors);
		  }
		  return  authors;
	  }

	@Override
	public Author create(Author author) {
		return authorRepo.save(author);
	}

	public Map<Integer, List<Author>> authorsForBooks(List<Integer> bookIds) {
			return authorRepo.findAuthorsByBook_IdIn(bookIds)
					.stream()
					.collect(Collectors.groupingBy(a->a.getBook().getId()));
	}

	public List<Author> authorsByBookIds(List<Integer> bookIds) {
		return authorRepo.findAuthorsByBook_IdIn(bookIds);
	}

	public List<Author> authorsForShow(Integer bookId) {
		return authorMap.get(bookId);
	}

}
