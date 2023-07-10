package com.graphql.example.service;

import java.util.List;

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
		  return  authorRepo.findAuthorByBook_Id(id);
	  }

	@Override
	public Author create(Author author) {
		return authorRepo.save(author);
	} 
}
