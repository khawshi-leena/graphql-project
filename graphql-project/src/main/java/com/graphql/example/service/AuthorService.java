package com.graphql.example.service;

import com.graphql.example.model.Author;
import com.graphql.example.repository.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class AuthorService {

	private final static Logger logger = LoggerFactory.getLogger(AuthorService.class);

	 private AuthorRepository authorRepo;

	  @Autowired
	  public AuthorService(AuthorRepository authorRepo) {
	       this.authorRepo = authorRepo;
	  }
	  
	  public Author getById(int author_id) {
		  return authorRepo.findById(author_id).orElse(null);
	  }

	  public List<Author> getAuthors(List<Integer> ids) {
		  return authorRepo.findAllById(ids);
	  }

	public Map<Integer, List<Author>> getByBookIds(List<Integer> bookIds) {
		return authorRepo.findByBooks_IdIn(bookIds)
				.stream()
				.collect(Collectors.groupingBy(a->a.getId()));
	}

	  public Author create(Author author) {
		  return authorRepo.save(author);
	  }
}
