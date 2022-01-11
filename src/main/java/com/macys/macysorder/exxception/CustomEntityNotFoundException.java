package com.macys.macysorder.exxception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)

public class CustomEntityNotFoundException extends RuntimeException {

    @Override
    public String toString() {
        return "No record found with given id.";
    }
}
