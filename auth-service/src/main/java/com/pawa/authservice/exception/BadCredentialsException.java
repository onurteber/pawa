package com.pawa.authservice.exception;

@SuppressWarnings("serial")
public class BadCredentialsException extends RuntimeException {

    public BadCredentialsException() {
        super();
    }

    public BadCredentialsException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadCredentialsException(String message) {
        super(message);
    }

}