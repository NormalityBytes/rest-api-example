package com.github.normalitybytes.training.rest.web.rest;

import com.github.normalitybytes.training.rest.model.Movie;
import com.github.normalitybytes.training.rest.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("movies")
public class MovieController {

    final MovieService service;

    MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    List<Movie> getAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    Movie getById(@PathVariable UUID id) {
        return service.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Movie postOne(@RequestBody Movie movie) {
        return service.addMovie(movie);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable UUID id) {
        service.removeMovie(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateMovie(@PathVariable UUID id, @RequestBody Movie movie) {
        service.updateMovie(id, movie);
    }

}
