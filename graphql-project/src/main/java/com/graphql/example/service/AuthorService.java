package com.graphql.example.service;

import java.util.List;

import com.graphql.example.model.Author;

public interface AuthorService {
	List<Author> getAuthors(int id);
	Author create(Author author);
}
