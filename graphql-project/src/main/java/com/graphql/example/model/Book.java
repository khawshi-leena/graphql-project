package com.graphql.example.model;

import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
    private String title;
    
    private String description;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable
    private List<Author> authors;
    
    private double price;
    
    private int pages;
    
}
