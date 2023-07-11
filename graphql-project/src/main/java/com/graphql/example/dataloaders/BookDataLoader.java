package com.graphql.example.dataloaders;

import com.graphql.example.model.Book;
import com.graphql.example.service.BookService;
import com.netflix.graphql.dgs.DgsDataLoader;
import org.dataloader.MappedBatchLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@DgsDataLoader(name = "books")
public class BookDataLoader  implements MappedBatchLoader<Integer, List<Book>> {

    BookService bookService;
    public BookDataLoader(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public CompletionStage<Map<Integer, List<Book>>> load(Set<Integer> keys) {
        return CompletableFuture.supplyAsync(() ->  bookService.getByAuthorIds(new ArrayList<>(keys)));
    }
}
