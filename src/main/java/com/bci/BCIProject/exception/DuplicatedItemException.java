package com.bci.BCIProject.exception;

public class DuplicatedItemException extends RuntimeException{

    private String message;

    public DuplicatedItemException(String message, Throwable t){
        super(message, t);
        this.message = message;
    }
}
