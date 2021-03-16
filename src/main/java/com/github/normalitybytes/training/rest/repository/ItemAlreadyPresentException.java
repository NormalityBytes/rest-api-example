package com.github.normalitybytes.training.rest.repository;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Item already present")
public class ItemAlreadyPresentException extends RuntimeException {
}
