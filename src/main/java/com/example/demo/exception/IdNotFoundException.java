package com.example.demo.exception;

public class IdNotFoundException extends RuntimeException {

    public IdNotFoundException(Long id, String className) {
        super("Id =" + id + " not found for " + className);
    }
}
