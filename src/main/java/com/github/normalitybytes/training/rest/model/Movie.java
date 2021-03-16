package com.github.normalitybytes.training.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    UUID id = UUID.randomUUID();
    String title;
    int runtime;

}
