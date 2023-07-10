package com.graphql.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphql.example.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

		public List<Author> findAuthorByBook_Id(int id);
	}
