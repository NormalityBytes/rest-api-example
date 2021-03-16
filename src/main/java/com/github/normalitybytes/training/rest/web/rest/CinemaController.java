package com.github.normalitybytes.training.rest.web.rest;

import com.github.normalitybytes.training.rest.model.Cinema;
import com.github.normalitybytes.training.rest.service.CinemaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "cinemas")
public class CinemaController {

    final CinemaService service;

    CinemaController(CinemaService service) {
        this.service = service;
    }

    @GetMapping
    List<Cinema> getAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    Cinema getById(@PathVariable UUID id) {
        return service.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Cinema postOne(@RequestBody Cinema cinema) {
        return service.addCinema(cinema);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable UUID id) {
        service.removeCinema(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateCinema(@PathVariable UUID id, @RequestBody Cinema cinema) {
        service.updateCinema(id, cinema);
    }

}
