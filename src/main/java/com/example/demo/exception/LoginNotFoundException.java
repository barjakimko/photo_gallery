package com.example.demo.exception;

public class LoginNotFoundException extends RuntimeException {

    public LoginNotFoundException(String login, String className) {
        super("Login =" + login + " not found for " + className);
    }
}
