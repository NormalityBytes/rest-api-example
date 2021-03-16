package com.github.normalitybytes.training.rest.repository;

import com.github.normalitybytes.training.rest.model.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Slf4j
public class MovieRepository {

    final Map<UUID, Movie> data = new HashMap<>();

    public Movie saveOne(Movie item) {
        if (item == null) throw new NullPointerException("Item required");
        return data.put(item.getId(), item);
    }

    public Movie deleteOne(Movie item) {
        return deleteOne(item.getId());
    }

    public Movie deleteOne(UUID id) {
        return data.remove(id);
    }

    public Optional<Movie> findOne(UUID id) {
        return Optional.ofNullable(data.get(id));
    }

    public List<Movie> findAll() {
        return new ArrayList<>(data.values());
    }

    public boolean contains(UUID id) {
        return data.containsKey(id);
    }

}
