package com.github.normalitybytes.training.rest.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Item contents not known in datastore")
public class ItemContentNotFoundException extends RuntimeException {
}
