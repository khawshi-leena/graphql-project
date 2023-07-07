package com.graphql.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphql.example.model.Author;
import com.graphql.example.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService{
	
	 private AuthorRepository authorRepo;

	  @Autowired
	  public AuthorServiceImpl(AuthorRepository authorRepo) {
	       this.authorRepo = authorRepo;
	  }
	  
	  public List<Author> getAuthors(int id) {	
		  //return  authorRepo.findAuthorsById(id).orElse(null);
		  List<Author> authors = authorRepo.findAll();
		  List<Author> authorsByID = authors.stream().filter(x->x.getBook().getId() == id).collect(Collectors.toList());
		  return authorsByID;
	  }

	@Override
	public Author create(Author author) {
		return authorRepo.save(author);
	} 
}
