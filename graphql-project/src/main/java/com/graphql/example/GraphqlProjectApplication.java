package com.graphql.example;

import com.graphql.example.model.Author;
import com.graphql.example.model.Book;
import com.graphql.example.service.AuthorService;
import com.graphql.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class GraphqlProjectApplication  implements org.springframework.boot.CommandLineRunner   {
	
	@Autowired
    private BookService bookService;

	@Autowired
	private AuthorService authorService;

	public static void main(String[] args) {
		SpringApplication.run(GraphqlProjectApplication.class, args);
	}
	
	@Override public void run(String... args) throws Exception {
//		Author a1 = new Author();
//		a1.setId(1);
//		a1.setAuthorName("Monali");
//		a1.setContactNo(12789);
//
//		Author a2 = new Author();
//		a2.setId(2);
//		a2.setAuthorName("Leena");
//		a2.setContactNo(12345);
//
//		Author a3 = new Author();
//		a3.setId(3);
//		a3.setAuthorName("Mayur");
//		a3.setContactNo(12234);
//
//		 Book b1 = new Book(); b1.setTitle("Complete Reference");
//		 b1.setDescription("For learning java");
//		 b1.setPages(4500);
//		 b1.setPrice(5000);
//		 b1.setAuthors(Arrays.asList(a1,a2));
//
//		 Book b2 = new Book(); b2.setTitle("Think Java");
//		 b2.setDescription("Complete reference for java");
//		 b2.setPages(2110); b2.setPrice(2500);
//		 b2.setAuthors(Arrays.asList(a3,a2));
//
//		 a1.setBooks(Arrays.asList(b1));
//		 a2.setBooks(Arrays.asList(b1,b2));
//		 a3.setBooks(Arrays.asList(b2));

//		authorService.create(a1);
//		authorService.create(a2);
//		authorService.create(a3);
//		 bookService.create(b1);
//		 bookService.create(b2);

	}

}
