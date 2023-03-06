package br.com.imobio.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AptOwnerNotFoundException extends RuntimeException {
    public AptOwnerNotFoundException(String message) {
        super(message);
    }
}
