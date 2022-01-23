package com.pawa.authservice.exception;

@SuppressWarnings("serial")
public class InValidTokenException extends RuntimeException {

    public InValidTokenException() {
        super();
    }

    public InValidTokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public InValidTokenException(String message) {
        super(message);
    }

}