package com.adityadarji.backend.exception;

public class OutOfStockException extends RuntimeException {
    public OutOfStockException(String message) {
        super(message);
    }

}
