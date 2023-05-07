package com.ecommerce.EcommerceApi.dao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

    private static final Integer serialVersionUID = 1;

    public ResourceNotFoundException(String message, String id) {
        super(message);
    }
}
