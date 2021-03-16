package com.github.normalitybytes.training.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeSlot {

    UUID id = UUID.randomUUID();
    Cinema cinema;
    Movie movie;
    LocalDateTime time;
    int seatsAvailable;

}
