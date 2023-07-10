package com.graphql.example.dataloaders;

import com.graphql.example.model.Author;
import com.graphql.example.service.AuthorService;
import com.netflix.graphql.dgs.DgsDataLoader;
import org.dataloader.MappedBatchLoader;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@DgsDataLoader(name = "authors", maxBatchSize = 3)

public class AuthorDataLoader implements MappedBatchLoader<Integer, List<Author>> {

    AuthorService authorService;
    public AuthorDataLoader(AuthorService authorService) {
        this.authorService = authorService;

    }

    @Override
    public CompletionStage<Map<Integer, List<Author>>> load(Set<Integer> keys) {
        return CompletableFuture.supplyAsync(() ->  authorService.authorsForBooks(new ArrayList<>(keys)));
    }
}
