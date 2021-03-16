package com.github.normalitybytes.training.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cinema {

    UUID id = UUID.randomUUID();
    String name;
    int seats;

}
