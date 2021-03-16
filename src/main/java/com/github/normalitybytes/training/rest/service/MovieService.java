package com.github.normalitybytes.training.rest.service;

import com.github.normalitybytes.training.rest.model.Movie;
import com.github.normalitybytes.training.rest.repository.MovieRepository;
import com.github.normalitybytes.training.rest.repository.ItemAlreadyPresentException;
import com.github.normalitybytes.training.rest.repository.ItemNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MovieService {

    final MovieRepository repository;

    MovieService(MovieRepository repository) { this.repository = repository; }

    public Movie addMovie(Movie movie) {
        if (repository.contains(movie.getId())) throw new ItemAlreadyPresentException();
        return repository.saveOne(movie);
    }

    public void removeMovie(UUID uuid) {
        if (repository.contains(uuid)) repository.deleteOne(uuid);
    }

    public void updateMovie(UUID id, Movie movie) {
        if (!repository.contains(id)) throw new ItemNotFoundException();
        movie.setId(id);
        repository.saveOne(movie);
    }

    public Movie findOne(UUID id) {
        return repository.findOne(id).orElseThrow(ItemNotFoundException::new);
    }

    public List<Movie> findAll() {
        return repository.findAll();
    }

}
