package com.graphql.example.controller;

import com.graphql.example.model.Author;
import com.graphql.example.model.Book;
import com.graphql.example.service.AuthorService;
import com.netflix.graphql.dgs.*;
import org.dataloader.DataLoader;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@DgsComponent
public class AuthorResolver {

    private final AuthorService authorService;

    public AuthorResolver(AuthorService authorService) {
        this.authorService = authorService;
    }

    @DgsQuery
    public Author getAuthor(@InputArgument int id) {
        return authorService.getById(id);
    }

    @DgsQuery
    public List<Author> getAuthors(List<Integer> ids) {
        return authorService.getAuthors(ids);
    }

    @DgsData(parentType = "Book", field = "authors")
    public CompletableFuture<List<Author>> authors(DgsDataFetchingEnvironment dfe) {
        DataLoader<Integer, List<Author>> authorDataloader = dfe.getDataLoader("authors");
        Book book = dfe.getSource();

        return authorDataloader.load(book.getId());
    }

}
