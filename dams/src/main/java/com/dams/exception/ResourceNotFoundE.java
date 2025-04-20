package com.dams.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
public class ResourceNotFoundE extends RuntimeException {
    public ResourceNotFoundE(String message) {
        super(message);
    }


}
