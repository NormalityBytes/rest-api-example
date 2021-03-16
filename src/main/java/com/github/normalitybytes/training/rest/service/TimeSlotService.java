package com.github.normalitybytes.training.rest.service;

import com.github.normalitybytes.training.rest.model.Cinema;
import com.github.normalitybytes.training.rest.model.Movie;
import com.github.normalitybytes.training.rest.model.TimeSlot;
import com.github.normalitybytes.training.rest.repository.ItemAlreadyPresentException;
import com.github.normalitybytes.training.rest.repository.ItemNotFoundException;
import com.github.normalitybytes.training.rest.repository.TimeSlotRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TimeSlotService {

    final TimeSlotRepository repository;
    final CinemaService cinemaService;
    final MovieService movieService;

    TimeSlotService(TimeSlotRepository repository, CinemaService cinemaService, MovieService movieService) {
        this.repository = repository;
        this.cinemaService = cinemaService;
        this.movieService = movieService;
    }

    public TimeSlot addTimeSlot(TimeSlot timeSlot) {
        if (repository.contains(timeSlot.getId())) throw new ItemAlreadyPresentException();

        // Prüft, ob Voraussetzungen erfüllt sind
        if (!checkValidCinema(timeSlot.getCinema())
                    || !checkValidMovie(timeSlot.getMovie())) {
            throw new ItemContentNotFoundException();
        }

        return repository.saveOne(timeSlot);
    }

    public void removeTimeSlot(UUID uuid) {
        if (repository.contains(uuid)) repository.deleteOne(uuid);
    }

    public void updateTimeSlot(UUID id, TimeSlot timeSlot) {
        if (!repository.contains(id)) throw new ItemNotFoundException();
        timeSlot.setId(id);


        // Prüft, ob Voraussetzungen erfüllt sind
        if (!checkValidCinema(timeSlot.getCinema())
                    || !checkValidMovie(timeSlot.getMovie())) {
            throw new ItemContentNotFoundException();
        }

        repository.saveOne(timeSlot);
    }

    public TimeSlot findOne(UUID id) {
        return repository.findOne(id).orElseThrow(ItemNotFoundException::new);
    }

    public List<TimeSlot> findAll() {
        return repository.findAll();
    }

    private boolean checkValidCinema(Cinema cinema) {
        // für den Anfang ist ein Cinema valide, gdw es im CinemaService bereits bekannt ist
        return cinemaService.findOne(cinema.getId()).equals(cinema);
    }

    private boolean checkValidMovie(Movie movie) {
        return movieService.findOne(movie.getId()).equals(movie);
    }
}
