package com.graphql.example.controller;

import com.graphql.example.dataloaders.AuthorDataLoader;
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

    @DgsData(parentType = "Book", field = "authors")
    public CompletableFuture<List<Author>> authors(DgsDataFetchingEnvironment dfe) {
        //Instead of loading a DataLoader by name, we can use the DgsDataFetchingEnvironment and pass in the DataLoader classname.
        DataLoader<Integer, List<Author>> authorDataloader = dfe.getDataLoader("authors");

        //Because the author field is on book, the getSource() method will return the book instance.
        Book book = dfe.getSource();

        //int bookId = dfe.getArgument("book_id");

        //Load the author from the DataLoader. This call is async and will be batched by the DataLoader mechanism.
        return authorDataloader.load(book.getId());
    }

}
