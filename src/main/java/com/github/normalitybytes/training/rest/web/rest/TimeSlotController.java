package com.github.normalitybytes.training.rest.web.rest;

import com.github.normalitybytes.training.rest.model.TimeSlot;
import com.github.normalitybytes.training.rest.service.TimeSlotService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("timeslots")
public class TimeSlotController {

    final TimeSlotService service;

    TimeSlotController(TimeSlotService service) {
        this.service = service;
    }

    @GetMapping
    List<TimeSlot> getAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    TimeSlot getById(@PathVariable UUID id) {
        return service.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    TimeSlot postOne(@RequestBody TimeSlot timeSlot) {
        return service.addTimeSlot(timeSlot);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable UUID id) {
        service.removeTimeSlot(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateTimeSlot(@PathVariable UUID id, @RequestBody TimeSlot timeSlot) {
        service.updateTimeSlot(id, timeSlot);
    }

}
