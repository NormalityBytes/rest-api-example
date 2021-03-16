package com.github.normalitybytes.training.rest.service;

import com.github.normalitybytes.training.rest.model.Cinema;
import com.github.normalitybytes.training.rest.repository.CinemaRepository;
import com.github.normalitybytes.training.rest.repository.ItemAlreadyPresentException;
import com.github.normalitybytes.training.rest.repository.ItemNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CinemaService {

    final CinemaRepository repository;

    CinemaService(CinemaRepository repository) { this.repository = repository; }

    public Cinema addCinema(Cinema cinema) {
        if (repository.contains(cinema.getId())) throw new ItemAlreadyPresentException();
        return repository.saveOne(cinema);
    }

    public void removeCinema(UUID uuid) {
        if (repository.contains(uuid)) repository.deleteOne(uuid);
    }

    public void updateCinema(UUID id, Cinema cinema) {
        if (!repository.contains(id)) throw new ItemNotFoundException();
        cinema.setId(id);
        repository.saveOne(cinema);
    }

    public Cinema findOne(UUID id) {
        return repository.findOne(id).orElseThrow(ItemNotFoundException::new);
    }

    public List<Cinema> findAll() {
        return repository.findAll();
    }

}
