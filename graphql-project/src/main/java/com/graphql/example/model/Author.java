package com.graphql.example.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
public class Author {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
	List<Book> books;
	
	String authorName;
	
	int contactNo;
}
