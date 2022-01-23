package com.pawa.authservice.exception;

@SuppressWarnings("serial")
public class UsernameExistException extends RuntimeException {

    public UsernameExistException() {
        super();
    }

    public UsernameExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameExistException(String message) {
        super(message);
    }
}

