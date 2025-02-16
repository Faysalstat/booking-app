package com.bookingapp.securityservice.exception;

public class OperationFailedException extends Exception {
    public OperationFailedException(String msg) {
        super(msg);
    }
}